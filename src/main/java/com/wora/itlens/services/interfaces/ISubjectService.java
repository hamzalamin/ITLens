package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.models.dtos.subjects.UpdateSubjectDto;
import com.wora.itlens.services.GenericService;

public interface ISubjectService extends GenericService<CreateSubjectDto, UpdateSubjectDto, SubjectDto, Long> {
    SubjectDto saveSubject(Long surveyEditionId, CreateSubjectDto createSubjectDto);
}