package com.wora.itlens.mappers;

import com.wora.itlens.mappers.api.GenericMapper;
import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.models.dtos.subjects.UpdateSubjectDto;
import com.wora.itlens.models.entites.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends GenericMapper<Subject, SubjectDto> {
    Subject toEntity(CreateSubjectDto dto);
    Subject toEntity(UpdateSubjectDto dto);
    Subject toEntity(SubjectDto dto);
    SubjectDto toDto(Subject subject);
}
