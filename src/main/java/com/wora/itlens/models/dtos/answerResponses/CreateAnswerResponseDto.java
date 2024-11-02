package com.wora.itlens.models.dtos.answerResponses;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateAnswerResponseDto(
        @Positive @NotNull Long answerId,
        @Positive @NotNull Long questionId
) {
}
