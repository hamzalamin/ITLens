package com.wora.itlens.models.dtos.surveyEditions;

import com.wora.itlens.models.dtos.subjects.EmbeddedSubjectDto;
import com.wora.itlens.models.dtos.surveys.EmbeddedSurveyDto;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public record SurveyEditionDto(
        @NotNull @Positive Long id,
        @NotNull @Future LocalDate creationDate,
        @NotNull @Future LocalDate startDate,
        @NotNull Integer date,
        EmbeddedSurveyDto survey,
        List<EmbeddedSubjectDto> subjects
) {
}
