package com.wora.itlens.services.impl;

import com.wora.itlens.mappers.AnswerResponseMapper;
import com.wora.itlens.models.dtos.answerResponses.*;
import com.wora.itlens.models.entites.Answer;
import com.wora.itlens.models.entites.Question;
import com.wora.itlens.services.interfaces.IAnswerResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerResponseService implements IAnswerResponseService {

    private final AnswerService answerService;
    private final QuestionService questionService;
    private final AnswerResponseMapper answerResponseMapper;


    @Override
    public List<QuestionWithAnswersResponseDto> createAnswersForQuestion(CreateMultipleAnswersAndOneQuestionDto dto) {
        Question question = questionService.getQuestionEntity(dto.questionId());

        int newAnswersCount = dto.answers().size();
        question.setAnswerCount(question.getAnswerCount() + newAnswersCount);

        List<AnswerResponseDto> createdAnswerResponses = dto.answers().stream()
                .map(answerDto -> {
                    Answer answer = answerService.getAnswerEntity(answerDto.id());
                    answer.setSelectionCount(answer.getSelectionCount() + 1);
                    Answer savedAnswer = answerService.saveAnswerEntity(answer);
                    return answerResponseMapper.toDto(savedAnswer, question);
                })
                .toList();

        Question savedQuestion = questionService.saveQuestionEntity(question);

        return Collections.singletonList(
                new QuestionWithAnswersResponseDto(
                        answerResponseMapper.toEmbeddedQuestionDto(savedQuestion),
                        createdAnswerResponses
                )
        );
    }

    @Override
    public List<QuestionWithAnswersResponseDto> processMultipleQuestionsAndAnswers(CreateMultipleAnswersAndMultipleResponsesDto dto) {
        List<QuestionWithAnswersResponseDto> responses = dto.questions().stream()
                .map(questionDto -> {
                    // Retrieve and update question entity
                    Question question = questionService.getQuestionEntity(questionDto.id());
                    int newAnswersCount = questionDto.answers().size();
                    question.setAnswerCount(question.getAnswerCount() + newAnswersCount);

                    // Create or update each answer associated with the question
                    List<AnswerResponseDto> createdAnswerResponses = questionDto.answers().stream()
                            .map(answerDto -> {
                                Answer answer = answerService.getAnswerEntity(answerDto.id());
                                answer.setSelectionCount(answer.getSelectionCount() + 1);
                                Answer savedAnswer = answerService.saveAnswerEntity(answer);
                                return answerResponseMapper.toDto(savedAnswer, question);
                            })
                            .toList();

                    // Save updated question
                    Question savedQuestion = questionService.saveQuestionEntity(question);

                    // Map question and its answers to the response DTO
                    return new QuestionWithAnswersResponseDto(
                            answerResponseMapper.toEmbeddedQuestionDto(savedQuestion),
                            createdAnswerResponses
                    );
                })
                .toList();

        return responses;
    }


}

