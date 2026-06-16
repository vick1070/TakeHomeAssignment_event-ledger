# Event Ledger – Distributed Service Assignment

## Overview

This project demonstrates a distributed microservice-style architecture using Spring Boot.

Services:
- account-service
- event-service
- event-gateway

The gateway forwards requests to downstream services and demonstrates service isolation and API communication.

---

## Architecture

```text
Client
 ↓
event-gateway (8080)
 ↓
 ├── account-service (8081)
 └── event-service (8082)
 ↓
Repository
```

---

## Services

### account-service
Responsibilities:
- Store account data
- Retrieve accounts
- Handle business logic

Endpoints:

```http
POST /accounts
GET /accounts
GET /accounts/{id}
```

---

### event-gateway

Responsibilities:
- Entry point
- Route requests
- Handle downstream errors

Endpoints:

```http
GET /health
GET /accounts
GET /accounts/{id}
GET /events
```

---

## Design Decisions

### API Design
REST endpoints were used for predictability and simplicity.

### Clean Service Boundaries
Gateway owns communication.
Account service owns business logic.

### Idempotency
GET endpoints are idempotent.

### Distributed Systems Thinking
Services communicate independently over HTTP.

### Observability
Status codes are propagated correctly.

### Tradeoffs
Synchronous communication chosen for simplicity.

---

## Running

Start account-service:

```bash
cd account-service
./mvnw spring-boot:run
```

Runs:
localhost:8081

Start gateway:

```bash
cd event-gateway
./mvnw spring-boot:run
```

Runs:
localhost:8080

Start event-service:

```bash
cd event-service
./mvnw spring-boot:run
```

Runs:
localhost:8082

---

## Example

Create account:

```json
{
  "accountNumber": "12345",
  "accountHolder": "Vikas",
  "balance": 5000
}
```

---

## Future Improvements

- Retry strategy
- Swagger/OpenAPI
- Docker
- Metrics
- Circuit breaker
- Logging