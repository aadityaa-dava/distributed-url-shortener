# Distributed URL Shortener

## Project Overview

URL shortening services are widely used to transform long URLs into compact, shareable links while maintaining fast redirection performance and scalability.

This project develops a scalable distributed URL shortening service using Spring Boot, PostgreSQL, Redis caching, and REST APIs. The application generates compact Base62-encoded URLs, stores mappings efficiently, accelerates redirection through Redis caching, and tracks click analytics for usage monitoring.

The solution demonstrates backend system design principles including layered architecture, caching strategies, database persistence, API development, and performance optimization.

---

## Business Problem

Organizations and digital platforms frequently need to share long URLs across applications, websites, emails, and social media platforms.

Challenges include:

* Poor readability of long URLs
* Difficulty sharing lengthy links
* Lack of click tracking and analytics
* High redirection latency
* Scalability concerns for high-traffic systems

The objectives of this project are to:

* Generate compact URLs for long links
* Support fast and reliable redirection
* Improve scalability using caching
* Track URL usage analytics
* Demonstrate distributed backend design principles

---

## Technology Stack

### Backend Development

* Java 21
* Spring Boot
* Spring MVC
* Maven

### Database

* PostgreSQL
* Hibernate
* JPA

### Caching

* Redis

### APIs

* REST APIs
* JSON

### Development Tools

* IntelliJ IDEA
* Git
* GitHub

---

## System Architecture

```text
Client
   ↓
REST Controller
   ↓
Service Layer
   ↓
Redis Cache
   ↓
PostgreSQL Database
```

### Workflow

```text
Long URL
    ↓
Base62 Encoding
    ↓
Short URL Generation
    ↓
Database Persistence
    ↓
Redis Caching
    ↓
Client Access
    ↓
URL Redirection
```

---

## Core Features

### URL Shortening

* Converts long URLs into compact Base62-encoded identifiers.
* Generates unique short URLs for efficient sharing.

### URL Redirection

* Redirects users to original URLs using generated short codes.
* Supports fast lookup and retrieval.

### Redis Caching

* Stores frequently accessed URL mappings.
* Reduces database queries.
* Improves response times and scalability.

### URL Validation

* Validates incoming URLs before persistence.
* Prevents invalid URL submissions.

### Click Analytics

* Tracks redirection requests.
* Records URL access activity.
* Supports future analytics and reporting capabilities.

### Global Exception Handling

* Centralized exception management.
* Consistent API error responses.
* Improved system reliability.

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
distributed-url-shortener/

├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── aadityaa/
│                   └── urlshortener/
│                       ├── controller/
│                       ├── service/
│                       ├── repository/
│                       ├── model/
│                       ├── dto/
│                       ├── util/
│                       ├── exception/
│                       └── config/
│
├── src/main/resources/
│   └── application.properties
│
├── pom.xml
├── README.md
└── .gitignore
```

---

## Database Design

### URL Mapping Table

Stores:

* Original URL
* Short Code
* Creation Timestamp
* Click Count

### Redis Cache

Stores:

* Short Code
* Original URL Mapping

This reduces database lookup time during URL redirection.

---

## Performance Optimization

### Redis Caching Strategy

The application first checks Redis for URL mappings:

```text
Request
   ↓
Redis Cache
   ↓
Cache Hit → Redirect
   ↓
Cache Miss
   ↓
PostgreSQL Lookup
   ↓
Cache Update
   ↓
Redirect
```

Benefits:

* Reduced database load
* Faster response times
* Improved scalability

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

Application runs on:

```text
http://localhost:8080
```

---

## Business Impact

This project demonstrates how modern backend systems can:

* Improve link sharing efficiency
* Reduce infrastructure latency through caching
* Support scalable URL management
* Enable usage tracking and analytics
* Apply distributed system design principles

---

## Future Improvements

Potential enhancements include:

* Docker Containerization
* Swagger/OpenAPI Documentation
* Kafka-Based Analytics Processing
* Rate Limiting
* AWS Cloud Deployment
* User Authentication & Authorization
* QR Code Generation
* Custom URL Aliases
* Monitoring & Logging with Prometheus and Grafana

---

## Author

**Aadityaa Dava**

Software Engineering | Backend Development | Distributed Systems
