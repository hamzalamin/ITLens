package com.wora.itlens.services.impl;

import com.wora.itlens.mappers.AnswerResponseMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class AnswerResponseServiceTest {
    @Mock
    private AnswerService answerService;

    @Mock
    private QuestionService questionService;

    @Mock
    private AnswerResponseMapper answerResponseMapper;

    @InjectMocks
    private AnswerResponseService answerResponseService;




}