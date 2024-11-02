package com.wora.itlens.models.dtos.answers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateAnswerDto(
        @NotBlank String text,
        @Positive @NotNull Long questionId
) {
}
