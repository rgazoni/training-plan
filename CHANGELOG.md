# Changelog — Training Plan

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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
