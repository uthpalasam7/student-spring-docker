# Student Spring Docker Application

`student-spring-docker` is a Spring Boot app designed to learn Docker, featuring simple REST APIs and a PostgreSQL database setup.

## Features
- `/getStudents`: Fetches all students.
- `/addStudent`: Adds a predefined student.
- Dockerized app with PostgreSQL integration.

## Prerequisites
- Java 11+
- Maven
- Docker

## Setup

### Clone and Build
```bash
git clone https://github.com/uthpalasam7/student-spring-docker.git
cd student-spring-docker
mvn clean package
```

### Docker Configuration
#### Dockerfile
```dockerfile
FROM openjdk:25-jdk
ADD target/student-app.jar student-app.jar
ENTRYPOINT ["java", "-jar", "/student-app.jar"]
```
#### docker-compose.yml
```yaml
version: "3"
services:
  app:
    build: .
    ports:
      - "8080:8080"
    networks:
      - s-network
  postgres:
    image: postgres:latest
    ports:
      - "5433:5432"
    environment:
      POSTGRES_USER: uthpala
      POSTGRES_PASSWORD: 1234
      POSTGRES_DB: postgres
    networks:
      - s-network
    volumes:
      - postgres_s_data:/var/lib/postgresql/data
networks:
  s-network:
    driver: bridge
volumes:
  postgres_s_data:
```

### Run the App
```bash
docker-compose up --build
```
- App: `http://localhost:8080`
- PostgreSQL: Port `5433`

### Endpoints
- **Get Students:** `GET /getStudents`
  ```bash
  curl http://localhost:8080/getStudents
  ```
- **Add Student:** `POST /addStudent`
  ```bash
  curl -X POST http://localhost:8080/addStudent
  ```

## Directory Structure
```plaintext
student-spring-docker/
├── src/main/java
├── src/main/resources
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

## Built With
- Spring Boot
- Docker
- PostgreSQL

## License
MIT License
