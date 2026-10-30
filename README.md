# Employee Management System

A web-based **Employee Management System** built using Java, Spring Boot, Spring Data JPA, Thymeleaf, and MySQL. The application provides an intuitive interface for managing employee records with complete CRUD (Create, Read, Update, Delete) functionality.

## 🚀 Project Overview

The Employee Management System simplifies employee record management through a web-based application.

It follows a layered architecture using Spring Boot, separating controllers, services, repositories, and entity classes to improve code organization, maintainability, and scalability.

The application integrates MySQL for persistent data storage and Thymeleaf for dynamic server-side rendering.

## ✨ Key Features

- **Add Employee:** Register new employees and store their information.
- **View Employees:** Display employee records from the database.
- **Update Employee:** Modify existing employee information.
- **Delete Employee:** Remove employee records.
- **MySQL Integration:** Store and manage employee data persistently.
- **Spring Data JPA:** Simplify database operations using ORM.
- **Thymeleaf Templates:** Generate dynamic web pages.
- **Layered Architecture:** Separate application responsibilities.
- **Docker Support:** Containerize the application for deployment.
- **Cloud Database Connectivity:** Connect to a remote MySQL database.

## 🛠️ Technology Stack

| Category | Technologies |
|---|---|
| Programming Language | Java 21 |
| Backend Framework | Spring Boot |
| Frontend | HTML, CSS, Thymeleaf |
| Database | MySQL |
| ORM | Hibernate, Spring Data JPA |
| Build Tool | Maven |
| Application Server | Embedded Apache Tomcat |
| Containerization | Docker |
| Database Hosting | Clever Cloud |
| Application Hosting | Render |
| Version Control | Git and GitHub |

## 📂 Project Structure

```text
Employee_Management/
│
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
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
├── Dockerfile
├── .dockerignore
├── .gitignore
├── .gitattributes
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 🏗️ Application Architecture

The application follows a layered architecture:

1. **Controller Layer:** Handles incoming HTTP requests and manages application navigation.
2. **Service Layer:** Contains business logic and employee management operations.
3. **Repository Layer:** Communicates with the MySQL database using Spring Data JPA.
4. **Entity Layer:** Defines employee data models and database mappings.
5. **View Layer:** Uses Thymeleaf templates to render dynamic HTML pages.

## ⚙️ Installation and Setup

### 1. Prerequisites

Ensure the following software is installed:

- Java Development Kit (JDK 21)
- MySQL Server
- Git
- Maven (optional, Maven Wrapper is included)
- IDE such as IntelliJ IDEA, Eclipse, or Spring Tool Suite

### 2. Clone the Repository

```bash
git clone https://github.com/SHASHWAT-4624/Employee_Management_System.git
```

### 3. Navigate to the Project Directory

```bash
cd Employee_Management
```

### 4. Configure MySQL Database

Create a database in MySQL:

```sql
CREATE DATABASE employee_management;
```

### 5. Configure Application Properties

Open:

`src/main/resources/application.properties`

Configure the following properties:

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

### 6. Configure Environment Variables

The application uses environment variables to keep database credentials outside the source code.

For local development, configure them in PowerShell:

```powershell
$env:MYSQL_URL="jdbc:mysql://localhost:3306/employee_management"
$env:MYSQL_USER="root"
$env:MYSQL_PASSWORD="your_mysql_password"
```

Replace these values with your own database credentials.

### 7. Run the Application

Using Maven Wrapper on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively:

```bash
mvn spring-boot:run
```

### 8. Access the Application

Open your browser:

```text
http://localhost:9999
```

## 🐳 Docker Configuration

The project includes a Dockerfile for containerizing the Spring Boot application.

### Build Docker Image

```bash
docker build -t employee-management .
```

### Run Docker Container

```bash
docker run -p 10000:10000 \
-e PORT=10000 \
-e MYSQL_URL="your_mysql_jdbc_url" \
-e MYSQL_USER="your_mysql_username" \
-e MYSQL_PASSWORD="your_mysql_password" \
employee-management
```

The application runs inside the Docker container and connects to the configured MySQL database.

## ☁️ Cloud Deployment

The project is prepared for cloud deployment using the following services:

| Component | Platform | Purpose |
|---|---|---|
| Source Code | GitHub | Version control and source repository |
| Backend Application | Render | Spring Boot application hosting |
| Database | Clever Cloud | Remote MySQL database hosting |
| Containerization | Docker | Application packaging |

### Deployment Configuration

The application uses environment variables for cloud database connectivity.

Configure the following environment variables in the Render service:

| Variable | Description |
|---|---|
| `MYSQL_URL` | Clever Cloud MySQL JDBC connection URL |
| `MYSQL_USER` | Clever Cloud database username |
| `MYSQL_PASSWORD` | Clever Cloud database password |
| `PORT` | Port provided by Render |

**Important:** Never commit actual database credentials, passwords, or secrets to GitHub.

### Deployment Workflow

1.