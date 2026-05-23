# Distributed URL Shortener

A scalable Distributed URL Shortener built using Spring Boot, PostgreSQL, Redis caching, and REST APIs.

## Features

- Shorten long URLs into compact Base62-encoded links
- Redirect users to original URLs
- PostgreSQL database persistence
- Redis caching for faster redirects
- URL validation
- Global exception handling
- Click analytics tracking
- Layered backend architecture

---

## Tech Stack

- Java 21
- Spring Boot
- PostgreSQL
- Redis
- Maven
- JPA / Hibernate
- REST APIs
- IntelliJ IDEA

---

## Architecture

```text
Client
   ↓
Controller Layer
   ↓
Service Layer
   ↓
Redis Cache
   ↓
PostgreSQL Database
```

---

## API Endpoints

### Create Short URL

```http
POST /shorten
```

Request:

```json
{
  "url": "https://www.google.com"
}
```

Response:

```json
{
  "originalUrl": "https://www.google.com",
  "shortUrl": "http://localhost:8080/b"
}
```

---

### Redirect to Original URL

```http
GET /{shortCode}
```

Example:

```http
GET /b
```

Redirects to:
```text
https://www.google.com
```

---

## Project Structure

```text
src/main/java/com/aadityaa/urlshortener
│
├── controller
├── service
├── repository
├── model
├── dto
├── util
├── exception
├── config
```

---

## How to Run

### Clone Repository

```bash
git clone https://github.com/aadityaa-dava/distributed-url-shortener.git
```

### Start PostgreSQL

```bash
brew services start postgresql@16
```

### Start Redis

```bash
brew services start redis
```

### Run Application

```bash
./mvnw spring-boot:run
```

---

## Future Improvements

- Docker support
- Swagger/OpenAPI documentation
- Kafka-based analytics processing
- Rate limiting
- AWS deployment
- User authentication
- QR code generation
- Custom aliases

---

## Author

Aadityaa Dava
