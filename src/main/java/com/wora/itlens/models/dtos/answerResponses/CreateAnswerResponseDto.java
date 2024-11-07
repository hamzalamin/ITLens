package com.wora.itlens.models.dtos.answerResponses;

import com.wora.itlens.annotation.Exists;
import com.wora.itlens.models.entites.Answer;
import com.wora.itlens.models.entites.Question;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateAnswerResponseDto(
        @Positive @NotNull @Exists(entity = Answer.class) Long answerId,
        @Positive @NotNull @Exists(entity = Question.class) Long questionId
) {
}
