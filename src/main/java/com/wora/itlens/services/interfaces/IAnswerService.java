package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.dtos.answerResponses.AnswerResponseDto;
import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.answers.CreateAnswerDto;
import com.wora.itlens.models.dtos.answers.UpdateAnswerDto;
import com.wora.itlens.models.entites.Answer;
import com.wora.itlens.services.GenericService;

public interface IAnswerService extends GenericService<CreateAnswerDto, UpdateAnswerDto, AnswerDto, Long> {
    AnswerResponseDto saveUserAnswer(Long answerId, Long questionId);
    Answer getAnswerEntity(Long id);
    Answer saveAnswerEntity(Answer answer);
}
