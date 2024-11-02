package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.AnswerMapper;
import com.wora.itlens.mappers.AnswerResponseMapper;
import com.wora.itlens.models.dtos.answerResponses.AnswerResponseDto;
import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.answers.CreateAnswerDto;
import com.wora.itlens.models.dtos.answers.UpdateAnswerDto;
import com.wora.itlens.models.entites.Answer;
import com.wora.itlens.models.entites.Question;
import com.wora.itlens.repositories.AnswerRepository;
import com.wora.itlens.services.interfaces.IAnswerService;
import com.wora.itlens.services.interfaces.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService implements IAnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;
    private final IQuestionService questionService;
    private final AnswerResponseMapper answerResponseMapper;

    @Override
    public AnswerDto save(CreateAnswerDto createAnswerDto) {
        Answer answer = answerMapper.toEntity(createAnswerDto);
        Answer savedAnswer = answerRepository.save(answer);
        return answerMapper.toDto(savedAnswer);
    }

    @Override
    public AnswerDto findById(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer", id));
        return answerMapper.toDto(answer);
    }

    @Override
    public AnswerDto update(UpdateAnswerDto updateAnswerDto, Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer", id));
        answer.setText(updateAnswerDto.text());
        Answer updatedAnswer = answerRepository.save(answer);
        return answerMapper.toDto(updatedAnswer);
    }

    @Override
    public List<AnswerDto> findAll() {
        return answerRepository.findAll().stream()
                .map(answerMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer", id));
        answerRepository.delete(answer);
    }

    @Override
    public AnswerResponseDto saveUserAnswer(Long answerId, Long questionId) {
        Question question = questionService.getQuestionEntity(questionId);
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new EntityNotFoundException("Answer", questionId));

        if (!answer.getQuestion().getId().equals(questionId)) {
            throw new IllegalArgumentException("Answer does not belong to the specified question");
        }

        question.setAnswerCount(question.getAnswerCount() + 1);
        answer.setSelectionCount(answer.getSelectionCount() + 1);
        questionService.saveQuestionEntity(question);
        answer = answerRepository.save(answer);

        return answerResponseMapper.toDto(answer, question);

    }
}
