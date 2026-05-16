# Sudoku Validator — Low Level Design (LLD) in Java

## Overview

This project demonstrates a professional Low Level Design (LLD) implementation of a Sudoku Validator system in Java using Object-Oriented Design principles and Design Patterns.

The project is inspired by the article:

Practical Objects: A Beginning Approach to Object-Oriented Design

The main objective of this project is not just Sudoku validation, but understanding:

- Practical Object-Oriented Design
- Encapsulation
- Abstraction
- Composition
- SOLID Principles
- Design Patterns
- Maintainable architecture
- Extensible system design

---

# Problem Statement

A newspaper editor receives Sudoku puzzles from external contractors.

Some puzzles are invalid due to:
- duplicate numbers in rows
- duplicate numbers in columns
- duplicate numbers in 3x3 squares

We need a system that:
- validates Sudoku boards
- is extensible
- is maintainable
- avoids overengineering
- follows clean design principles

---

# Functional Requirements

The system should:

- Validate rows
- Validate columns
- Validate 3x3 squares
- Support partially filled Sudoku boards
- Ignore empty cells represented by `0`

---

# Non Functional Requirements

- Clean architecture
- Extensible design
- Easy unit testing
- Low coupling
- High cohesion
- Reusable validators

---

# Project Structure

```text
sudoku/
│
├── model/
│   ├── Cell.java
│   └── SudokuBoard.java
│
├── validator/
│   ├── SudokuValidator.java
│   ├── RowValidator.java
│   ├── ColumnValidator.java
│   ├── SquareValidator.java
│   └── CompositeValidator.java
│
├── factory/
│   └── SudokuFactory.java
│
├── util/
│   └── SudokuPrinter.java
│
├── data/
│   └── PuzzleData.java
│
├── docs/
│   └── diagrams/
│       └── sudoku-class-diagram.puml
│
└── Main.java
```

---

# Core Concepts Used

| Concept | Usage |
|---|---|
| OOP | Entire architecture |
| Encapsulation | SudokuBoard hides board logic |
| Abstraction | SudokuValidator interface |
| Composition | CompositeValidator contains validators |
| Polymorphism | Multiple validators implement same interface |
| SOLID | Applied throughout design |
| Design Patterns | Strategy, Composite, Factory |

---

# Entity Explanation

---

# 1. Cell

```java
public class Cell
```

Represents a single Sudoku cell.

## Responsibility

- Store value
- Validate value range
- Represent empty cells

## Why Needed?

Initially integers may seem enough.

But in real systems cells may later support:
- candidate values
- locking
- highlighting
- metadata
- validation state

This is proper Domain Modeling.

---

# 2. SudokuBoard

```java
public class SudokuBoard
```

Represents the complete Sudoku board.

## Responsibilities

- Store cells
- Provide row access
- Provide column access
- Provide square access

## Why Needed?

Without this class:
- validation logic gets duplicated
- indexing logic spreads everywhere
- maintenance becomes difficult

This class centralizes board operations.

---

# 3. SudokuValidator

```java
public interface SudokuValidator
```

Defines validation contract.

## Responsibility

Provide common validation behavior.

```java
boolean validate(SudokuBoard board)
```

## Why Needed?

Enables:
- polymorphism
- extensibility
- interchangeable validators

---

# 4. RowValidator

```java
public class RowValidator
```

## Responsibility

Checks duplicates in rows.

## Validation Logic

- Iterate through rows
- Use HashSet
- Ignore zeros
- Detect duplicates

---

# 5. ColumnValidator

```java
public class ColumnValidator
```

## Responsibility

Checks duplicates in columns.

---

# 6. SquareValidator

```java
public class SquareValidator
```

## Responsibility

Checks duplicates in 3x3 squares.

---

# 7. CompositeValidator

```java
public class CompositeValidator
```

Combines multiple validators together.

## Responsibilities

- Execute all validators
- Aggregate validation results

---

# 8. SudokuFactory

```java
public class SudokuFactory
```

Centralized object creation.

## Responsibilities

- Create configured validator pipeline

---

# 9. SudokuPrinter

```java
public class SudokuPrinter
```

## Responsibility

Display Sudoku board properly.

## Why Separate?

Printing is not business logic.

This follows:
- Single Responsibility Principle

---

# 10. PuzzleData

Contains sample puzzles for testing.

---

# Design Patterns Used

---

# 1. Strategy Pattern

## Classes

```text
SudokuValidator
    ↑
    ├── RowValidator
    ├── ColumnValidator
    └── SquareValidator
```

## Why Used?

Each validator is an independent algorithm.

## Benefits

