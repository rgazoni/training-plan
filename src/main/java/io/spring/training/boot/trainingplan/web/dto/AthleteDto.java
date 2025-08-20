package io.spring.training.boot.trainingplan.web.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public record AthleteDto(
        @NotNull(message = "CPF mustn't be null.")
        @CPF
        String cpf,
        @NotNull(message = "Weight mustn't be null.")
        @Positive
        Double weightKg,
        @NotNull(message = "Age mustn't be null.")
        @Positive
        @Min(15)
        @Max(80)
        Integer age,
        @NotNull(message = "Firstname mustn't be null.")
        @Size(min = 1, max = 50)
        String firstName,
        @NotNull(message = "Surname mustn't be null.")
        @Size(min = 1, max = 50)
        String lastName
) {}
