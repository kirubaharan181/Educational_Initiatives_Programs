HC 2025-26 Coding Exercises

This repository contains my solutions for the HC 2025-26 Coding Exercises.

It includes:

Exercise 1 – Design Patterns:
Demonstrations of Behavioral, Creational, and Structural design patterns.
Example file: CricketApp.java (used to showcase one of the patterns).

Exercise 2 – Mini-Project:
Astronaut Daily Schedule Organizer – a console-based CRUD application that helps astronauts manage daily tasks efficiently.
Main file: AstronautScheduler.java

Project Structure
/ (root)
 ├── CricketApp.java           # Demonstrates design pattern use case (Exercise 1)
 ├── AstronautScheduler.java   # Main mini-project application (Exercise 2)
 └── README.md                 # Project documentation

1. Astronaut Daily Schedule Organizer

This is a console-based Java application that allows astronauts to:

Add new tasks with:

Description

Start Time

End Time

Priority Level (High / Medium / Low)

Remove existing tasks

View all tasks sorted by start time

Prevent overlapping tasks through validation

Handle invalid inputs gracefully

Key Features

Singleton Pattern: Only one ScheduleManager instance manages all tasks.

Factory Pattern: TaskFactory is used to create Task objects.

Observer Pattern: Alerts the user if a new task conflicts with existing tasks.

Exception Handling and Logging: Errors are handled cleanly and recorded as needed.

2. Design Pattern Demonstration (CricketApp)

CricketApp.java is a console application that demonstrates the use of design patterns in another scenario.
It is part of Exercise 1 to showcase the implementation of different software design patterns.

Requirements

Java 17 or later

Any Java-compatible IDE or text editor (IntelliJ IDEA, Eclipse, VS Code, etc.)

No build tool required; direct compilation and execution from the terminal

Console-based application

How to Run

Clone the repository or download the .java files.

Open a terminal in the project folder.

Compile the Java files:

javac AstronautScheduler.java
javac CricketApp.java


Run the desired program:

java AstronautScheduler


or

java CricketApp


Follow the instructions displayed in the console.

Sample Console Interaction – AstronautScheduler
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

Assumptions

Time input uses 24-hour format (HH:MM).

Tasks are organized for a single day only.

Console input is kept simple and text-based for demonstration purposes.

Code Quality

Adheres to SOLID principles.

Implements Behavioral, Creational, and Structural design patterns where required.

Includes defensive programming and input validation.

Code is modular, readable, and well-commented for easy walkthroughs.

Testing

Tested with valid and invalid inputs as outlined in the original problem statement.

Verified that all mandatory requirements and edge cases are handled.
