package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.SubjectMapper;
import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.models.dtos.subjects.UpdateSubjectDto;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.repositories.SubjectRepository;
import com.wora.itlens.services.interfaces.ISubSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubSubjectService implements ISubSubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public SubjectDto savedSubSubject(Long subjectId, CreateSubjectDto createSubjectDto) {
        Subject parentSubject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new EntityNotFoundException("Subject", subjectId));

        Subject subSubject = subjectMapper.toEntity(createSubjectDto);
        subSubject.setSubject(parentSubject);
        Subject savedSubject = subjectRepository.save(subSubject);
        return subjectMapper.toDto(savedSubject);
    }

    @Override
    public SubjectDto save(CreateSubjectDto createSubjectDto) {
        throw new UnsupportedOperationException("Generic save operation is not supported. Use savedSubSubject instead.");
    }

    @Override
    public SubjectDto findById(Long id) {
        Subject parentSubject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject", id));
        return subjectMapper.toDto(parentSubject);
    }

    @Override
    public SubjectDto update(UpdateSubjectDto updateSubjectDto, Long id) {
        Subject parentSubject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject", id));
        parentSubject.setTitle(updateSubjectDto.title());
        return subjectMapper.toDto(parentSubject);
    }

    @Override
    public List<SubjectDto> findAll() {
        return subjectRepository.findAll().stream()
                .map(subjectMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        Subject parentSubject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject", id));
        subjectRepository.delete(parentSubject);
    }
}
