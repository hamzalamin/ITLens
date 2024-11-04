package com.wora.itlens.models.dtos.answerResponses;

import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.questions.QuestionsDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GeneralRequestDto {
    private List<QuestionsDto> questions;
    private Long questionId;
    private List<AnswerDto> answers;
    private Long answerId;
    private Long singleQuestionId;

}