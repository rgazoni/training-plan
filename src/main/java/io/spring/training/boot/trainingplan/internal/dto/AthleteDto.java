package io.spring.training.boot.trainingplan.internal.dto;

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
        @NotNull(message = "First name mustn't be null.")
        @Size(min = 1, max = 50)
        String firstName,
        @NotNull(message = "Last name mustn't be null.")
        @Size(min = 1, max = 50)
        String lastName
) {}
