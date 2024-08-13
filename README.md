# Task Management Application

## Overview
This is a simple Task Management application built using Spring Boot. It provides RESTful APIs to manage tasks and users, with PostgreSQL as the backend database. The application supports basic CRUD operations, validation, and unit testing.

## Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- PostgreSQL 12 or higher
- An IDE (e.g., IntelliJ IDEA)

## Project Setup

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/taskmanager.git
cd taskmanager
2. PostgreSQL Setup
Start PostgreSQL: Ensure PostgreSQL is running on your machine.

Create a Database:

Log in to PostgreSQL:
bash

psql -U postgres
Create a new database:
sql

CREATE DATABASE taskmanager;
Exit PostgreSQL:
sql

\q
Update Database Configuration:

Open the src/main/resources/application.properties file.
Update the following properties with your PostgreSQL credentials:
properties

spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanager
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
3. Build and Run the Application
Build the Project:

Navigate to the project directory and run:
bash

mvn clean install
Run the Application:

In IntelliJ IDEA (or any IDE), right-click on TaskManagerApplication.java and select Run 'TaskManagerApplication'.
Alternatively, run the following command:
bash

mvn spring-boot:run
Access the API:

The application will run on http://localhost:8080.
You can test the endpoints using Postman or any other REST client.
4. API Endpoints
User Endpoints:

POST /api/users - Create a new user
GET /api/users - Retrieve all users
GET /api/users/{id} - Retrieve a user by ID
PUT /api/users/{id} - Update a user
DELETE /api/users/{id} - Delete a user
Task Endpoints:

POST /api/tasks - Create a new task
GET /api/tasks - Retrieve all tasks
GET /api/tasks/{id} - Retrieve a task by ID
PUT /api/tasks/{id} - Update a task
DELETE /api/tasks/{id} - Delete a task
5. Running Unit Tests
Run Tests:
Run all unit tests using Maven:
bash

mvn test
The tests are located in the src/test/java/com/example/taskmanager/service/TaskServiceTest.java file.
Assumptions and Considerations
Timezone Handling: Tasks are stored in UTC in the database. When creating or updating a task, the timezone can be specified. If not provided, the user's timezone is used.
Validation: The title field in the Task entity is mandatory, and the status must be one of PENDING, IN_PROGRESS, or COMPLETED.
Global Error Handling: A global exception handler is implemented to handle cases like resource not found or validation errors.
Database Initialization: The database schema is automatically created or updated based on the entities when the application starts (spring.jpa.hibernate.ddl-auto=update).
User-Task Association: Every task must be associated with a user. The assignedTo field is mandatory in the Task entity.
Optional Enhancements
Implement pagination, filtering, and sorting for tasks.
Integrate with a front-end framework like React or Angular.
Add more comprehensive unit tests for all service methods.
Conclusion
This application demonstrates a basic implementation of a RESTful API with Spring Boot, focusing on task management with PostgreSQL as the backend. It includes essential CRUD operations, validation, error handling, and unit testing.


### **Explanation:**

- **Overview**: Provides a brief introduction to the project.
- **Prerequisites**: Lists the tools and technologies required to run the application.
- **Project Setup**: Step-by-step instructions to set up the project, including cloning the repository, setting up PostgreSQL, building, and running the application.
- **API Endpoints**: Lists the available API endpoints for tasks and users.
- **Running Unit Tests**: Instructions to run the unit tests.
- **Assumptions and Considerations**: Describes the design decisions and considerations taken during development.
- **Optional Enhancements**: Suggestions for further improvements.
- **Conclusion**: Summarizes the project and its functionality.

This `README.md` provides clear instructions for anyone who wants to set up and run your application.