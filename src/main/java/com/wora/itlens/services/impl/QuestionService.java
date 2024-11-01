package com.wora.itlens.services.impl;

import com.wora.itlens.mappers.QuestionMapper;
import com.wora.itlens.models.dtos.questions.CreateQuestionDto;
import com.wora.itlens.models.dtos.questions.QuestionsDto;
import com.wora.itlens.models.dtos.questions.UpdateQuestionDto;
import com.wora.itlens.models.entites.Question;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.repositories.QuestionRepository;
import com.wora.itlens.services.interfaces.IQuestionService;
import com.wora.itlens.services.interfaces.ISubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final ISubjectService subjectService;

    @Override
    public QuestionsDto save(CreateQuestionDto createQuestionDto) {
        Subject subject = subjectService.getSubjectEntity(createQuestionDto.id());
        Question question = questionMapper.toEntity(createQuestionDto);
        question.setSubject(subject);
        Question savedQuestion = questionRepository.save(question);
        return questionMapper.toDto(savedQuestion);
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
