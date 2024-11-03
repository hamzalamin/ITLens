package com.wora.itlens.models.dtos.answerResponses;

import com.wora.itlens.models.dtos.answers.AnswerDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record CreateMultipleAnswersAndOneQuestionDto(
        List<AnswerDto> answers,
        @Positive @NotNull Long questionId

){
}
