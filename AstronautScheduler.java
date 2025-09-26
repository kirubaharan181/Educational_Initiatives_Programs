import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

// ---------- Task Class ----------
class Task {
    String title;
    LocalTime start;
    LocalTime end;
    String priority;

    Task(String title, LocalTime start, LocalTime end, String priority) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.priority = priority;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
        return start.format(fmt) + " - " + end.format(fmt) + ": " + title + " [" + priority + "]";
    }
}

// ---------- Factory Pattern ----------
class TaskFactory {
    public static Task createTask(String title, String startStr, String endStr, String priority) throws Exception {
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime start = LocalTime.parse(startStr, fmt);
            LocalTime end = LocalTime.parse(endStr, fmt);

            if (!start.isBefore(end)) {
                throw new Exception("Start time must be before end time.");
            }

            priority = priority.substring(0, 1).toUpperCase() + priority.substring(1).toLowerCase();
            if (!(priority.equals("High") || priority.equals("Medium") || priority.equals("Low"))) {
                throw new Exception("Priority must be High, Medium, or Low.");
            }

            return new Task(title, start, end, priority);
        } catch (DateTimeParseException e) {
            throw new Exception("Invalid time format.");
        }
    }
}

// ---------- Observer Pattern ----------
interface ScheduleObserver {
    void notifyConflict(Task newTask, Task existing);
}

class ConsoleNotifier implements ScheduleObserver {
    public void notifyConflict(Task newTask, Task existing) {
        System.out.println("Error: Task conflicts with existing task \"" + existing.title + "\".");
    }
}

// ---------- Singleton ScheduleManager ----------
class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private ScheduleObserver observer;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void setObserver(ScheduleObserver obs) {
        this.observer = obs;
    }

    public String addTask(Task newTask) {
        for (Task t : tasks) {
            if (overlap(newTask, t)) {
                if (observer != null) observer.notifyConflict(newTask, t);
                return "";
            }
        }
        tasks.add(newTask);
        tasks.sort(Comparator.comparing(a -> a.start));
        return "Task added successfully. No conflicts.";
    }

    public String removeTaskByNumber(int index) {
        if (tasks.isEmpty()) {
            return "Error: No tasks scheduled for the day.";
        }
        if (index < 1 || index > tasks.size()) {
            return "Error: Invalid task number.";
        }
        Task removed = tasks.remove(index - 1);
        return "Task \"" + removed.title + "\" removed successfully.";
    }

    public String viewTasks() {
        if (tasks.isEmpty()) return "No tasks scheduled for the day.";
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Task t : tasks) {
            sb.append(i++).append(". ").append(t.toString()).append("\n");
        }
        return sb.toString().trim();
    }

    private boolean overlap(Task a, Task b) {
        return a.start.isBefore(b.end) && b.start.isBefore(a.end);
    }

    public int getTaskCount() {
        return tasks.size();
    }
}

// ---------- Main Program ----------
public class AstronautScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.setObserver(new ConsoleNotifier());

        boolean exit = false;

        while (!exit) {
            System.out.println("\n Astronaut Daily Schedule Organizer");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = -1;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter task title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter start time (HH:mm): ");
                        String start = sc.nextLine();
                        System.out.print("Enter end time (HH:mm): ");
                        String end = sc.nextLine();
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String priority = sc.nextLine();

                        Task t = TaskFactory.createTask(title, start, end, priority);
                        String result = manager.addTask(t);
                        if (!result.isEmpty()) System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println(manager.viewTasks());
                    break;

                case 3:
                    if (manager.getTaskCount() == 0) {
                        System.out.println("No tasks scheduled for the day.");
                        break;
                    }
                    System.out.println("Select the task number to remove:");
                    System.out.println(manager.viewTasks());
                    try {
                        System.out.print("Enter task number: ");
                        int num = Integer.parseInt(sc.nextLine());
                        System.out.println(manager.removeTaskByNumber(num));
                    } catch (Exception e) {
                        System.out.println("Error: Invalid input.");
                    }
                    break;

                case 4:
                    exit = true;
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
