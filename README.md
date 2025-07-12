# 📝 Task Manager Web Application

## 📌 Project Description

This is a simple web-based task manager application that allows users to:

- ✅ Add new tasks with a name, description, date, and status;
- 📋 View all tasks in a table;
- 🔄 Change the task status (in progress / done) directly from the main page;
- ✏️ Edit existing tasks;
- 🗑️ Delete tasks.

The app is built with **Java (Spring Boot)** using **Thymeleaf** for the front-end and **PostgreSQL** as the database.

---

## 🚀 How to Run

1. Make sure you have **Java 17+** and **PostgreSQL** installed.
2. Create a PostgreSQL database named `task_manager`.
3. Open the `application.properties` file and configure your database credentials:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/task_manager
   spring.datasource.username=your_username
   spring.datasource.password=your_password
