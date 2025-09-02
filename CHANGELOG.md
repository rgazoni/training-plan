# Changelog — Training Plan

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## \[0.0.6] - 2025-09-01

### Added
- Created a repository for workout `WorkoutRepository`.
- Created integration tests to assure that workout repo is functional `WorkoutRepositoryIT`.
- Created tests for mapping a WorkoutDto to Workout entity `WorkoutMapperTest`
- Created Mapper for Workout logic and the Dto.

### Changed
- Changed packages `dto` and `mapper` to internal package, in order to keep these responsibilities into domain hands and not the presentation layer.
- Changed durationMin Workout type from LocalTime to Duration.

### Removed

## \[0.0.5] - 2025-08-29

### Added
- Integrated Flyway package core
- created a package called internal
- Created a package named config, in order to store application configs
- Created a configuration initialization file for flyway named `FlywayInit`. It initializes and migrate scripts after application ctx is set up - uses `@PostConstruct` to achieve that.
- Followed flyway doc for Java API https://documentation.red-gate.com/fd/api-hooks-277579366.html
- Created an integration test to certified that changes in structure were made correctly

### Changed
- Configured flyway on a local properties file
- domain, repositories, service packages were moved to an internal package

### Removed
- Flyway plugin and flyway conf.

## \[0.0.4] - 2025-08-24

### Added
- Integrated Flyway plugin and postgres flyway engine.
- Configured it with flyway.conf under resources
- Started the migration with entities in the current domain. Migration was completed successfully.
- Migrations are under resources/db/migration.

## \[0.0.3] - 2025-08-21

### Added
- Created test environment with the following libraries
  - Mockito
  - JUnit5
  - MockMvc
  - Mockito.JUnit
  - AssertJ
  - Testcontainers
  - Testcontainers.JUnit
  - Testcontainers.postgres
- Created 3 tests for `AthleteController` using web slice
- Created 2 tests for `AthleteMapper`

### Fix
- `Athlete` Using JPA documentation, adjusted Lombok annotations for not encountering bugs or delay in performance
- `AthleteMapper` mapped socialIdentifier to CPF in the conversion entity to dto

### Changed
- `AthleteResponseDto` changed socialIdentifier field to CPF

## \[0.0.2] - 2025-08-13

### Added
- New ERD and `.drawio` diagram for the data model.
- `Workout` entity as a reusable workout template (decoupled from athletes).
- `Workout_assignment` to schedule a workout for a specific athlete and date.
- `Workout_completion` to log executed workouts (date/result/perceived effort/notes).

### Changed
- Split workout into responsibilities: planning now lives in `Workout_assignment` and execution in `Workout_completion`.

## \[0.0.1] — 2025‑08‑12

### Added

* Athlete CRUD (entity, repository, service, controller)
* Dev config using PostgreSQL
* Initial project structure and docs
