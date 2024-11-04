package com.wora.itlens.services.impl;


import com.wora.itlens.mappers.AnswerMapper;
import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.answers.CreateAnswerDto;
import com.wora.itlens.models.entites.Answer;
import com.wora.itlens.models.entites.Question;
import com.wora.itlens.repositories.AnswerRepository;
import com.wora.itlens.services.interfaces.IAnswerService;
import com.wora.itlens.services.interfaces.IQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.xml.validation.Validator;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AnswerServiceTest {

    @InjectMocks
    private AnswerService sut;

    @Mock
    private AnswerRepository answerRepository;

    @Mock
    private IQuestionService questionService;

    @Mock
    private AnswerMapper answerMapper;

    @Test
    @DisplayName("Should Create Successfully")
    void create_shouldCreteSuccessfully(){
        CreateAnswerDto createAnswerDto = new CreateAnswerDto("TEST TEST YAN SIN", 1L);

        Question question = new Question();
        question.setId(1L);


        Answer expectedAnswer = new Answer();
        expectedAnswer.setText("TEST TEST YAN SIN");

        when(questionService.getQuestionEntity(createAnswerDto.questionId())).thenReturn(question);
        when(answerMapper.toEntity(createAnswerDto)).thenReturn(expectedAnswer);
        when(answerRepository.save(expectedAnswer)).thenReturn(expectedAnswer);
        when(answerMapper.toDto(expectedAnswer)).thenReturn(new AnswerDto(1L, "YAN SIN CHECK", 5));

        AnswerDto result = sut.save(createAnswerDto);
        assertNotNull(result);
        verify(questionService).getQuestionEntity(createAnswerDto.questionId());
        verify(answerMapper).toEntity(createAnswerDto);
        verify(answerRepository).save(expectedAnswer);
        verify(answerMapper).toDto(expectedAnswer);
    }
}