package com.wora.itlens.models.dtos.surveys;

import com.wora.itlens.models.dtos.owners.EmbeddedOwnerDto;
import com.wora.itlens.models.dtos.surveyEditions.EmbeddedSurveyEditionsDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record SurveyDto(
        @NotNull @Positive Long id,
        @NotBlank String title,
        @NotBlank String description,
        EmbeddedOwnerDto owner,
        List<EmbeddedSurveyEditionsDto> surveyEditions
) {
}
