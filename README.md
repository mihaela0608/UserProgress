# 🚀 UserProgress API – Backend Service

UserProgress is a RESTful backend service designed to manage and track user progress within the TrackIt application.

It provides a structured API for storing, updating, and retrieving user-related data, enabling seamless integration with frontend applications.

---

## ✨ Overview

This project focuses on backend development using modern Java technologies and demonstrates:

* REST API design
* Database integration
* Layered architecture
* Clean code structure

---

## ⚙️ Features

👤 **User Management**

* Create and manage users
* Retrieve user data

📈 **Progress Tracking**

* Track user activity and progress
* Update and monitor changes over time

🗑️ **CRUD Operations**

* Create, Read, Update, Delete functionality
* Full lifecycle data management

---

## 🛠️ Technologies

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* REST API

---

## 🏗️ Architecture

The project follows a layered architecture:

* `Controller` – Handles HTTP requests and responses
* `Service` – Contains business logic
* `Repository` – Handles database operations
* `Model` – Defines application entities

This structure ensures scalability, maintainability, and clear separation of concerns.

---

## 🔗 API Endpoints

### Users

```http id="z3y9q8"
GET /users
POST /users
GET /users/{id}
DELETE /users/{id}
```

### Progress

```http id="n0r7wa"
GET /progress
POST /progress
PUT /progress/{id}
DELETE /progress/{id}
```

---

## ▶️ How to Run

1. Clone the repository:

```bash id="l9pq2u"
git clone https://github.com/mihaela0608/UserProgress.git
```

2. Open in IntelliJ IDEA

3. Configure your database in `application.properties`

4. Run the application:

```bash id="q1v7sz"
UserProgressApplication.java
```

---

## 🧪 Example Request

```json id="6k3pza"
POST /progress

{
  "userId": 1,
  "taskId": 3,
  "completed": true
}
```

---

## 📌 Future Improvements

* Add authentication (JWT)
* Validation and error handling
* Unit and integration testing
* API documentation (Swagger)

---

## 💡 About the Project

This project was built to practice and demonstrate:

* Backend development with Spring Boot
* Working with relational databases
* Building RESTful APIs
* Structuring scalable applications

---

## 👩‍💻 Author

Mihaela Bataklieva
