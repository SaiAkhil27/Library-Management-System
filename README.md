
# Library Management System


The Library Management System is built with Java Spring Boot to manage the core functionalities of a library. Users can borrow and return books, while librarians can manage book inventory and keep track of transactions. This project uses Spring Boot for backend, Hibernate for database management, and JPA for ORM.



## Technologies and Dependencies 

Java with Spring Boot for backend development.

Spring Data JPA with Hibernate for database operations.

MySQL for database management.

Lombok for boilerplate code reduction.

Maven for project management and build automation.
## Setup & Installation

#### Clone the Repository:
git clone https://github.com/yourusername/Library-Management-System.git  
cd Library-Management-System

#### Configure MySQL:
Update the application.properties file with your MySQL username and password.

spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=yourpassword

#### Run the Application:
mvn spring-boot:run

#### Access the Application:
Open your browser and go to http://localhost:8080.


 

## API Endpoints

/books - View all books

/books/{id} - Get a specific book

/users - Manage users (admins only)
## Prerequisites

Java 17+

Maven 3.x

MySQL (or any preferred relational DB)
## Database Schema
### Students: 
Stores student information (name, ID, etc.).

### Books:
 Stores book details (title, author, ISBN, etc.).
### Issued Books:
Tracks which books are issued to students and their return dates.