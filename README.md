# MTI Event Pipeline Demo

This project is a Java/Spring Boot demo designed to simulate a production-style event processing pipeline inspired by real-world systems.

The system models a simplified webinar data flow:

```
External Webinar System → Java API → Processing Layer → Database → CRM Sync
```

---

## 🎯 Goals

- Demonstrate Java and Spring Boot fundamentals
- Show troubleshooting and debugging practices
- Document architecture and operational decisions
- Simulate legacy-style issues and progressive refactoring
- Provide a portfolio-ready project aligned with real problem scenarios

---

## 🧰 Tech Stack

- Java 17
- Spring Boot
- Maven
- PostgreSQL (planned)
- REST APIs
- Docker Compose (planned)
- Spring Boot Actuator
- Structured logging (planned)

---

## 📊 Project Status

Current phase:

- ✅ Initial Spring Boot setup
- ✅ Health check endpoint
- ✅ Basic API endpoint
- ✅ Event ingestion endpoint with validation
- ⏳ Database integration (next)
- ⏳ Processing layer
- ⏳ CRM sync simulation
- ⏳ Troubleshooting scenarios

---

## 🚀 Running the Project

### Build

```bash
mvn clean verify
```

If database is not configured yet:

```bash
mvn clean verify -DskipTests
```

### Run

```bash
mvn spring-boot:run
```

Application will start on:

```
http://localhost:8080
```

---

## 🔌 Available Endpoints

### Health Check

```
GET /health
```

Response example:

```json
{
  "status": "UP",
  "timestamp": "2026-05-05T..."
}
```

---

### Test Endpoint

```
GET /api/events/test
```

Response:

```json
{
  "message": "Event pipeline is working"
}
```

---

### Event Ingestion

```
POST /api/events
```

Receives a webinar attendance event.

#### Example request

```json
{
  "webinarId": "WEB-1001",
  "attendeeName": "Test User",
  "attendeeEmail": "test@example.com",
  "durationMinutes": 42
}
```

#### Successful response

```json
{
  "status": "ACCEPTED",
  "webinarId": "WEB-1001",
  "attendeeEmail": "test@example.com",
  "receivedAt": "2026-05-05T..."
}
```

#### Validation behavior

Invalid input will return:

```
400 Bad Request
```

---

## 🧠 Design Decisions (So Far)

### 1. No Database Yet

The datasource auto-configuration is temporarily disabled to allow incremental development of the API layer before introducing persistence.

This approach allows:

- Faster iteration
- Isolated API testing
- Clear commit history of system evolution

---

### 2. DTO Validation

Validation is handled at the API boundary using:

- `@NotBlank`
- `@Email`
- `@PositiveOrZero`

This ensures:

- Clean inputs
- Early error detection
- Predictable API behavior

---

### 3. API-First Approach

We first model how data enters the system before deciding how it is stored or processed.

This reflects real-world backend design where:

- APIs define contracts
- Data flow is validated early

---

## 🔍 Troubleshooting Notes

### Build fails due to datasource

If you see:

```
Failed to configure a DataSource
```

It means the application expects a database configuration.

Temporary solution:

- Disable datasource auto-configuration
- Or run build without tests:

```bash
mvn clean verify -DskipTests
```

---

## 📁 Project Structure (Simplified)

```
event-pipeline/
├── controller/
├── dto/
├── application/
└── resources/
```

---

## 🧭 Next Steps

- Add PostgreSQL integration
- Introduce entity and repository layer
- Implement processing service
- Simulate external integrations (CRM)
- Add structured logging
- Introduce failure scenarios for debugging practice

---

## 🏁 Purpose

This repository is designed not only as a demo, but as a **technical storytelling artifact**:

- Each commit represents a step in system evolution
- Each feature answers a real problem in application development
- The project demonstrates how to think, not just how to code

---

**Author:** Santiago Da Silva

