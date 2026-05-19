## IPL 2026 REST API

This is a Spring Boot backend project for managing laptops with secure authentication using JWT and BCrypt password hashing.

The project follows a layered architecture (Controller → Service → Repository → Entity) and uses DTO pattern for clean request/response handling.

## Features

- User Registration & Login
- JWT Authentication
- BCrypt Password Encryption
- DTO Pattern Implementation
- Global Exception Handling
- REST API Design
- MySQL Database Integration
- Clean Layered Architecture

## Filter teams by:

>NRR  
>Matches won  
>Matches played  
>Retrieve the best performing team  

## Tech Stack
  
- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- BCrypt
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

## Architecture  
  
Controller → Service → Repository → Database
  
## Project Structure
```
com.ipl2026.ipl2026
│
├── config         → Security configuration
├── controller     → REST APIs
├── dto            → Request & Response objects
├── entity         → Database entities
├── exception      → Global exception handling
├── repository     → JPA repositories
├── security       → JWT + Filter
├── service        → Business logic
│   ├── IPLService.java
│   └── IPLServiceImpl.java
│
└── Ipl2026Application.java
```

## API Endpoints

| Method | Endpoint                     | Description             |
| ------ | ---------------------------- | ----------------------- |
| POST   | `/api/ipl`                   | Create team             |
| GET    | `/api/ipl`                   | Get all teams           |
| GET    | `/api/ipl/{id}`              | Get team by ID          |
| PATCH  | `/api/ipl/{id}`              | Update team             |
| DELETE | `/api/ipl/{id}`              | Delete team             |
| GET    | `/api/ipl/top5`              | Top 5 teams by NRR      |
| GET    | `/api/ipl/nrr/{nrr}`         | Filter teams by NRR     |
| GET    | `/api/ipl/wins/{wins}`       | Filter teams by wins    |
| GET    | `/api/ipl/matches/{matches}` | Filter teams by matches |
| GET    | `/api/ipl/best`              | Get best team           |

## Sample Request

Create Team  

{  
   "teamName": "RCB",  
     "teamCaptain": "Rajat",  
    "noOfMatchesPlayed": 14,  
    "noOfMatchesWon": 9,  
    "nrr": 0.82  
}  

Login
  
{  
  "email": "user@gmail.com",
  "password": "123456"
}  


## Sample Response
  
{  
    "id": 1,  
    "teamName": "RCB",  
    "teamCaptain": "Rajat",  
    "noOfMatchesPlayed": 14,  
    "noOfMatchesWon": 9,  
    "nrr": 0.82  
}  

## Exception Handling
  
Structured error responses are returned for invalid requests or missing resources.  
  
{  
  "status": 404,  
  "message": "Team not found",  
  "timestamp": 1710000000000  
}  
  
## How to Run

> 1. Clone the repository
> 2. Configure database credentials in application.properties
> 3. Run the application
> 4. mvn spring-boot:run



