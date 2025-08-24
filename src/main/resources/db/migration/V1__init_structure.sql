CREATE SEQUENCE IF NOT EXISTS athlete_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS race_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS workout_assignment_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS workout_completion_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS workout_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE athlete
(
    id                BIGINT           NOT NULL,
    social_identifier VARCHAR(255)     NOT NULL,
    first_name        VARCHAR(255)     NOT NULL,
    last_name         VARCHAR(255)     NOT NULL,
    weight_kg         DOUBLE PRECISION NOT NULL,
    age               INTEGER          NOT NULL,
    CONSTRAINT pk_athlete PRIMARY KEY (id)
);

CREATE TABLE race
(
    id       BIGINT                      NOT NULL,
    name     VARCHAR(255)                NOT NULL,
    date     TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    sport    VARCHAR(255)                NOT NULL,
    distance VARCHAR(255)                NOT NULL,
    CONSTRAINT pk_race PRIMARY KEY (id)
);

CREATE TABLE workout
(
    id           BIGINT       NOT NULL,
    name         VARCHAR(255) NOT NULL,
    sport        VARCHAR(255) NOT NULL,
    train_type   VARCHAR(255) NOT NULL,
    duration_min time WITHOUT TIME ZONE,
    distance_m   INTEGER,
    intensity    SMALLINT     NOT NULL,
    description  VARCHAR(255),
    CONSTRAINT pk_workout PRIMARY KEY (id)
);

CREATE TABLE workout_assignment
(
    id           BIGINT                      NOT NULL,
    athlete_id   BIGINT                      NOT NULL,
    workout_id   BIGINT                      NOT NULL,
    planned_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_workout_assignment PRIMARY KEY (id)
);

CREATE TABLE workout_completion
(
    id               BIGINT  NOT NULL,
    assignment_id    BIGINT,
    date             TIMESTAMP WITHOUT TIME ZONE,
    result           FLOAT   NOT NULL,
    perceived_effort INTEGER NOT NULL,
    notes            VARCHAR(255),
    CONSTRAINT pk_workout_completion PRIMARY KEY (id)
);

ALTER TABLE athlete
    ADD CONSTRAINT uc_athlete_socialidentifier UNIQUE (social_identifier);

ALTER TABLE workout_completion
    ADD CONSTRAINT uc_workout_completion_assignment UNIQUE (assignment_id);

ALTER TABLE workout_assignment
    ADD CONSTRAINT FK_WORKOUT_ASSIGNMENT_ON_ATHLETE FOREIGN KEY (athlete_id) REFERENCES athlete (id);

ALTER TABLE workout_assignment
    ADD CONSTRAINT FK_WORKOUT_ASSIGNMENT_ON_WORKOUT FOREIGN KEY (workout_id) REFERENCES workout (id);

ALTER TABLE workout_completion
    ADD CONSTRAINT FK_WORKOUT_COMPLETION_ON_ASSIGNMENT FOREIGN KEY (assignment_id) REFERENCES workout_assignment (id);