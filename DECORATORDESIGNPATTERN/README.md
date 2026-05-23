# Decorator Design Pattern in Java

---

# Introduction

Decorator Design Pattern is a Structural Design Pattern that allows behavior or functionality to be added dynamically to an object at runtime without modifying the original object's code.

Instead of creating many subclasses for every possible combination of features, the Decorator Pattern uses:

* Composition
* Wrapper classes
* Runtime object enhancement

This pattern is heavily used in real-world software systems where features need to be added dynamically.

---

# Why Decorator Pattern?

Suppose we are developing a Pizza Ordering System.

We have:

## Base Pizzas

* Margherita
* VegDelight
* FarmHouse

## Toppings

* Extra Cheese
* Mushroom
* Jalapeno
* Paneer
* Corn

Without Decorator Pattern, we may end up creating classes like:

```text
MargheritaWithCheese
MargheritaWithMushroom
MargheritaWithCheeseAndMushroom
VegDelightWithCheese
VegDelightWithCheeseAndJalapeno
```

This creates:

* Too many classes
* Difficult maintenance
* Poor scalability
* Tight coupling
* Code duplication

Decorator Pattern solves this problem elegantly.

---

# Core Idea of Decorator Pattern

Decorator wraps an existing object and adds additional behavior dynamically.

Example:

```java
BasePizza pizza =
    new ExtraCheese(
        new Mushroom(
            new Margherita()
        )
    );
```

Flow:

```text
Margherita Cost
    +
Mushroom Cost
    +
Extra Cheese Cost
```

Final object behaves like:

```text
Margherita + Mushroom + Extra Cheese
```

---

# Project Structure

```text
DECORATORDESIGNPATTERN/
│
├── src/
│   │
│   ├── BasePizza.java
│   ├── Margherita.java
│   ├── VegDelight.java
│   │
│   ├── ToppingDecorator.java
│   ├── ExtraCheese.java
│   ├── Mushroom.java
│   ├── Jalapeno.java
│   │
│   └── Main.java
│
├── decorator-design-pattern.puml
│
└── README.md
```

---

# Components of Decorator Pattern

Decorator Pattern mainly consists of four major components.

---

# 1. Component

## File

```text
BasePizza.java
```

## Responsibility

Defines the common interface or abstract class for all objects.

Example:

```java
public abstract class BasePizza {
    public abstract int cost();
}
```

Every pizza must implement:

```java
cost()
```

method.

---

# 2. Concrete Components

## Files

```text
Margherita.java
VegDelight.java
```

## Responsibility

These are actual base objects.

Example:

```java
public class Margherita extends BasePizza {

    @Override
    public int cost() {
        return 200;
    }
}
```

These represent real pizzas.

---

# 3. Decorator Abstract Class

## File

```text
ToppingDecorator.java
```

## Responsibility

Acts as parent class for all toppings.

Example:

```java
public abstract class ToppingDecorator extends BasePizza {

    BasePizza basePizza;

}
```

Most important point:

```text
ToppingDecorator HAS-A BasePizza
```

This composition relationship is the heart of Decorator Pattern.

---

# 4. Concrete Decorators

## Files

```text
ExtraCheese.java
Mushroom.java
Jalapeno.java
```

## Responsibility

Adds additional functionality dynamically.

Example:

```java
public class ExtraCheese extends ToppingDecorator {

    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 20;
    }
}
```

Decorator:

1. Delegates original behavior
2. Adds extra behavior

---

# Execution Flow

Suppose:

```java
BasePizza pizza =
    new ExtraCheese(
        new Mushroom(
            new Margherita()
        )
    );

System.out.println(pizza.cost());
```

---

# Step-by-Step Execution

## Step 1

```text
Margherita cost = 200
```

---

## Step 2

```text
Mushroom adds 30

200 + 30 = 230
```

---

## Step 3

```text
ExtraCheese adds 20

230 + 20 = 250
```

---

# Final Output

```text
250
```

---

# UML Relationships

## Inheritance Relationship

```text
Margherita IS-A BasePizza
ExtraCheese IS-A ToppingDecorator
```

---

## Composition Relationship

```text
ToppingDecorator HAS-A BasePizza
```

Decorator Pattern mainly relies on composition.

---

# PlantUML Diagram

Project includes:

```text
decorator-design-pattern.puml
```

Generate UML image:

```bash
plantuml decorator-design-pattern.puml
```

---

# Advantages of Decorator Pattern

---

## 1. Runtime Flexibility

Features can be added dynamically.

---

## 2. Avoids Class Explosion

Without decorator:

```text
PizzaWithCheese
PizzaWithCheeseAndCorn
PizzaWithCheeseAndPaneer
```

Thousands of combinations possible.

Decorator solves this problem.

---

## 3. Follows Open Closed Principle

Classes are:

* Open for extension
* Closed for modification

---

## 4. Better Reusability

Decorators can be reused with multiple objects.

---

## 5. Loose Coupling

Classes remain independent.

---

# Disadvantages

---

## 1. Too Many Small Classes

Large systems may contain many decorator classes.

---

## 2. Debugging Complexity

Nested wrapping becomes difficult.

Example:

```java
new Cheese(
    new Mushroom(
        new Jalapeno(
            new VegDelight()
        )
    )
);
```

---

# Design Principles Used

---

# 1. Open Closed Principle

Open for extension.

Closed for modification.

---

# 2. Composition Over Inheritance

Decorator Pattern heavily relies on composition.

Major interview topic.

---

# 3. Single Responsibility Principle

Each decorator handles only one responsibility.

---

# Real World Examples

---

# 1. Java IO Classes

```java
BufferedReader br =
    new BufferedReader(
        new FileReader("abc.txt")
    );
```

Here:

| Class          | Role               |
| -------------- | ------------------ |
| FileReader     | Concrete Component |
| BufferedReader | Decorator          |

---

# 2. Coffee Shop Billing System

Add-ons:

* Milk
* Chocolate
* Cream

act as decorators.

---

# 3. Notification Systems

Base notification:

```text
Email
```

Additional decorators:

```text
SMS
Slack
WhatsApp
```

---

# Interview Questions

---

# Q1. Why not use inheritance?

Inheritance causes:

* Class explosion
* Tight coupling
* Inflexibility

Decorator provides runtime flexibility.

---

# Q2. Which relationship is mainly used?

```text
HAS-A Relationship
```

through composition.

---

# Q3. Decorator Pattern belongs to which category?

```text
Structural Design Pattern
```

---

# Q4. Difference Between Strategy and Decorator?

| Strategy Pattern            | Decorator Pattern           |
| --------------------------- | --------------------------- |
| Changes algorithm           | Adds behavior               |
| Focus on behavior selection | Focus on feature extension  |
| Runtime strategy selection  | Runtime feature enhancement |
| Uses composition            | Uses composition            |

---

# How to Run

---

# Compile

```bash
javac *.java
```

---

# Run

```bash
java Main
```

---

# Expected Output

```text
Base Pizza: Margherita
Added Mushroom
Added Extra Cheese

Final Cost: 250
```

---

# Design Pattern Category

Decorator Pattern belongs to:

```text
Structural Design Patterns
```

Other Structural Patterns:

* Adapter
* Facade
* Bridge
* Composite
* Proxy

---

# Key Learning Outcomes

After completing this project you will understand:

* Runtime behavior extension
* Wrapper classes
* Composition over inheritance
* Structural design patterns
* Open Closed Principle
* Dynamic feature addition
* Real-world extensible system design
