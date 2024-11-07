package com.wora.itlens.models.dtos.surveyEditions;

import com.wora.itlens.annotation.Exists;
import com.wora.itlens.models.entites.Survey;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record UpdateSurveyEditionDto(
        @NotNull @Future LocalDate creationDate,
        @NotNull @Future LocalDate startDate,
        @NotNull Integer date,
        @NotNull @Positive @Exists(entity = Survey.class) Long surveyId

) {
}
