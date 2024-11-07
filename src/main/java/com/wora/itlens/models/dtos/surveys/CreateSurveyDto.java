package com.wora.itlens.models.dtos.surveys;

import com.wora.itlens.annotations.Exists;
import com.wora.itlens.models.entites.Owner;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateSurveyDto(
        @NotBlank String title,
        @NotBlank String description,
        @NotNull @Positive @Exists(entity = Owner.class) Long ownerId

) {
}
