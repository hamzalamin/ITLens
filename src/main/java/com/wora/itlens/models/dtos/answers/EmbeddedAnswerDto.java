package com.wora.itlens.models.dtos.answers;

import com.wora.itlens.models.dtos.questions.EmbeddedQuestionDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EmbeddedAnswerDto(
        @Positive @NotNull Long id,
        @NotBlank String text,
        @Positive @NotNull Integer selectionCount,
        EmbeddedQuestionDto question
) {
}
