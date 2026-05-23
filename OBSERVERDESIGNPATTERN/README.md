# Observer Design Pattern in Java

A complete Java implementation of the **Observer Design Pattern** using a real-time cricket score update system.

This project demonstrates how multiple objects can listen for changes in another object and automatically receive updates whenever the state changes.

---

# 📌 Table of Contents

1. Introduction
2. What is the Observer Design Pattern?
3. Why Use Observer Pattern?
4. Project Overview
5. Project Structure
6. Core Components
7. How the Project Works
8. Code Explanation
9. UML Diagram
10. How to Run the Project
11. Sample Output
12. Advantages
13. Disadvantages
14. Real-World Applications
15. Design Principles Used
16. Future Enhancements
17. Learning Resources
18. Author
19. License

---

# 📖 Introduction

The Observer Design Pattern is one of the most commonly used behavioral design patterns in software engineering.

It defines a **one-to-many dependency** between objects so that when one object changes its state, all dependent objects are notified automatically.

This project uses a cricket match score system to demonstrate the Observer Pattern in Java.

---

# 🧠 What is the Observer Design Pattern?

The Observer Pattern consists of:

* **Subject (Observable)** → The object being observed
* **Observers** → Objects that receive updates automatically

Whenever the subject changes its internal state, all registered observers are notified.

---

# 🎯 Why Use Observer Pattern?

The Observer Pattern is useful when:

* Multiple objects depend on another object
* Automatic updates are needed
* Loose coupling between objects is required
* Event-driven systems are being developed

---

# 🏏 Project Overview

This project simulates a cricket score notification system.

## Components

| Component           | Role                 |
| ------------------- | -------------------- |
| CricketData         | Subject / Observable |
| CurrentScoreDisplay | Observer             |
| AverageScoreDisplay | Observer             |
| Main                | Driver Class         |

Whenever the cricket score changes:

1. CricketData updates its values
2. All registered observers are notified
3. Display boards refresh automatically

---

# 📂 Project Structure

```bash
OBSERVERDESIGNPATTERN/
│
├── CricketData.java
├── CurrentScoreDisplay.java
├── AverageScoreDisplay.java
├── Observer.java
├── Subject.java
├── DisplayElement.java
└── Main.java
```

---

# ⚙️ Core Components

# 1️⃣ Subject Interface

The Subject interface defines methods for managing observers.

```java
public interface Subject {
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
}
```

## Responsibilities

* Register observers
* Remove observers
* Notify observers about updates

---

# 2️⃣ Observer Interface

The Observer interface defines the update method.

```java
public interface Observer {
    public void update(int runs, int wickets, float overs);
}
```

## Responsibilities

* Receive updated data from subject
* Perform actions after receiving updates

---

# 3️⃣ DisplayElement Interface

This interface contains the display method.

```java
public interface DisplayElement {
    public void display();
}
```

---

# 4️⃣ CricketData Class (Concrete Subject)

This class stores cricket score information.

```java
public class CricketData implements Subject {

    private ArrayList<Observer> observers;
    private int runs;
    private int wickets;
    private float overs;

    public CricketData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(runs, wickets, overs);
        }
    }
}
```

## Responsibilities

* Maintains observer list
* Stores cricket score details
* Sends notifications to all observers

---

# 👀 Observer Implementations

# 1️⃣ CurrentScoreDisplay

Displays the current score details.

## Features

* Shows runs
* Shows wickets
* Shows overs

### Example Output

```bash
Current Score Display:
Runs: 90
Wickets: 2
Overs: 10.2
```

---

# 2️⃣ AverageScoreDisplay

Calculates:

* Run rate
* Predicted score

### Example Output

```bash
Average Score Display:
Run Rate: 8.82
Predicted Score: 441
```

---

# 🔄 How the Project Works

```text
CricketData receives new score
            ↓
notifyObservers() called
            ↓
All observers receive update()
            ↓
Displays refresh automatically
```

---

# 🧩 Detailed Flow

## Step 1

The Main class creates the CricketData object.

## Step 2

Observer objects are created.

* CurrentScoreDisplay
* AverageScoreDisplay

