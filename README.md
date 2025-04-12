# Java Spring Boot JWT Auth User AddressBook

This is a sample Spring Boot application that demonstrates JWT-based authentication for a user address book API. It allows users to register, log in, and manage their address book entries securely using JSON Web Tokens (JWT).

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)


## Introduction

This project serves as a starting point for building secure RESTful APIs with Spring Boot and JWT authentication. It demonstrates best practices for user authentication and authorization in a Spring Boot application.

## Features

- User registration and login with JWT authentication
- CRUD operations for address book entries
- Secure access to API endpoints using JWT tokens

## Technologies Used

- **Java Spring Boot**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **MySQL** 
- **Maven**
- **Docker**

## Setup and Installation

1. **Clone the repository**:
```bash
   git clone https://github.com/KirollosMedhat9/Java-Spring-Boot-JWT-Auth-User-AddressBook.git
```
2.**Navigate to the project directory**:
```bash
cd Java-Spring-Boot-JWT-Auth-User-AddressBook
```
3. **Install dependencies**: 
```bash
mvn install
```
4.**Deploy the database by running docker-compose.yml**
```bash
docker compose up -d --build
```

## Running the Application
```bash 
mvn spring-boot:run
```

The application will start on http://localhost:8080 by default.

## API Endpoints
Below are the main API endpoints. Endpoints for address book management require a valid JWT token in the Authorization header
Authentication Endpoints

- **POST /auth/signup**
Register a new user.

- POST **/auth/login**
Login and receive a JWT token.

** Address Book Endpoints (Authenticated)**
- **GET /auth/contacts**
Get all address book entries.

- **POST /auth/add_contact**
Add an address book entry.

- **GET /auth/add_contact/{id}**
Get an address book entry.

- **DELETE /auth/delete_contact/{id}**
Delete an address book entry.

