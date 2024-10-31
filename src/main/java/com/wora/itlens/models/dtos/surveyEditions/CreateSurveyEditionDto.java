package com.wora.itlens.models.dtos.surveyEditions;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record CreateSurveyEditionDto(
        @NotNull @Future LocalDate creationDate,
        @NotNull @Future LocalDate startDate,
        @NotNull @Future LocalDate date,
        @NotNull @Positive Long surveyId
) {
}
