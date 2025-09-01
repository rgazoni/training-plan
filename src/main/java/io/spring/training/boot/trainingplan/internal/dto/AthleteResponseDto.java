package io.spring.training.boot.trainingplan.internal.dto;

public record AthleteResponseDto(
        long id,
        String cpf,
        String firstName,
        String lastName,
        int age,
        double weightKg
) {}
