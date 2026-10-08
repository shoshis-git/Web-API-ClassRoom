# Project 

A RESTful API built with Spring Boot for managing school classrooms. The application allows creating, reading, updating, and deleting classroom records stored in an H2 embedded database.

## Tech Stack

- **Java 17**
- **Spring Boot 3.5.5**
- **Spring Data JPA / Hibernate 6.6**
- **H2 Database** (file-based, persistent)
- **Maven**

## Project Structure

```
src/main/java/com/example/projectshoshifruchter/
├── ProjectShoshiFruchterApplication.java   # Entry point
├── controllers/
│   ├── ClassRoomController.java            # REST endpoints for /classroom
│   └── HomeController.java                 # Simple home endpoint
├── entities/
│   └── ClassRoom.java                      # ClassRoom entity
├── repository/
│   └── ClassRoomRepository.java            # JPA repository
└── services/
    ├── ClassRoomServiceInterface.java       # Service interface
    └── ClassRoomService.java               # Service implementation
```

## Running the Application

```bash
./mvnw spring-boot:run
```

The server starts on `http://localhost:8080` by default.

## API Endpoints

### Home
| Method | Path    | Description       |
|--------|---------|-------------------|
| GET    | /home   | Returns a simple HTML button |

### Classrooms
| Method | Path                      | Description                     |
|--------|---------------------------|---------------------------------|
| GET    | /classroom                | Get all classrooms              |
| GET    | /classroom/{roomNumber}   | Get a classroom by room number  |
| POST   | /classroom                | Add a new classroom             |
| PUT    | /classroom/{roomNumber}   | Update an existing classroom    |
| DELETE | /classroom                | Delete a classroom              |

### ClassRoom JSON Schema

```json
{
  "roomNumber": 101,
  "classNumber": "A",
  "teacher": "Mr. Cohen",
  "amountPupil": 30
}
```

## Database

The application uses an H2 file-based database stored at `./springdb`.

- **H2 Console:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:./springdb`
- **Username:** `sa`
- **Password:** *(empty)*

The schema is managed automatically by Hibernate (`ddl-auto=update`).

## Configuration

Settings are in `src/main/resources/application.properties`:

```properties
spring.application.name=project-shoshi-fruchter
spring.h2.console.enabled=true
spring.jpa.show-sql=true
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.url=jdbc:h2:./springdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.jpa.hibernate.ddl-auto=update
```
