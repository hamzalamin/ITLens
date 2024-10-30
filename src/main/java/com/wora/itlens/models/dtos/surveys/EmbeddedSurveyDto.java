package com.wora.itlens.models.dtos.surveys;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EmbeddedSurveyDto(
        @NotNull @Positive Long id,
        @NotBlank String title,
        @NotBlank String description
) {
}
