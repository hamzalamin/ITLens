package com.wora.itlens.models.dtos.answerResponses;



public record GeneralRequestDto(
    CreateAnswerResponseDto createAnswerResponseDto,
    CreateMultipleAnswersAndOneQuestionDto createMultipleAnswersAndOneQuestionDto,
    CreateMultipleAnswersAndMultipleResponsesDto createMultipleAnswersAndMultipleResponsesDto
){}