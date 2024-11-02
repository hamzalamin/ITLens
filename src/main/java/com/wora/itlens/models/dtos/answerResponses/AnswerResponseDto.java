package com.wora.itlens.models.dtos.answerResponses;

import com.wora.itlens.models.dtos.answers.EmbeddedAnswerDto;
import com.wora.itlens.models.dtos.questions.EmbeddedQuestionDto;

public record AnswerResponseDto(
        EmbeddedAnswerDto answer,
        EmbeddedQuestionDto question
) {
}
