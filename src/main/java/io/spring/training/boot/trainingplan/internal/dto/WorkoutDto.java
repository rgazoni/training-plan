package io.spring.training.boot.trainingplan.internal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.spring.training.boot.trainingplan.internal.domain.common.Sport;
import jakarta.validation.constraints.*;

import java.time.Duration;

public record WorkoutDto (
        @NotBlank
        String name,
        Sport sport,
        @NotBlank
        String trainType,
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        //@DurationMin(minutes = 1)
        Duration durationMin,
        //@DecimalMin("0.0")
        @NotNull
        @Positive
        Integer distanceM,
        @NotNull
        String description) {}
