
# Coding Exercises – HC 2025-26

This repository contains my solutions for the **HC 2025-26 Coding Exercises**.
It includes:

1. **Exercise 1 – Design Patterns:**
   Demonstrations of Behavioral, Creational, and Structural design patterns.

   * Example file: `CricketApp.java` (used to showcase one of the patterns)

2. **Exercise 2 – Mini-Project:**
   **Astronaut Daily Schedule Organizer** – a console-based CRUD application that helps astronauts manage daily tasks efficiently.

   * Main file: `AstronautScheduler.java`

---

## 📂 Project Structure

```
/ (root)
 ├── CricketApp.java           # Demonstrates design pattern use case (Exercise 1)
 ├── AstronautScheduler.java   # Main mini-project app (Exercise 2)
 └── README.md                 # Project documentation
```

---

## 📝 1. Astronaut Daily Schedule Organizer

This is a **console-based Java application** that lets astronauts:

* ➕ Add new tasks with:

  * Description
  * Start Time
  * End Time
  * Priority Level (High / Medium / Low)
* ➖ Remove existing tasks
* 👀 View all tasks sorted by start time
* ⚠️ Prevent overlapping tasks (validation)
* ✅ Handle errors gracefully (e.g., invalid time, non-existent task)

###  Key Features

* **Singleton Pattern:** Only one `ScheduleManager` instance manages all tasks.
* **Factory Pattern:** `TaskFactory` creates Task objects.
* **Observer Pattern:** Alerts the user if a new task conflicts with existing tasks.
* **Exception Handling & Logging:** Errors are captured and logged cleanly.

---

## 🏏 2. Design Pattern Demonstration (CricketApp)

`CricketApp.java` is a **lightweight console application** that demonstrates how design patterns (like Factory, Observer, etc.) can be applied in another scenario.
It is part of **Exercise 1** to showcase creativity in implementing different patterns.

---

## ⚙️ Requirements

* **Language:** Java 17+
* **IDE/Editor:** IntelliJ IDEA / Eclipse / VS Code (or any Java-capable editor)
* **Build Tool:** Not required (simple `.java` compilation)
* **Console:** Application runs entirely in the terminal.

---

## ▶️ How to Run

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
5. Follow the on-screen menu instructions.

---

## 🖥️ Sample Console Interaction – AstronautScheduler

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

## 📌 Assumptions Made

* Time input uses **24-hour format** (HH:MM).
* Tasks are for **one day only**.
* Console input is kept **simple and text-based** for demonstration.

---

## 📚 Design & Code Quality

* Follows **SOLID principles**.
* Uses **design patterns** wherever applicable.
* Implements **defensive programming** and **validations** to avoid crashes.
* Code is **modular, readable, and commented** for easier walkthroughs.

---

## 🧪 Testing & Validation

* Tested against **positive** (valid inputs) and **negative** (invalid/overlapping tasks) cases as described in the original exercise PDF.
* Verified proper error messages and edge case handling.

---



Would you like me to **customize the README further** (for example, adding screenshots of the console output or a section on future enhancements)?
