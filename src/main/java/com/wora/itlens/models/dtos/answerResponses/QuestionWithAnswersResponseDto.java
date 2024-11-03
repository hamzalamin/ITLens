package com.wora.itlens.models.dtos.answerResponses;
import com.wora.itlens.models.dtos.questions.EmbeddedQuestionDto;

import java.util.List;

public record QuestionWithAnswersResponseDto(
        EmbeddedQuestionDto question,
        List<AnswerResponseDto> answers
) {}