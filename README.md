# Book lending API

Book lending API built with Java, JAX-RS (Jersey), and Swagger.

This repository contains a Swagger definition and a JAX-RS server module for managing:

- users
- books
- book loans
- book reviews

The project was originally created as a Reykjavik University assignment (Fall 2017) in HONN, Hönnun og smíði hugbúnaðar.

## Repository layout

- `swagger.yaml` - OpenAPI (Swagger 2.0) contract for the API.
- `jaxrs-server/` - Maven web application (WAR) with generated Swagger server stubs and in-memory services.
- `jaxrs-server/json/books.json` - Seed books loaded at startup.
- `jaxrs-server/json/users.json` - Seed users and initial active loans loaded at startup.

## Tech stack

- Java 8 target (`maven.compiler.release=8`)
- Maven
- Jersey (JAX-RS)
- Swagger (swagger-core 1.5.x, generated server stubs)
- Jetty Maven plugin for local development

## Prerequisites

- JDK 8+ (JDK 17/21 also works with current `pom.xml`)
- Maven 3.8+

## Run locally

From the server module:

```bash
cd jaxrs-server
mvn clean package jetty:run
```

The server starts on:

- API base URL: `http://127.0.0.1:8080/api/v1`
- Swagger JSON: `http://127.0.0.1:8080/api/v1/swagger.json`
- Swagger UI: `http://127.0.0.1:8080/swagger-ui/`

## Build only

```bash
cd jaxrs-server
mvn package
```

## Data model behavior

- Services are in-memory (`MemoryBookService`, `MemoryUserService`).
- Initial data is loaded from the JSON files in `jaxrs-server/json`.
- Runtime writes are not persisted back to disk.
- Restarting the server resets all runtime changes.

Important: start commands must be run from `jaxrs-server` so JSON seed paths resolve correctly.

## API overview

The full contract is in `swagger.yaml`.

Primary resource groups:

- `/users`
- `/books`
- `/books/{bookId}/loans/...`
- `/books/{bookId}/reviews/...`
- `/users/loans/...`

## Quick API examples

Get all books:

```bash
curl http://127.0.0.1:8080/api/v1/books
```

Get one book:

```bash
curl http://127.0.0.1:8080/api/v1/books/1
```

Add a book:

```bash
curl -X POST http://127.0.0.1:8080/api/v1/books \
	-H "Content-Type: application/json" \
	-d '{
		"title": "Domain-Driven Design",
		"firstName": "Eric",
		"lastName": "Evans",
		"datePublished": "2003-08-30T00:00:00.000Z",
		"isbn": "9780321125217"
	}'
```

Loan a book to a user:

```bash
curl -X POST http://127.0.0.1:8080/api/v1/books/1/loans/1
```

Return a book:

```bash
curl -X PUT http://127.0.0.1:8080/api/v1/books/1/return
```

## Current implementation status

The Swagger contract is broader than the current concrete implementation.

- Most book mutation endpoints are wired to in-memory services.
- Several read/analytics endpoints currently return placeholder `"magic!"` responses.
- User endpoints currently use generated placeholder responses in `UsersApiServiceImpl`.

If you plan to extend the project, these endpoints are the main completion targets.

## Compatibility notes

This repository already includes build fixes needed on modern JDKs:

- Java target is set to 8.
- `javax.xml.bind:jaxb-api:2.3.1` is included for generated Swagger models.

## Development tips

- Keep `swagger.yaml` as the API contract source of truth.
- Regenerated sources live in `jaxrs-server/src/gen/java`.
- Custom implementation lives in `jaxrs-server/src/main/java`.

## Credits

Created by [Birkir Brynjarsson](https://github.com/birkirbrynjarsson), @birkirbrynjarsson and [Sigrun Tinna Gissurardottir](https://github.com/sigruntinna) @sigruntinna.