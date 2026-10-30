# Employee Management System

A web-based **Employee Management System** developed using Spring Boot, Spring Data JPA, Thymeleaf, and MySQL. This application provides a simple and efficient way to manage employee records through a user-friendly web interface.

## 🚀 Project Overview

The Employee Management System is designed to simplify employee record management by providing essential CRUD (Create, Read, Update, Delete) operations.

It follows a layered architecture using Spring Boot, separating controllers, services, repositories, and entity classes for better maintainability and scalability.

## ✨ Features

- **Add Employee:** Register new employees in the database.
- **View Employees:** Display employee records.
- **Update Employee:** Modify existing employee information.
- **Delete Employee:** Remove employee records.
- **Database Integration:** Persistent storage using MySQL.
- **Dynamic Web Pages:** Server-side rendering using Thymeleaf.
- **JPA Integration:** Simplified database operations using Spring Data JPA.
- **Responsive Interface:** HTML-based user interface.

## 🛠️ Technology Stack

| Category | Technologies |
|---|---|
| Backend | Java 21, Spring Boot |
| Frontend | HTML, CSS, Thymeleaf |
| Database | MySQL |
| ORM | Hibernate, Spring Data JPA |
| Build Tool | Maven |
| Server | Embedded Apache Tomcat |
| Version Control | Git & GitHub |

## 📂 Project Structure

```text
Employee_Management/
│
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── Controller/
│   │   │   │   └── AppController.java
│   │   │   │
│   │   │   ├── Entity/
│   │   │   │   └── Employee.java
│   │   │   │
│   │   │   ├── Repository/
│   │   │   │   └── Employee_Repository.java
│   │   │   │
│   │   │   ├── Service/
│   │   │   │   └── Employee_Service.java
│   │   │   │
│   │   │   └── EmployeeManagementApplication.java
│   │   │
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── about.html
│   │       │   ├── addEmployee.html
│   │       │   ├── delete.html
│   │       │   ├── landing.html
│   │       │   ├── service.html
│   │       │   ├── show.html
│   │       │   └── update.html
│   │       │
│   │       └── application.properties
│   │
│   └── test/
│       └── java/com/example/demo/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## ⚙️ Installation and Setup

### 1. Clone the Repository

```bash
git clone https://github.com/SHASHWAT-4624/Employee_Management_System.git
```

### 2. Navigate to the Project Directory

```bash
cd Employee_Management
```

### 3. Prerequisites

Ensure the following are installed:

- Java Development Kit (JDK 21)
- MySQL Server
- Git
- Maven (optional, as Maven Wrapper is included)

### 4. Configure MySQL Database

Create a database in MySQL:

```sql
CREATE DATABASE employee_management;
```

### 5. Configure Environment Variables

The application uses environment variables to manage database credentials securely.

Update `src/main/resources/application.properties`:

```properties
spring.application.name=Employee_Management

spring.datasource.url=${MYSQL_URL}
spring.datasource.username=${MYSQL_USER}
spring.datasource.password=${MYSQL_PASSWORD}

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=${PORT:9999}
```

Set the environment variables in PowerShell:

```powershell
$env:MYSQL_URL="jdbc:mysql://localhost:3306/employee_management"
$env:MYSQL_USER="root"
$env:MYSQL_PASSWORD="your_mysql_password"
```

Replace the credentials with your own MySQL configuration.

### 6. Run the Application

Using Maven Wrapper on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, using Maven:

```bash
mvn spring-boot:run
```

### 7. Access the Application

Open your browser and visit:

```text
http://localhost:9999
```

## 🏗️ Application Architecture

The application follows a layered architecture:

1. **Controller Layer:** Handles HTTP requests and manages application
