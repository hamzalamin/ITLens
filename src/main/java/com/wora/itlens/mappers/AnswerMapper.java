package com.wora.itlens.mappers;

import com.wora.itlens.mappers.api.GenericMapper;
import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.answers.CreateAnswerDto;
import com.wora.itlens.models.dtos.answers.UpdateAnswerDto;
import com.wora.itlens.models.entites.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends GenericMapper<Answer, AnswerDto> {
    Answer toEntity(AnswerDto dto);
    Answer toEntity(CreateAnswerDto dto);
    Answer toEntity(UpdateAnswerDto dto);
    AnswerDto toDto(Answer answer);
}
