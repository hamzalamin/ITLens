package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.dtos.answerResponses.AnswerResponseDto;
import com.wora.itlens.models.dtos.answerResponses.CreateMultipleAnswersAndMultipleResponsesDto;
import com.wora.itlens.models.dtos.answerResponses.CreateMultipleAnswersAndOneQuestionDto;
import com.wora.itlens.models.dtos.answerResponses.QuestionWithAnswersResponseDto;

import java.util.List;

public interface IAnswerResponseService {
    List<QuestionWithAnswersResponseDto> createAnswersForQuestion(CreateMultipleAnswersAndOneQuestionDto dto);
    List<QuestionWithAnswersResponseDto> processMultipleQuestionsAndAnswers(CreateMultipleAnswersAndMultipleResponsesDto dto);
    AnswerResponseDto saveUserAnswer(Long answerId, Long questionId);

}
