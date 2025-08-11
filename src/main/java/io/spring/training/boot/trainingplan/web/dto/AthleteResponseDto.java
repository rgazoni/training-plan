package io.spring.training.boot.trainingplan.web.dto;

public record AthleteResponseDto(
        long id,
        String socialIdentifier,
        String firstName,
        String lastName,
        int age,
        double weight
) {}
