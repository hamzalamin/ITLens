package com.wora.itlens.models.dtos.surveyEditions;

import com.wora.itlens.models.dtos.subjects.EmbeddedSubjectDto;
import com.wora.itlens.models.entites.Survey;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public record EmbeddedSurveyEditions(
        @NotNull @Positive Long id,
        @NotNull @Future LocalDate creationDate,
        @NotNull @Future LocalDate startDate,
        @NotNull @Future LocalDate date,
        Survey survey,
        List<EmbeddedSubjectDto> subjects
) {
}
