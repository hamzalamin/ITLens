package com.wora.itlens.controllers;


import com.wora.itlens.models.dtos.answerResponses.AnswerResponseDto;
import com.wora.itlens.models.dtos.answerResponses.CreateAnswerResponseDto;
import com.wora.itlens.models.dtos.answers.AnswerDto;
import com.wora.itlens.models.dtos.answers.CreateAnswerDto;
import com.wora.itlens.models.dtos.answers.UpdateAnswerDto;
import com.wora.itlens.services.interfaces.IAnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {

    private final IAnswerService answerService;


    @PostMapping
    public ResponseEntity<AnswerDto> createAnswer(@RequestBody @Valid CreateAnswerDto createAnswerDto){
        return new ResponseEntity<>(answerService.save(createAnswerDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(answerService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AnswerDto>> findAll(){
        List<AnswerDto> answerDtoList = answerService.findAll();
        return new ResponseEntity<>(answerDtoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerDto> update(
            @PathVariable Long id,
            @RequestBody @Valid UpdateAnswerDto updateAnswerDto
    )
    {
        return new ResponseEntity<>(answerService.update(updateAnswerDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        answerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/response")
    public ResponseEntity<AnswerResponseDto> saveAnswerResponse(@RequestBody CreateAnswerResponseDto createAnswerResponseDto){
        return new  ResponseEntity<>(answerService.saveUserAnswer(createAnswerResponseDto.answerId(), createAnswerResponseDto.questionId()), HttpStatus.OK);
    }


//    @PostMapping("/multiple")
//    public ResponseEntity<List<AnswerResponseDto>> saveUserMultipleAnswer(@RequestBody MultipleAnswersDto dto) {
//        List<AnswerResponseDto> answerResponseDtoList = answerService.saveUserMultipleAnswer(dto);
//        return new ResponseEntity<>(answerResponseDtoList, HttpStatus.CREATED);
//    }
}
