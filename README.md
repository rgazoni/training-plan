# Training Plan

Spring Boot app to manage **triathlon athletes** and (soon) generate **science‑informed training plans**.

> **Status:** MVP — *Athlete CRUD implemented*. See [**ROADMAP**](./ROADMAP.md) for what's next.

## Quick start

**Pre reqs:** Java 21+, Maven 4.0+

```bash
mvn spring-boot:run
```

Dev runs on [**http://localhost:8080**](http://localhost:8080) with PostgreSQL database (see `application.yml` and `infra/compose.yaml`).

## Features

* 👨‍💻 Entities creation, relationships and their CRUDs (create/read/update/delete)
* 🔜 Performance markers (Run threshold/VDOT, Bike FTP, Swim CSS)
* 🔜 Training‑plan generator with periodization (Base → Build → Peak → Taper)
* 🔜 Adaptive rules (RPE/missed sessions), alerts, OpenAPI docs

## Project structure

```
training-plan/
├── src/main/java/...
│   ├── config/           # security, web, validation
│   ├── domain/           # entities (e.g., Athlete)
│   ├── repository/       # Spring Data interfaces
│   ├── service/          # business logic
│   ├── web/              # controllers & DTOs
│   ├── web/mappers/      # MapStruct mappers
│   ├── rules/            # adaptive rules (planned)
├── src/test/             # unit & integration tests
├── docs/                 # ADRs, architecture notes
└── pom.xml
```

## Docs

* **Roadmap:** see [**ROADMAP.md**](./ROADMAP.md)
* **Changelog:** see [**CHANGELOG.md**](./CHANGELOG.md)
* 🔜 **Architecture:** see [**ARCHITECTURE.md**](./ARCHITECTURE.md)

