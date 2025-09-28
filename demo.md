# HC 2025-26 Coding Exercises

This repository contains my solutions for the HC 2025-26 Coding Exercises.

It includes:

* **Exercise 1 – Design Patterns**
  Demonstrations of **Behavioral, Creational, and Structural Design Patterns** applied in a **Medication Reminder System**.
  Example file: `MedicationAppAllPatterns.java` (showcases **Observer, Strategy, Factory, Builder, Decorator, and Adapter patterns**).

* **Exercise 2 – Mini-Project: Astronaut Daily Schedule Organizer**
  A console-based CRUD application that helps astronauts manage daily tasks efficiently.
  Main file: `AstronautScheduler.java`

---

## Project Structure

```
/ (root)
 ├── MedicationAppAllPatterns.java   # Demonstrates design pattern use case (Exercise 1)
 ├── AstronautScheduler.java         # Main mini-project application (Exercise 2)
 └── README.md                       # Project documentation
```

---

## 1. Design Pattern Demonstration – Medication Reminder System

`MedicationAppAllPatterns.java` is a console application that demonstrates multiple design patterns in a medication reminder system.

It includes:

* **Observer Pattern** – Sends reminders to users.
* **Strategy Pattern** – Allows multiple reminder types (App / Email).
* **Factory Pattern** – Creates medications (pill, liquid, injection, old).
* **Builder Pattern** – Builds a medication schedule.
* **Decorator Pattern** – Adds tracking/logging of medications.
* **Adapter Pattern** – Adapts legacy medication data.

### Requirements

* Java 17 or later
* Any IDE (IntelliJ, Eclipse, VS Code) or terminal
* No build tool required → Direct compile & run

```bash
javac MedicationAppAllPatterns.java
java MedicationAppAllPatterns
```

---

## 2. Astronaut Daily Schedule Organizer

A console-based Java application to help astronauts manage daily schedules and tasks efficiently.

### Features

* Add tasks (description, start time, end time, priority).
* Remove tasks by description.
* View tasks (sorted by start time).
* Prevent overlapping tasks with validation.
* Handle invalid inputs with clear error messages.

### Design Patterns Used

* **Singleton** → `ScheduleManager` ensures only one instance manages all tasks.
* **Factory** → `TaskFactory` standardizes creation of `Task` objects.
* **Observer** → Alerts user when new task conflicts with an existing one.

### Additional Features

* Edit existing tasks
* Mark tasks as completed
* View tasks filtered by priority
* Logging to `astronaut_schedule.log`

---

## How to Run

```bash
# Compile
javac AstronautScheduler.java
javac MedicationAppAllPatterns.java

# Run Astronaut Scheduler
java AstronautScheduler

# Run Medication Reminder System
java MedicationAppAllPatterns
```

---

## Sample Console Interaction – AstronautScheduler

### Adding a Task

```
Choose an option: 1
Description: Morning Exercise
Start time (HH:mm): 07:00
End time (HH:mm): 08:00
Priority (High/Medium/Low): High
Task added successfully. No conflicts.
```

### Handling Conflict

```
Choose an option: 1
Description: Training Session
Start time (HH:mm): 07:30
End time (HH:mm): 08:30
Priority (High/Medium/Low): High
Error: Task conflicts with existing task "Morning Exercise".
```

### Viewing Tasks

```
Choose an option: 3
07:00 - 08:00: Morning Exercise [HIGH]
```

### Editing a Task

```
Choose an option: 4
Description of task to edit: Morning Exercise
New description: Morning Workout
New start time (HH:mm): 06:30
New end time (HH:mm): 07:30
New priority (High/Medium/Low): High
Task updated successfully.
```

---

## Positive Test Cases

1. **Add Task**

```
Enter task title: Morning Exercise
Start time (HH:mm): 07:00
End time (HH:mm): 08:00
Priority: High
Task added successfully. No conflicts.
```

2. **View Tasks**

```
07:00 - 08:00: Morning Exercise [High]
09:00 - 10:00: Team Meeting [Medium]
```

3. **Remove Task**

```
Task "Morning Exercise" removed successfully.
```

---

## Negative Test Cases

1. **Conflict Check**

```
Error: Task conflicts with existing task "Team Meeting".
```

2. **Invalid Time**

```
Error: Invalid time format.
```

3. **Remove Invalid Task**

```
Error: Invalid task number.
```

---

## Sample Output – MedicationAppAllPatterns

### User Input

```
Enter your name: Mercy
Enter your age: 30
How many medications do you want to enter? 3
Enter medication type (pill/liquid/injection/old): pill
Enter medication name: Paracetamol
Enter dosage: 500mg
Enter medication type: liquid
Enter medication name: Cough Syrup
Enter dosage: 10ml
Enter medication type: old
Enter old format medication info: Ibuprofen - 200mg
Choose reminder type (app/email): app
```

### Expected Output

```
=== Observer Pattern Test ===
Mercy (30 years) received reminder: Time to take your morning medication!

=== Strategy Reminder Test ===
App Reminder for Mercy: Take Paracetamol
App Reminder for Mercy: Take Cough Syrup
App Reminder for Mercy: Take Ibuprofen

=== Medication Factory Test ===
Taking pill: Paracetamol (500mg)
Taking liquid: Cough Syrup (10ml)
Taking adapted medication: Ibuprofen (200mg)

=== Builder + Decorator Pattern Test ===
User's Medication Schedule:
Taking pill: Paracetamol (500mg)
 -> Dose tracked for: Paracetamol
Taking liquid: Cough Syrup (10ml)
 -> Dose tracked for: Cough Syrup
Taking adapted medication: Ibuprofen (200mg)
 -> Dose tracked for: Ibuprofen

=== Adapter Pattern Test ===
Adapted Medication: Taking adapted medication: Ibuprofen (200mg)
```

---

## Summary

This project demonstrates core object-oriented design patterns and Java console-based CRUD applications through:

* **Exercise 1 – Medication Reminder System**
* **Exercise 2 – Astronaut Daily Schedule Organizer**

Both exercises emphasize design principles, clean code, error handling, and practical applications.

---
