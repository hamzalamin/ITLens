package com.wora.itlens.mappers;

import com.wora.itlens.mappers.api.GenericMapper;
import com.wora.itlens.models.dtos.questions.CreateQuestionDto;
import com.wora.itlens.models.dtos.questions.EmbeddedQuestionDto;
import com.wora.itlens.models.dtos.questions.QuestionsDto;
import com.wora.itlens.models.dtos.questions.UpdateQuestionDto;
import com.wora.itlens.models.entites.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends GenericMapper<Question, QuestionsDto> {
    Question toEntity(QuestionsDto questionsDto);
    Question toEntity(CreateQuestionDto questionsDto);
    Question toEntity(UpdateQuestionDto questionsDto);
    QuestionsDto toDto(Question question);
}
