ALTER TABLE workout
    DROP COLUMN duration_min;

ALTER TABLE workout
    ADD duration_min BIGINT;