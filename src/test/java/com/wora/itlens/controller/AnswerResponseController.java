package com.wora.itlens.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wora.itlens.models.dtos.answerResponses.CreateAnswerResponseDto;
import com.wora.itlens.models.entites.Answer;
import com.wora.itlens.models.entites.Question;
import com.wora.itlens.repositories.AnswerRepository;
import com.wora.itlens.repositories.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class AnswerResponseController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSaveUserAnswer_Successful() throws Exception {
        Question question = new Question();
        question.setText("Sample Question");
        question.setAnswerCount(0);
        questionRepository.save(question);

        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setSelectionCount(0);
        answerRepository.save(answer);

        CreateAnswerResponseDto dto = new CreateAnswerResponseDto(answer.getId(), question.getId());
        String requestJson = objectMapper.writeValueAsString(dto);

        mockMvc.perform(post("/api/answers/response")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answer.id").value(answer.getId()))
                .andExpect(jsonPath("$.question.id").value(question.getId()))
                .andExpect(jsonPath("$.answer.selectionCount").value(answer.getSelectionCount()))
                .andExpect(jsonPath("$.question.answerCount").value(question.getAnswerCount()));

    }

    @Test
    void testSaveUserAnswer_InvalidAnswer() throws Exception{
        Question question = new Question();
        question.setText("Sample Question");
        question.setAnswerCount(0);
        questionRepository.save(question);

        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setSelectionCount(0);
        answerRepository.save(answer);

        CreateAnswerResponseDto requestDto = new CreateAnswerResponseDto(answer.getId(), question.getId() + 999);
        String requestJson = objectMapper.writeValueAsString(requestDto);
        mockMvc.perform(post("/api/answers/response")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                        .andExpect(status().isNotFound());

    }



}
