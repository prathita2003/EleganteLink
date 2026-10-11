# EleganteLink — URL Shortener

EleganteLink is a lightweight URL shortening application built with **Spring Boot, React, and H2 Database**. It converts long URLs into compact links, redirects users to their original destinations, and provides a simple interface to manage shortened URLs.

## Features

- **URL Shortening:** Generates unique short codes using UUID-based generation.
- **URL Redirection:** Redirects shortened links to their original destinations using HTTP 302.
- **URL Normalization:** Automatically adds the HTTPS scheme when a URL is provided without one.
- **Link Management:** Create, retrieve, list, and delete shortened URLs through REST APIs.
- **Persistent Data Access:** Uses Spring Data JPA and H2 Database.
- **Responsive Interface:** React-based frontend for shortening and managing links.

## Tech Stack

| Layer | Technologies |
|---|---|
| Frontend | React, JavaScript, CSS |
| Backend | Java, Spring Boot |
| Data Access | Spring Data JPA, Hibernate |
| Database | H2 Database |
| API | REST, HTTP |
| Build Tool | Maven |
| Frontend Tooling | Vite |

## Architecture

The application follows a client-server architecture:

1. **React Frontend:** Accepts URLs, displays shortened links, and provides link management controls.
2. **Spring Boot Backend:** Handles URL creation, retrieval, deletion, and redirection.
3. **H2 Database:** Stores original URLs, short codes, and creation timestamps through JPA.

## REST API

Base URL: `http://localhost:8080`

| Method | Endpoint | Description |
|---|---|---|
| `POST` | `/api/links` | Create a shortened URL |
| `GET` | `/api/links` | Retrieve all links |
| `GET` | `/api/links/{shortCode}` | Retrieve link details |
| `DELETE` | `/api/links/{shortCode}` | Delete a shortened link |
| `GET` | `/{shortCode}` | Redirect to the original URL |

### Example: Create a Shortened URL

**Request**

`POST /api/links`

```json
{
  "originalUrl": "https://example.com"
}
```

The API returns a response containing the link ID, original URL, short code, shortened URL, and creation timestamp.

## Getting Started

### Prerequisites

- Java 21 or a compatible configured JDK
- Maven or the included Maven Wrapper
- Node.js and npm

### 1. Start the Backend

Navigate to the backend directory:

```bash
cd eleganteLink
```

Run the application using the Maven Wrapper on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The backend runs at `http://localhost:8080`.

### 2. Start the Frontend

Open a separate terminal:

```bash
cd elegante-link-ui
npm install
npm run dev
```

Open the local URL displayed by Vite, typically `http://localhost:5173`.

## Project Structure

```text
EleganteLink/
├── eleganteLink/       # Spring Boot backend
├── elegante-link-ui/   # React frontend
└── README.md
```

## Future Enhancements

- Custom short codes
- Expiration dates for shortened links
- Click analytics and usage statistics
- Production database integration

## License

This project is intended for learning and portfolio demonstration.
