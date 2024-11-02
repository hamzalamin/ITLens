package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.dtos.questions.CreateQuestionDto;
import com.wora.itlens.models.dtos.questions.QuestionsDto;
import com.wora.itlens.models.dtos.questions.UpdateQuestionDto;
import com.wora.itlens.models.entites.Question;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.services.GenericService;

public interface IQuestionService extends GenericService<CreateQuestionDto, UpdateQuestionDto, QuestionsDto, Long> {
    Question getQuestionEntity(Long id);
    Question saveQuestionEntity(Question question);
}
