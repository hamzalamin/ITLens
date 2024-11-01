package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.dtos.subjects.SubjectDto;
import com.wora.itlens.models.dtos.subjects.UpdateSubjectDto;
import com.wora.itlens.services.interfaces.ISubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final ISubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(
            @RequestBody @Valid CreateSubjectDto createSubjectDto
    ){
        return new ResponseEntity<>(subjectService.save(createSubjectDto), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SubjectDto> updateSubject(
            @PathVariable Long id,
            @RequestBody @Valid UpdateSubjectDto updateSubjectDto
    ){
        return new ResponseEntity<>(subjectService.update(updateSubjectDto, id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(subjectService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SubjectDto>> findAll(){
        List<SubjectDto> subjectDtoList = subjectService.findAll();
        return new ResponseEntity<>(subjectDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        subjectService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
