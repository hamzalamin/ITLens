package com.wora.itlens.services.impl;

import com.wora.itlens.mappers.AnswerResponseMapper;
import com.wora.itlens.models.dtos.answerResponses.CreateMultipleAnswersAndMultipleResponsesDto;
import com.wora.itlens.models.dtos.answerResponses.CreateMultipleAnswersAndOneQuestionDto;
import com.wora.itlens.models.dtos.answerResponses.QuestionWithAnswersResponseDto;
import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.answers.EmbeddedAnswerDto;
import com.wora.itlens.models.dtos.questions.QuestionsDto;
import com.wora.itlens.models.dtos.subjects.EmbeddedSubjectDto;
import com.wora.itlens.models.dtos.surveyEditions.EmbeddedSurveyEditionsDto;
import com.wora.itlens.models.entites.Answer;
import com.wora.itlens.models.entites.Question;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.models.enumes.QuestionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnswerResponseServiceTest {
    @Mock
    private AnswerService answerService;

    @Mock
    private QuestionService questionService;

    @Mock
    private AnswerResponseMapper answerResponseMapper;

    @InjectMocks
    private AnswerResponseService answerResponseService;


    @Test
    @DisplayName("createAnswersForQuestion() Should increment selection and answer counts")
    void createAnswersForQuestion_shouldIncrementCountsSuccessfully() {
        Long questionId = 1L;
        CreateMultipleAnswersAndOneQuestionDto dto = new CreateMultipleAnswersAndOneQuestionDto(List.of(new AnswerDto(1L, "Hamza", 1), new AnswerDto(2L, "LAMIN", 2)), questionId);

        Question mockQuestion = new Question();
        mockQuestion.setAnswerCount(2);

        Answer mockAnswer = new Answer();
        mockAnswer.setSelectionCount(3);

        when(questionService.getQuestionEntity(questionId)).thenReturn(mockQuestion);
        when(answerService.getAnswerEntity(anyLong())).thenReturn(mockAnswer);
        when(answerService.saveAnswerEntity(any(Answer.class))).thenReturn(mockAnswer);
        when(questionService.saveQuestionEntity(any(Question.class))).thenReturn(mockQuestion);

        answerResponseService.createAnswersForQuestion(dto);

        verify(questionService).getQuestionEntity(questionId);

        for (AnswerDto answerDto : dto.answers()) {
            verify(answerService).getAnswerEntity(answerDto.id());
        }

        verify(answerService, times(dto.answers().size())).saveAnswerEntity(mockAnswer);

        verify(questionService).saveQuestionEntity(mockQuestion);

        assertEquals(4, mockQuestion.getAnswerCount());
        assertEquals(5, mockAnswer.getSelectionCount());
    }


    @Test
    @DisplayName("createAnswersForQuestion() Should not change counts when no answers are provided")
    void createAnswersForQuestion_noAnswersProvided_shouldNotChangeCounts() {
        Long questionId = 1L;
        CreateMultipleAnswersAndOneQuestionDto dto = new CreateMultipleAnswersAndOneQuestionDto(List.of(), questionId);

        Question mockQuestion = new Question();
        mockQuestion.setAnswerCount(2);

        when(questionService.getQuestionEntity(questionId)).thenReturn(mockQuestion);

        answerResponseService.createAnswersForQuestion(dto);

        verify(questionService).getQuestionEntity(questionId);
        verify(questionService).saveQuestionEntity(mockQuestion);

        assertEquals(2, mockQuestion.getAnswerCount());
    }

    @Test
    @DisplayName("createAnswersForQuestion() Should throw exception for invalid answer ID")
    void createAnswersForQuestion_invalidAnswerId_shouldThrowException() {
        Long questionId = 1L;
        CreateMultipleAnswersAndOneQuestionDto dto = new CreateMultipleAnswersAndOneQuestionDto(
                List.of(new AnswerDto(999L, "Invalid Answer", 1)), questionId
        );

        Question mockQuestion = new Question();
        mockQuestion.setAnswerCount(2);

        when(questionService.getQuestionEntity(questionId)).thenReturn(mockQuestion);
        when(answerService.getAnswerEntity(999L)).thenThrow(new NoSuchElementException("Answer not found"));

        assertThrows(NoSuchElementException.class, () -> {
            answerResponseService.createAnswersForQuestion(dto);
        });

        verify(questionService).getQuestionEntity(questionId);
        verify(answerService).getAnswerEntity(999L);
        verifyNoMoreInteractions(questionService);
    }

    @Test
    @DisplayName("processMultipleQuestionsAndAnswers() Should increment selection and answer counts")
    void processMultipleQuestionsAndAnswers_shouldIncrementCountsSuccessfully() {

        EmbeddedSurveyEditionsDto surveyEditionDto = new EmbeddedSurveyEditionsDto(
                1L,
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(2),
                LocalDate.now().plusDays(3)
        );

        EmbeddedSubjectDto subjectDto = new EmbeddedSubjectDto(1L, "Subject Title", surveyEditionDto);

        List<AnswerDto> answerDtos = List.of(
                new AnswerDto(1L, "Answer 1", 1),
                new AnswerDto(2L, "Answer 2", 2)
        );

        List<EmbeddedAnswerDto> embeddedAnswerDto = List.of(
                new EmbeddedAnswerDto(1L, "hhhh",2),
                new EmbeddedAnswerDto(1L, "hhhh",2)
        );


        List<QuestionsDto> questionsDtos = List.of(
                new QuestionsDto(1L, "Question Title", 1, QuestionType.MULTIPLE_CHOICE, subjectDto, embeddedAnswerDto)
        );

        CreateMultipleAnswersAndMultipleResponsesDto dto = new CreateMultipleAnswersAndMultipleResponsesDto(answerDtos, questionsDtos);

        Question mockQuestion = new Question();
        mockQuestion.setAnswerCount(2);

        Answer mockAnswer1 = new Answer();
        mockAnswer1.setSelectionCount(3);

        Answer mockAnswer2 = new Answer();
        mockAnswer2.setSelectionCount(4);

        when(questionService.getQuestionEntity(anyLong())).thenReturn(mockQuestion);
        when(answerService.getAnswerEntity(1L)).thenReturn(mockAnswer1);
        when(answerService.saveAnswerEntity(any(Answer.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(questionService.saveQuestionEntity(any(Question.class))).thenReturn(mockQuestion);

        List<QuestionWithAnswersResponseDto> responses = answerResponseService.processMultipleQuestionsAndAnswers(dto);

        assertEquals(1, responses.size());
        QuestionWithAnswersResponseDto response = responses.getFirst();

        assertEquals(4, mockQuestion.getAnswerCount());
        assertEquals(5, mockAnswer1.getSelectionCount());
        assertEquals(4, mockAnswer2.getSelectionCount());
    }
}