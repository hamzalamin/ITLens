package com.wora.itlens.services.interfaces;

import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.models.dtos.subjects.UpdateSubjectDto;
import com.wora.itlens.services.GenericService;

public interface ISubSubjectService extends GenericService<CreateSubjectDto, UpdateSubjectDto, SubjectDto, Long>{
    SubjectDto savedSubSubject(Long subjectId, CreateSubjectDto createSubjectDto);

}
