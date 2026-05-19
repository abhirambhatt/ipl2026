## IPL 2026 REST API

This is a Spring Boot backend application for managing IPL 2026 team data.
The project demonstrates clean architecture, secure authentication using JWT, and modern backend practices like DTOs and exception handling.

## Features

- Create, update, delete IPL teams
- Retrieve all teams or specific team by ID
- Top 5 teams based on Net Run Rate (NRR)
- Filter teams by:  
   - NRR
   - Matches won
   - Matches played
   - Get best performing team
- JWT Authentication (Login & Register) 
- BCrypt Password Hashing 
- DTO Pattern implementation
- Global Exception Handling
  

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

## Authentication Flow
1. User registers → password stored using BCrypt
2. User logs in → JWT token generated
3. Token must be sent in header:  
   Authorization: Bearer <token>  
5. JWT Filter validates request
6. Access granted to protected APIs

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



