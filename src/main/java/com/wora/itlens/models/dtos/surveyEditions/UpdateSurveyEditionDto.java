package com.wora.itlens.models.dtos.surveyEditions;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateSurveyEditionDto(
        @NotNull @Future LocalDate creationDate,
        @NotNull @Future LocalDate startDate,
        @NotNull @Future LocalDate date
) {
}
