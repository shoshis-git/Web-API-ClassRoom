# Project Classroom WebAPI

A RESTful API built with Spring Boot for managing school classrooms. The application allows creating, reading, updating, and deleting classroom records stored in an H2 embedded database.

## Tech Stack

- **Java 19**
- **Spring Boot 3.5.5**
- **Spring Data JPA / Hibernate 6.6**
- **Spring Validation**
- **H2 Database** (file-based, persistent)
- **Springdoc OpenAPI / Swagger UI 2.8.3**
- **Maven**

## Project Structure

```
src/main/java/com/example/projectshoshifruchter/
├── ProjectShoshiFruchterApplication.java   # Entry point
├── config/
│   └── SwaggerConfig.java                  # Swagger / OpenAPI configuration
├── controllers/
│   ├── ClassRoomController.java            # REST endpoints for /classroom
│   └── HomeController.java                 # Simple home endpoint
├── dto/
│   ├── ClassRoomRequestDTO.java            # Incoming request body (POST/PUT)
│   ├── ClassRoomResponseDTO.java           # Outgoing response body
│   └── ClassRoomMapper.java                # Maps between Entity and DTOs
├── entities/
│   └── ClassRoom.java                      # JPA entity — maps to DB table
├── exceptions/
│   ├── ErrorResponse.java                  # Unified error response shape
│   ├── ResourceNotFoundException.java      # Thrown when a room is not found
│   └── GlobalExceptionHandler.java         # Central error handler (@RestControllerAdvice)
├── repository/
│   └── ClassRoomRepository.java            # JPA repository
└── services/
    ├── ClassRoomServiceInterface.java       # Service interface
    └── ClassRoomService.java               # Service implementation
```

## Running the Application

```bash
mvnw.cmd spring-boot:run
```

The server starts on `http://localhost:8080` by default.

## API Endpoints

All endpoints are documented interactively in Swagger UI.

### Classrooms
| Method | Path                        | Description                      | Success |
|--------|-----------------------------|----------------------------------|---------|
| GET    | `/classroom`                | Get all classrooms               | 200     |
| GET    | `/classroom/{roomNumber}`   | Get a classroom by room number   | 200     |
| POST   | `/classroom`                | Add a new classroom              | 201     |
| PUT    | `/classroom/{roomNumber}`   | Update an existing classroom     | 200     |
| DELETE | `/classroom/{roomNumber}`   | Delete a classroom               | 204     |

### Request Body (POST / PUT)

```json
{
  "roomNumber": 101,
  "classNumber": "A",
  "teacher": "ישראל ישראלי",
  "amountPupil": 30
}
```

### Validation Rules

| Field         | Rule                              |
|---------------|-----------------------------------|
| `roomNumber`  | Must be >= 1                      |
| `classNumber` | Required                          |
| `teacher`     | Required, cannot be blank         |
| `amountPupil` | Between 0 and 50                  |

### Error Response Shape

All errors return a consistent JSON body:

```json
{
  "status": 404,
  "error": "Not Found",
  "message": "ClassRoom with room number 99 was not found",
  "timestamp": "2026-10-08T17:30:00"
}
```

## Swagger UI

Interactive API documentation is available at:

```
http://localhost:8080/swagger-ui/index.html
```

Raw OpenAPI spec (JSON):

```
http://localhost:8080/v3/api-docs
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