## Step 3

Observers register themselves with CricketData.

## Step 4

Whenever scores change:

```java
cricketData.dataChanged();
```

## Step 5

CricketData calls:

```java
notifyObservers();
```

## Step 6

All observers receive updates automatically.

---

# 📊 UML Diagram

```text
                +------------------+
                |     Subject      |
                +------------------+
                | registerObserver |
                | removeObserver   |
                | notifyObservers  |
                +------------------+
                          ▲
                          |
                 +----------------+
                 |  CricketData   |
                 +----------------+
                          |
          ---------------------------------
          |                               |
          ▼                               ▼
+---------------------+      +----------------------+
| CurrentScoreDisplay |      | AverageScoreDisplay  |
+---------------------+      +----------------------+
| update()            |      | update()             |
| display()           |      | display()            |
+---------------------+      +----------------------+
```

---

# 🚀 How to Run the Project

## ✅ Prerequisites

* Java JDK 8 or above
* VS Code / IntelliJ / Eclipse

---

# 📥 Step 1: Clone Repository

```bash
git clone https://github.com/binodyadav6119/myprojects.git
```

---

# 📂 Step 2: Navigate to Project

```bash
cd myprojects/OBSERVERDESIGNPATTERN
```

---

# ⚡ Step 3: Compile Java Files

```bash
javac *.java
```

---

# ▶️ Step 4: Run Application

```bash
java Main
```

---

# 🖥️ Sample Output

```bash
Current Score Display:
Runs: 90
Wickets: 2
Overs: 10.2

Average Score Display:
Run Rate: 8.82
Predicted Score: 441
```

---

# ✅ Advantages of Observer Pattern

## 1. Loose Coupling

Subject and observers are independent.

## 2. Easy Scalability

New observers can be added easily.

## 3. Dynamic Updates

Observers receive updates automatically.

## 4. Reusability

Observers can be reused across systems.

## 5. Better Maintainability

Changes in subject do not affect observers heavily.

---

# ❌ Disadvantages

## 1. Too Many Notifications

Large numbers of observers may impact performance.

## 2. Memory Leaks

Observers not removed properly may remain in memory.

## 3. Debugging Complexity

Tracking notifications may become difficult.

---

# 🌍 Real-World Applications

Observer Pattern is used in:

* Weather applications
* Notification systems
* Stock market monitoring
* YouTube subscriptions
* Event listeners
* Chat applications
* Live score systems
* GUI frameworks
* MVC architecture

---

# 🏗️ Design Principles Used

This project follows important software engineering principles:

## 1. Program to Interfaces

Uses interfaces instead of concrete implementations.

## 2. Loose Coupling

Subject and observers are loosely connected.

## 3. Separation of Concerns

Each class has a single responsibility.

## 4. Open/Closed Principle

New observers can be added without modifying existing code.

---

# 🔮 Future Enhancements

Possible improvements:

* GUI implementation using Java Swing
* JavaFX support
* Real-time API integration
* Multi-threaded notifications
* WebSocket-based updates
* Mobile application integration

---

# 📚 Learning Resources

## Observer Pattern References

* [https://refactoring.guru/design-patterns/observer](https://refactoring.guru/design-patterns/observer)
* [https://en.wikipedia.org/wiki/Observer_pattern](https://en.wikipedia.org/wiki/Observer_pattern)
* [https://github.com/topics/observer-pattern](https://github.com/topics/observer-pattern)

---

# 👨‍💻 Author

Developed by:

## Binod Yadav

GitHub:

[https://github.com/binodyadav6119](https://github.com/binodyadav6119)

---

# 🤝 Contributing

Contributions are welcome.

## Steps to Contribute

1. Fork the repository
2. Create a new branch
3. Make your changes
4. Commit changes
5. Push branch
6. Create Pull Request

---

# 📄 License

This project is open-source and available under the MIT License.

---

# ⭐ Support

If you found this project useful:

* Give this repository a ⭐ on GitHub
* Share it with others
* Contribute improvements

---

# 🙌 Thank You

Thank you for checking out this Observer Design Pattern implementation.

Happy Coding 🚀
