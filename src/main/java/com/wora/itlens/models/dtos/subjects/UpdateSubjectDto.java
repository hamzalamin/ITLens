package com.wora.itlens.models.dtos.subjects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UpdateSubjectDto(
        @NotBlank String title,
        @Positive Long surveyEditionId,
        @Positive Long subjectId
) {
}
