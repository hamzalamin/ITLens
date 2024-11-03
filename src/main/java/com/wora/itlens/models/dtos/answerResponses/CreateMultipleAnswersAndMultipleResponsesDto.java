package com.wora.itlens.models.dtos.answerResponses;

import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.questions.QuestionsDto;

import java.util.List;

public record CreateMultipleAnswersAndMultipleResponsesDto(
        List<AnswerDto> answers,
        List<QuestionsDto> questions
) {
}
