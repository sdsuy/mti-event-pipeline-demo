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
- PostgreSQL
- REST APIs
- Docker Compose
- Spring Boot Actuator
- Structured logging (planned)

---

## 📊 Project Status

Current phase:

- ✅ Initial Spring Boot setup
- ✅ Health check endpoint
- ✅ Basic API endpoint
- ✅ Event ingestion endpoint with validation
- ✅ PostgreSQL integration with Docker Compose
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

### 1. PostgreSQL from Early Development

The project now uses PostgreSQL through Docker Compose to simulate a real backend environment.

This helps demonstrate:

- Local infrastructure setup
- Real datasource configuration
- JPA entity mapping
- Repository-based persistence

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

It usually means PostgreSQL is not running or the datasource URL/credentials are incorrect.

Start the database with:

```bash
docker compose up -d
```

Then run:

```bash
mvn clean verify
```

---

### Check running containers

```bash
docker ps
```

---

### Stop database

```bash
docker compose down
```

---

## 📁 Project Structure (Simplified)

```
event-pipeline/
├── docker-compose.yml
├── src/main/java/com/santiago/mti/eventpipeline/
│   ├── controller/
│   ├── dto/
│   ├── entity/
│   ├── repository/
│   └── EventPipelineApplication.java
└── src/main/resources/
    └── application.yml
```

---

## 🧭 Next Steps

- Introduce processing service layer
- Simulate CRM synchronization
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

