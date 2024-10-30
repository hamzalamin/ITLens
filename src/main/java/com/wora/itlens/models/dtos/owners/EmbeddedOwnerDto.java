package com.wora.itlens.models.dtos.owners;

import com.wora.itlens.models.dtos.surveys.EmbeddedSurveyDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record EmbeddedOwnerDto(
        @NotNull @Positive Long id,
        @NotBlank String name,
        List<EmbeddedSurveyDto> surveys
) {
}
