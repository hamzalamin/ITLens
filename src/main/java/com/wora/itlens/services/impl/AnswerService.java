package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.AnswerMapper;
import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.answers.CreateAnswerDto;
import com.wora.itlens.models.dtos.answers.UpdateAnswerDto;
import com.wora.itlens.models.entites.Answer;
import com.wora.itlens.repositories.AnswerRepository;
import com.wora.itlens.services.interfaces.IAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService implements IAnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

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
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
