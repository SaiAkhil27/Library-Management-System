Library Management System
Project Overview
The Library Management System allows users to manage books, track loans, and administer user access. It includes features like book borrowing, return tracking, and user management. This project is built with Java Spring Boot and uses REST APIs for communication.

Features:
Add, edit, and delete books
Borrow/return books
Manage student and librarian roles
Search and filter books
Handle overdue notifications


Technologies Used:
Java Spring Boot
JPA/Hibernate for ORM
MySQL for the database
Spring Security for authentication and authorization

Setup & Installation:
Clone the repository: git clone <repository-link>
Navigate to the project directory: cd library-management-system
Configure MySQL database in application.properties.
Run the project: mvn spring-boot:run

API Endpoints:
/books - View all books
/books/{id} - Get a specific book
/users - Manage users (admins only)

Future Enhancements:
Implement fine calculation for overdue books
Add email notifications for users
