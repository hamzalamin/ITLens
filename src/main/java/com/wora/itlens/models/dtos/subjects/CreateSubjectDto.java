package com.wora.itlens.models.dtos.subjects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CreateSubjectDto(
        @NotBlank String title,
        @Positive Long surveyEditionId,
        @Positive Long subjectId
) {
}
