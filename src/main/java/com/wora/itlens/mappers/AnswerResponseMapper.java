package com.wora.itlens.mappers;

import com.wora.itlens.models.dtos.answerResponses.AnswerResponseDto;
import com.wora.itlens.models.dtos.answers.EmbeddedAnswerDto;
import com.wora.itlens.models.dtos.questions.EmbeddedQuestionDto;
import com.wora.itlens.models.entites.Answer;
import com.wora.itlens.models.entites.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AnswerMapper.class, QuestionMapper.class})
public interface AnswerResponseMapper {

    @Mapping(target = "answer", source = "answer")
    @Mapping(target = "question", source = "question")
    AnswerResponseDto toDto(Answer answer, Question question);
    EmbeddedAnswerDto toEmbeddedAnswerDto(Answer answer);
    EmbeddedQuestionDto toEmbeddedQuestionDto(Question question);
}