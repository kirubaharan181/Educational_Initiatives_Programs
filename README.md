1**.

---

# HC 2025-26 Coding Exercises

This repository contains my solutions for the **HC 2025-26 Coding Exercises**.

It includes:

1. **Exercise 1 – Design Patterns:**
   Demonstrations of Behavioral, Creational, and Structural design patterns.
   Example file: `CricketApp.java` (used to showcase one of the patterns).

2. **Exercise 2 – Mini-Project:**
   **Astronaut Daily Schedule Organizer** – a console-based CRUD application that helps astronauts manage daily tasks efficiently.
   Main file: `AstronautScheduler.java`

---

## Project Structure

```
/ (root)
 ├── CricketApp.java           # Demonstrates design pattern use case (Exercise 1)
 ├── AstronautScheduler.java   # Main mini-project application (Exercise 2)
 └── README.md                 # Project documentation
```

---

## 1. Astronaut Daily Schedule Organizer

This is a console-based Java application that allows astronauts to:

* Add new tasks with:

  * Description
  * Start Time
  * End Time
  * Priority Level (High / Medium / Low)
* Remove existing tasks
* View all tasks sorted by start time
* Prevent overlapping tasks through validation
* Handle invalid inputs gracefully

### Key Features

* Singleton Pattern: Only one `ScheduleManager` instance manages all tasks.
* Factory Pattern: `TaskFactory` is used to create Task objects.
* Observer Pattern: Alerts the user if a new task conflicts with existing tasks.
* Exception Handling and Logging: Errors are handled cleanly and recorded as needed.

---

## 2. Design Pattern Demonstration (CricketApp)

`CricketApp.java` is a console application that demonstrates the use of design patterns in a cricket scenario.
It is part of Exercise 1 to showcase creativity in implementing different patterns.

---

## Requirements

* Java 17 or later
* Any Java-compatible IDE or text editor (IntelliJ IDEA, Eclipse, VS Code, etc.)
* No build tool required; direct compilation and execution from the terminal
* Console-based application

---

## How to Run

1. Clone the repository or download the `.java` files.
2. Open a terminal in the project folder.
3. Compile the Java files:

   ```bash
   javac AstronautScheduler.java
   javac CricketApp.java
   ```
4. Run the desired program:

   ```bash
   java AstronautScheduler
   ```

   or

   ```bash
   java CricketApp
   ```
5. Follow the instructions displayed in the console.

---

## Sample Console Interaction – AstronautScheduler

```
--- Astronaut Daily Schedule Organizer ---
1. Add Task
2. Remove Task
3. View All Tasks
4. Exit

Enter choice: 1
Enter Task Description: Morning Exercise
Enter Start Time (HH:MM): 07:00
Enter End Time (HH:MM): 08:00
Enter Priority (High/Medium/Low): High
Task added successfully. No conflicts.
```

---

## Positive and Negative Test Cases – AstronautScheduler

### Positive Cases

1. Add Task
   Enter task title: Morning Exercise
   Enter start time (HH:mm): 07:00
   Enter end time (HH:mm): 08:00
   Enter priority (High/Medium/Low): High
   Task added successfully. No conflicts.

2. Add Task
   Enter task title: Team Meeting
   Enter start time (HH:mm): 09:00
   Enter end time (HH:mm): 10:00
   Enter priority (High/Medium/Low): Medium
   Task added successfully. No conflicts.

3. View Tasks

4. 07:00 - 08:00: Morning Exercise [High]

5. 09:00 - 10:00: Team Meeting [Medium]

6. Remove Task
   Select the task number to remove:

7. 07:00 - 08:00: Morning Exercise [High]

8. 09:00 - 10:00: Team Meeting [Medium]
   Enter task number: 1
   Task "Morning Exercise" removed successfully.

---

### Negative Cases

1. Add Task
   Enter task title: Training Session
   Enter start time (HH:mm): 09:30
   Enter end time (HH:mm): 10:30
   Enter priority (High/Medium/Low): High
   Error: Task conflicts with existing task "Team Meeting".

2. Add Task
   Enter task title: Invalid Time Task
   Enter start time (HH:mm): 25:00
   Enter end time (HH:mm): 26:00
   Enter priority (High/Medium/Low): Low
   Error: Invalid time format.

3. View Tasks (when empty)
   No tasks scheduled for the day.

4. Remove Task (when empty)
   No tasks scheduled for the day.

5. Remove Task (invalid number)
   Select the task number to remove:

6. 09:00 - 10:00: Team Meeting [Medium]
   Enter task number: 5
   Error: Invalid task number.

---

## Sample Outputs – CricketApp (Exercise 1)

```
=== Score Update Test ===
Phone App: Runs = 45, Wickets = 1
TV Display: Runs = 45, Wickets = 1

=== Batting Style Test ===
Plays safe, takes singles.
Plays bold, hits boundaries!

=== Scoreboard Test ===
Score: 4/0

=== Player Creation Test ===
Rohit is a Batter.
Bumrah is a Bowler.
Jadeja is an All-Rounder.

=== Old Score Adapter Test ===
New Score: 120/3 in 15 overs

=== Player Stats Test ===
Basic Stats: Runs/Wickets
Economy Rate: 6.5
Strike Rate: 135.0
```

---

## Assumptions

* Time input uses 24-hour format (HH:MM).
* Tasks are organized for a single day only.
* Console input is kept simple and text-based for demonstration purposes.

---

## Code Quality

* Adheres to SOLID principles.
* Implements Behavioral, Creational, and Structural design patterns where required.
* Includes defensive programming and input validation.
* Code is modular, readable, and well-commented for easy walkthroughs.

---

## Testing

* Tested with valid and invalid inputs as outlined in the original problem statement.
* Verified that all mandatory requirements and edge cases are handled.

---

