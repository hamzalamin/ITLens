package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.answerResponses.*;
import com.wora.itlens.services.interfaces.IAnswerResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
@RequiredArgsConstructor
public class AnswerResponseController {
    private final IAnswerResponseService answerResponseService;

    @PostMapping("/create-multiple")
    public ResponseEntity<List<QuestionWithAnswersResponseDto>> createAnswers(@RequestBody CreateMultipleAnswersAndOneQuestionDto dto) {
        List<QuestionWithAnswersResponseDto> createdAnswers = answerResponseService.createAnswersForQuestion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswers);
    }

    @PostMapping("/process-multiple")
    public ResponseEntity<List<QuestionWithAnswersResponseDto>> processMultipleQuestionsAndAnswers(@RequestBody CreateMultipleAnswersAndMultipleResponsesDto dto) {
        List<QuestionWithAnswersResponseDto> response = answerResponseService.processMultipleQuestionsAndAnswers(dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/response")
    public ResponseEntity<AnswerResponseDto> saveAnswerResponse(@RequestBody CreateAnswerResponseDto createAnswerResponseDto){
        return new  ResponseEntity<>(answerResponseService.saveUserAnswer(createAnswerResponseDto.answerId(), createAnswerResponseDto.questionId()), HttpStatus.OK);
    }

}
