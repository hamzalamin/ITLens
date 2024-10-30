package com.wora.itlens.models.dtos.answers;

import jakarta.validation.constraints.NotBlank;

public record CreateAnswerDto(
        @NotBlank String text
) {
}
