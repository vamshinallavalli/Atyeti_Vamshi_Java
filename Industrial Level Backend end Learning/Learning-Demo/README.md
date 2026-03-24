# 🚀 Task Management System - Spring Boot REST API

## 📌 Overview

This project is a **Task & Project Management System** built using **Spring Boot, Spring Data JPA, and MySQL**. It provides RESTful APIs to manage users, projects, and tasks with proper relationships, pagination, and filtering.

The application demonstrates **clean architecture, scalable design, and real-world backend development practices**, making it suitable for production-level understanding and interviews.

---

## 🛠️ Tech Stack

* **Java 17+**
* **Spring Boot**
* **Spring Web (REST APIs)**
* **Spring Data JPA (Hibernate)**
* **MySQL**
* **Maven**
* **Lombok**

---

## 📁 Project Structure

```
com.example.taskmanager
│
├── controller        # REST Controllers
├── service           # Business Logic
├── repository        # JPA Repositories
├── entity            # Database Entities
├── dto               # Data Transfer Objects (Optional)
├── exception         # Global Exception Handling
└── mapper            # DTO ↔ Entity Mapping
```

---

## ⚙️ Features

* ✅ User Management (Create, Fetch)
* ✅ Project Management (Create, View)
* ✅ Task Management (CRUD Operations)
* ✅ Task Assignment to Users
* ✅ Filtering (by status, priority, project)
* ✅ Pagination & Sorting
* ✅ Exception Handling (`@ControllerAdvice`)
* ✅ Validation (`@Valid`)
* ✅ Layered Architecture (Controller → Service → Repository)

---

## 🧩 Entity Relationships

* **User → Project** (One-to-Many)
* **Project → Task** (One-to-Many)
* **User → Task** (One-to-Many)

---

## 🌐 API Endpoints

### 👤 User APIs

* `POST /users` → Create User
* `GET /users` → Get All Users

### 📁 Project APIs

* `POST /projects` → Create Project
* `GET /projects` → Get All Projects
* `GET /projects/{id}` → Get Project by ID

### ✅ Task APIs

* `POST /tasks` → Create Task
* `GET /tasks?page=0&size=5` → Get All Tasks (Pagination)
* `GET /tasks/status/{status}` → Filter by Status
* `GET /tasks/priority/{priority}` → Filter by Priority
* `GET /tasks/project/{projectId}` → Tasks by Project
* `PUT /tasks/{id}` → Update Task
* `DELETE /tasks/{id}` → Delete Task

---

## 🧪 Sample Request (Create Task)

```json
{
  "title": "Build REST APIs",
  "description": "Develop backend services",
  "status": "IN_PROGRESS",
  "priority": "HIGH",
  "deadline": "2026-03-30",
  "project": {
    "id": 1
  },
  "assignedTo": {
    "id": 1
  }
}
```

---

## ⚙️ Configuration

### application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

## ▶️ How to Run

1. **Clone the repository**

```
git clone https://github.com/your-username/task-manager.git
```

2. **Create MySQL Database**

```sql
CREATE DATABASE task_db;
```

3. **Update credentials** in `application.properties`

4. **Run the application**

```
mvn spring-boot:run
```

5. Test APIs using **Postman**

---

## 🚨 Error Handling

* Global exception handling using `@ControllerAdvice`
* Custom exception: `ResourceNotFoundException`
* Validation error handling with proper responses

---

## 📈 Future Enhancements

* 🔐 Spring Security (JWT Authentication)
* 📄 Swagger API Documentation
* 🐳 Docker Containerization
* ☁️ Deployment (AWS / Render)
* 📊 Dashboard & Analytics


⭐ If you like this project, feel free to star the repository!
