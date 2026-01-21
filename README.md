# Task Manager API

A simple **Task Management REST API** built with **Spring Boot**.  
This project allows creating, reading, updating, and deleting tasks with features like **pagination, sorting, and validation**.  
It uses an **H2 in-memory database**, making it easy to run locally without additional setup.

---

## 🚀 Features

- Create, Read, Update, Delete (CRUD) tasks  
- Pagination & Sorting support  
- Input validation using Spring Validation  
- Swagger UI for API documentation and testing  

---

## 🛠️ Tech Stack

- **Java 17**  
- **Spring Boot 3.5.x**  
- **Spring Data JPA**  
- **H2 In-Memory Database**  
- **Swagger UI (Springdoc OpenAPI)**  
- **Maven**  

---

## 📂 Folder Structure
```
task-manager/
│
├─ src/main/java/com/example/taskmanager/
│ ├─ controller/ # REST controllers
│ ├─ service/ # Service layer
│ ├─ model/ # Entity classes
│ ├─ repository/ # JPA Repositories
│ └─ TaskManagerApplication.java
│
├─ src/main/resources/
│ ├─ application.properties
│ └─ data.sql (optional sample data)
│
├─ pom.xml
└─ README.md
```
## ⚡ Getting Started (Run Locally)

1. **Clone the repository:**
```bash
git clone https://github.com/<your-username>/task-manager.git
cd task-manager

```
2. Build the project using Maven:
```bash
./mvnw clean package
```
3. Run the project:
```bash
java -jar target/taskmanager-0.0.1-SNAPSHOT.jar
```
4. Open Swagger UI in your browser:
```bash
http://localhost:8080/swagger-ui/index.html
```

