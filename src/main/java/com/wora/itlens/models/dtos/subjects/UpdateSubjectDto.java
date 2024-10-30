package com.wora.itlens.models.dtos.subjects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateSubjectDto(
        @NotBlank String title,
        @NotNull @Positive Long surveyEdition,
        @NotNull @Positive Long subject
) {
}
