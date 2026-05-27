# Ticket Management System

A Spring Boot backend project built for practicing real-world backend development concepts including CRUD APIs, MySQL integration, DTO architecture, and Docker containerization.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Docker
- Docker Compose
- Maven

---

## Features

- Create Ticket
- Get All Tickets
- Get Ticket By ID
- Update Ticket
- Delete Ticket
- DTO Layer
- MySQL Database Integration
- Dockerized Backend
- REST APIs

---

## API Endpoints

### Create Ticket
POST /api/tickets

### Get All Tickets
GET /api/tickets

### Get Ticket By ID
GET /api/tickets/{id}

### Update Ticket
PUT /api/tickets/{id}

### Delete Ticket
DELETE /api/tickets/{id}

---

## Run Project Locally

### Build Project

```bash
.\mvnw clean package -DskipTests
