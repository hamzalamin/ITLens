package com.wora.itlens.services.impl;

import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.models.dtos.subjects.UpdateSubjectDto;
import com.wora.itlens.services.interfaces.ISubjectService;

import java.util.List;

public class SubjectService implements ISubjectService {
    @Override
    public SubjectDto save(CreateSubjectDto createSubjectDto) {
        return null;
    }

    @Override
    public SubjectDto findById(Long id) {
        return null;
    }

    @Override
    public SubjectDto update(UpdateSubjectDto updateSubjectDto, Long id) {
        return null;
    }

    @Override
    public List<SubjectDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }
}
