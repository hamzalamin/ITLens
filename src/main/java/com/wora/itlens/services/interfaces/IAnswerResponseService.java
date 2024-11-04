package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.dtos.answerResponses.CreateMultipleAnswersAndMultipleResponsesDto;
import com.wora.itlens.models.dtos.answerResponses.CreateMultipleAnswersAndOneQuestionDto;
import com.wora.itlens.models.dtos.answerResponses.QuestionWithAnswersResponseDto;

import java.util.List;

public interface IAnswerResponseService {
    List<QuestionWithAnswersResponseDto> createAnswersForQuestion(CreateMultipleAnswersAndOneQuestionDto dto);
    List<Object> processMultipleQuestionsAndAnswers(CreateMultipleAnswersAndMultipleResponsesDto dto);

}
