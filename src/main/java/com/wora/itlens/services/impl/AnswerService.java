package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.AnswerMapper;
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

    @Override
    public AnswerDto save(CreateAnswerDto createAnswerDto) {
        Question question = questionService.getQuestionEntity(createAnswerDto.questionId());
        Answer answer = answerMapper.toEntity(createAnswerDto);
        answer.setQuestion(question)    ;
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
    public Answer getAnswerEntity(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Answer ID must not be null");
        }
        return answerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Answer", id));
    }

    @Override
    public Answer saveAnswerEntity(Answer answer) {
        if (answer.getId() != null) {
            Answer answer1 = answerRepository.findById(answer.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Question", answer.getId()));
            answer1.setSelectionCount(answer.getSelectionCount());
            return answerRepository.save(answer1);
        }
        return answerRepository.save(answer);
    }

}
