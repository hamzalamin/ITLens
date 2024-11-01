package com.wora.itlens.services.impl;

import com.wora.itlens.models.dtos.questions.CreateQuestionDto;
import com.wora.itlens.models.dtos.questions.QuestionsDto;
import com.wora.itlens.models.dtos.questions.UpdateQuestionDto;
import com.wora.itlens.services.interfaces.IQuestionService;

import java.util.List;

public class QuestionService implements IQuestionService {
    @Override
    public QuestionsDto save(CreateQuestionDto createQuestionDto) {
        return null;
    }

    @Override
    public QuestionsDto findById(Long id) {
        return null;
    }

    @Override
    public QuestionsDto update(UpdateQuestionDto updateQuestionDto, Long id) {
        return null;
    }

    @Override
    public List<QuestionsDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