- Easy extension
- Independent testing
- Loose coupling
- Flexible validation system

---

# 2. Composite Pattern

## Class

```text
CompositeValidator
```

## Why Used?

Combines multiple validators into one validator.

Internally:

```java
for (SudokuValidator validator : validators)
```

## Benefits

- Validator orchestration
- Reusable validation pipeline
- Plug-and-play validators

---

# 3. Factory Pattern

## Class

```text
SudokuFactory
```

## Why Used?

Centralized object creation.

Without factory:

```java
new RowValidator()
new ColumnValidator()
new SquareValidator()
```

everywhere.

With factory:

```java
SudokuFactory.createValidator()
```

## Benefits

- Cleaner code
- Easier configuration
- Better maintainability

---

# SOLID Principles Used

---

# S — Single Responsibility Principle

Each class has one responsibility.

| Class | Responsibility |
|---|---|
| Cell | Cell state |
| SudokuBoard | Board access |
| RowValidator | Row validation |
| Printer | Display |

---

# O — Open Closed Principle

Open for extension.
Closed for modification.

Example:
New validator can be added without changing existing validators.

```java
DiagonalValidator
```

---

# L — Liskov Substitution Principle

All validators can replace:

```java
SudokuValidator
```

without affecting system behavior.

---

# I — Interface Segregation Principle

Small focused interface:

```java
validate()
```

instead of large interfaces.

---

# D — Dependency Inversion Principle

System depends on abstraction:

```java
SudokuValidator
```

instead of concrete implementations.

---

# UML Class Diagram

```text
+----------------------+
| SudokuValidator      |
+----------------------+
| + validate()         |
+----------------------+
          ▲
          |
 -----------------------------
 |            |              |
 ▼            ▼              ▼

RowValidator ColumnValidator SquareValidator

          ▲
          |
CompositeValidator

SudokuBoard --> Cell
```

---

# Validation Flow

```text
Main
  ↓
SudokuFactory
  ↓
CompositeValidator
  ↓
RowValidator
ColumnValidator
SquareValidator
  ↓
SudokuBoard
```

---

# Why This Design Is Good

## High Cohesion

Each class has focused logic.

## Low Coupling

Validators depend only on board abstraction.

## Extensible

Easy to add:
- diagonal validation
- killer sudoku
- solver
- puzzle generator

## Testable

Every validator can be tested independently.

---

# Example Future Extension

Suppose business requirement changes:

Validate diagonal Sudoku.

We simply add:

```java
DiagonalValidator implements SudokuValidator
```

and register it in factory.

No changes required in:
- RowValidator
- ColumnValidator
- SudokuBoard

This is excellent extensibility.

---

# Time Complexity

## Row Validation

```text
O(9 × 9)
```

## Column Validation

```text
O(9 × 9)
```

## Square Validation

```text
O(9 × 9)
```

## Overall Complexity

```text
O(243)
```

Practically constant time.

---

# Why We Avoided Overengineering

We intentionally avoided:
- Spring Boot
- Databases
- Microservices
- Dependency Injection frameworks
- Event systems

Because:
- unnecessary for current problem
- increases accidental complexity

Good design means:
- solving today's problem cleanly
- preparing reasonably for tomorrow

---

# Important Design Philosophy

The biggest lesson from this project:

## Start Simple

Do NOT introduce:
- abstractions
- factories
- patterns
- inheritance

unless complexity requires them.

Good software evolves gradually.

---

# Sample Output

```text
-------------------------
| 4 3 5 | 2 6 9 | 7 8 1 |
| 6 8 2 | 5 7 1 | 4 9 3 |
| 1 9 7 | 8 3 4 | 5 6 2 |
-------------------------

Valid Board: true
```

---

# How to Run

## Compile

```bash
javac sudoku/**/*.java
```

## Run

```bash
java sudoku.Main
```

---

# Future Improvements

Possible extensions:

- Sudoku Solver
- Puzzle Generator
- REST API
- Spring Boot integration
- UI visualization
- Multiplayer Sudoku
- Persistence layer
- Constraint propagation
- Backtracking algorithm

---

# Key Learning Outcomes

This project teaches:

- Real-world Object-Oriented Design
- Practical abstraction
- Clean architecture
- Design patterns
- SOLID principles
- Composition over inheritance
- Extensible design
- Maintainable code structure

---

# Final Takeaway

This project is NOT about Sudoku.

It is about:

## Thinking Like a Software Designer

Good engineering means:
- practical decisions
- gradual evolution
- maintainable abstractions
- solving problems cleanly

That is the essence of professional Object-Oriented Design.