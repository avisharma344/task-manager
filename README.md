# Task Management REST API

## Overview
Task Management REST API built using **Spring Boot** with CRUD operations, DTOs, validation, global exception handling, pagination & sorting, and Swagger documentation.

## Tech Stack
- Java 22
- Spring Boot 3.5.9
- Spring Data JPA / Hibernate
- H2 Database
- Swagger / Springdoc OpenAPI
- Maven

## Features
- CRUD operations
- DTO-based architecture
- Input validation
- Global exception handling
- Pagination & sorting
- Swagger UI for testing

## API Endpoints
| Method | Endpoint | Description |
|--------|---------|------------|
| POST | `/api/tasks` | Create Task |
| GET | `/api/tasks` | Get All Tasks |
| GET | `/api/tasks/{id}` | Get Task by ID |
| PUT | `/api/tasks/{id}` | Update Task |
| DELETE | `/api/tasks/{id}` | Delete Task |
| GET | `/api/tasks/paged` | Get Tasks with Pagination & Sorting |

## Running the Project
1. Clone the repo:
```bash
git clone https://github.com/<your-username>/task-manager.git
```
2. Open in IDE (IntelliJ / Eclipse)
3. Build & run: mvn spring-boot:run
4. Swagger UI: http://localhost:8080/swagger-ui/index.html
