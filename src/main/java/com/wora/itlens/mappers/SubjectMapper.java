package com.wora.itlens.mappers;

import com.wora.itlens.mappers.api.GenericMapper;
import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.models.dtos.subjects.UpdateSubjectDto;
import com.wora.itlens.models.entites.Subject;

public interface SubjectMapper extends GenericMapper<Subject, SubjectDto> {
    Subject toEntity(CreateSubjectDto createSubjectDto);
    Subject toEntity(UpdateSubjectDto updateSubjectDto);
    Subject toEntity(SubjectDto subjectDto);
    SubjectDto toDto(Subject subject);
}
