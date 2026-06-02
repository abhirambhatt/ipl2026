## IPL REST API

This is a Spring Boot backend application for managing IPL team data.
The project demonstrates clean architecture, secure authentication using JWT, JPA relationships, and modern backend practices like DTOs, validation, and exception handling.

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
- JPA One-To-Many & Many-To-One Relationships
- Create a team and assign multiple players to the team
- Create players using team name without manually providing team ID
  

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
├── config
│   ├── PasswordConfig.java
│   └── SecurityConfig.java
│
├── controller
│   ├── AuthController.java
│   ├── PlayerController.java
│   └── TeamController.java
│
├── dto
│   ├── Request
│   │   ├── LoginRequest.java
│   │   ├── PlayersRequest.java
│   │   └── RegisterRequest.java
│   │
│   └── Response
│       └── AuthResponse.java
│
├── entity
│   ├── Players.java
│   ├── Team.java
│   └── User.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   ├── TeamErrorResponse.java
│   └── TeamNotFoundException.java
│
├── repository
│   ├── PlayerRepository.java
│   ├── TeamRepository.java
│   └── UserRepository.java
│
├── security
│   ├── JwtFilter.java
│   └── JwtUtil.java
│
├── service
│   ├── PlayerService.java
│   ├── PlayerServiceImpl.java
│   ├── TeamService.java
│   └── TeamServiceImpl.java
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

## JPA Relationship

This project implements a bidirectional One-To-Many and Many-To-One relationship between Team and Players.

### Relationship Structure

One Team → Many Players

```text
Royal Challengers Bengaluru
├── Virat Kohli
├── Rajat Patidar
├── Josh Hazlewood
└── Yash Dayal
```

## Team Entity
  
@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)  
@JsonManagedReference  
private List<Players> players;
  
Players Entity
@ManyToOne
@JoinColumn(name = "team_id")
@JsonBackReference
private Team team;  

## Validation Rules
- Team name cannot be blank
- Team captain cannot be blank
- Matches played cannot be negative
- Matches won cannot be negative
- Matches won cannot exceed matches played
- NRR is validated before persistence


## API Endpoints

### Authentication APIs

| Method | Endpoint | Description |
|----------|----------|----------|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | Login and generate JWT token |

---

### Team APIs

| Method | Endpoint | Description |
|----------|----------|----------|
| POST | `/api/ipl` | Create team |
| GET | `/api/ipl` | Get all teams |
| GET | `/api/ipl/{id}` | Get team by ID |
| PATCH | `/api/ipl/{id}` | Update team |
| DELETE | `/api/ipl/{id}` | Delete team |
| GET | `/api/ipl/top5` | Get top 5 teams by NRR |
| GET | `/api/ipl/best` | Get best performing team |
| GET | `/api/ipl/nrr/{nrr}` | Filter teams by NRR |
| GET | `/api/ipl/wins/{wins}` | Filter teams by matches won |
| GET | `/api/ipl/matches/{matches}` | Filter teams by matches played |

---

### Player APIs

| Method | Endpoint | Description |
|----------|----------|----------|
| POST | `/api/players` | Create player and assign to team using team name |


## Sample Request

Create Team  

{  
   "teamName": "RCB",  
     "teamCaptain": "Rajat",  
    "noOfMatchesPlayed": 14,  
    "noOfMatchesWon": 9,  
    "nrr": 0.82  
}  

Create Player

{
   "playername": "Virat Kohli",
   "teamName": "RCB"
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



