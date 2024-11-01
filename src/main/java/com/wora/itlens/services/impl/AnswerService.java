package com.wora.itlens.services.impl;

import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.answers.CreateAnswerDto;
import com.wora.itlens.models.dtos.answers.UpdateAnswerDto;
import com.wora.itlens.services.interfaces.IAnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService implements IAnswerService {
    @Override
    public AnswerDto save(CreateAnswerDto createAnswerDto) {
        return null;
    }

    @Override
    public AnswerDto findById(Long id) {
        return null;
    }

    @Override
    public AnswerDto update(UpdateAnswerDto updateAnswerDto, Long id) {
        return null;
    }

    @Override
    public List<AnswerDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
