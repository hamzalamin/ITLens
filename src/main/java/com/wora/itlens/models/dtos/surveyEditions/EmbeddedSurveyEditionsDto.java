package com.wora.itlens.models.dtos.surveyEditions;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record EmbeddedSurveyEditionsDto(
        @NotNull @Positive Long id,
        @NotNull @Future LocalDate creationDate,
        @NotNull @Future LocalDate startDate,
        @NotNull Integer date
) {
}
