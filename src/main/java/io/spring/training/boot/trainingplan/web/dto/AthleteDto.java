package io.spring.training.boot.trainingplan.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.br.CPF;

public record AthleteDto(
        @NotNull(message = "CPF mustn't be null.")
        @CPF
        String cpf,
        @NotNull(message = "Weight mustn't be null.")
        @Positive
        Double weight,
        @NotNull(message = "Age mustn't be null.")
        @Positive
        Integer age,
        @NotNull(message = "Firstname mustn't be null.")
        String firstName,
        @NotNull(message = "Surname mustn't be null.")
        String lastName
) {}
