# Notification System Low Level Design (LLD)

This project demonstrates a scalable and extensible Notification System in Java.

## Features

- Multiple notification channels
  - Email
  - SMS
  - Push Notification
- Retry mechanism
- Factory Design Pattern
- Strategy Design Pattern
- Extensible architecture
- SOLID principles

## Project Structure

- model
- channel
- strategy
- factory
- service

## Design Patterns Used

### 1. Factory Pattern
`NotificationChannelFactory` creates different notification channels dynamically.

### 2. Strategy Pattern
Retry behavior is configurable using strategies:
- `HighPriorityRetryStrategy`
- `NoRetryStrategy`

### 3. Registry Pattern
`NotificationDispatcher` maintains registered channels.

### 4. Open Closed Principle
New notification channels can be added without modifying existing logic.

## Class Responsibilities

### Notification
Represents a notification request.

### NotificationChannel
Common interface for all channels.

### EmailChannel / SmsChannel / PushChannel
Concrete implementations for delivery.

### RetryStrategy
Defines retry behavior.

### NotificationDispatcher
Responsible for routing and dispatching notifications.

## How to Run

```bash
cd src
javac com/binod/notification/**/*.java com/binod/notification/*.java
java com.binod.notification.Main
```

## Sample Output

```text
Attempt: 1
[EMAIL] Sending email to: binod@example.com
[EMAIL] Message: Your order #1234 has been shipped
Notification delivered successfully.
```

## UML

PlantUML file is available in docs/class-diagram.puml

## Future Improvements

- Kafka Integration
- RabbitMQ Support
- Database Persistence
- Scheduling
- User Preferences
- Rate Limiting
- Dead Letter Queue
- Async Processing