## IPL 2026 REST API

A backend REST API built using Spring Boot for managing IPL 2026 team data. The application follows a layered architecture and demonstrates CRUD operations, filtering, sorting, and exception handling using modern backend development practices.

## Features

Create, update, delete IPL teams
Retrieve all teams or a specific team by ID
Get top 5 teams based on Net Run Rate (NRR)

## Filter teams by:

NRR
Matches won
Matches played
Retrieve the best performing team
Global exception handling with structured responses
Tech Stack
Java
Spring Boot
Spring Web
Spring Data JPA
Hibernate
MySQL
Postman

## Architecture  
  
Controller → Service → Repository → Database
  
## Project Structure
```
com.ipl2026.ipl2026
│
├── controller
│   └── IPLController.java
│
├── service
│   ├── IPLService.java
│   └── IPLServiceImpl.java
│
├── repository
│   └── IPLRepository.java
│
├── entity
│   └── IPL2026.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   ├── TeamNotFoundException.java
│   └── TeamErrorResponse.java
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

## Future Improvements

* DTO Layer
* Validation using @Valid
* Swagger / OpenAPI documentation
* Unit testing
* Authentication & Authorization

