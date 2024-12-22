package com.wora.itlens.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wora.itlens.models.dtos.subjects.CreateSubjectDto;
import com.wora.itlens.models.entites.Subject;
import com.wora.itlens.repositories.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ObjectMapper objectMapper;

//
//    @Test
//    void create_Successfully() throws Exception {
//        Subject parentSubject = new Subject();
//        parentSubject.setTitle("Parent Subject");
//        parentSubject = subjectRepository.save(parentSubject);
//
//        CreateSubjectDto dto = new CreateSubjectDto("Title Nooormal", 1L, parentSubject.getId());
//        String requestJson = objectMapper.writeValueAsString(dto);
//
//        mockMvc.perform(post("/subjects")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestJson))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void getById_Successfully() throws Exception{
//        Subject parentSubject = new Subject();
//        parentSubject.setTitle("Parent Subject");
//        parentSubject = subjectRepository.save(parentSubject);
//
//        Subject subject = new Subject();
//        subject.setTitle("Title Nooormal");
//        subject.setSubject(parentSubject);
//        subject = subjectRepository.save(subject);
//
//        mockMvc.perform(get("/subjects/{id}", subject.getId())
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(subject.getId()))
//                .andExpect(jsonPath("$.title").value(subject.getTitle()));
//
//    }
//
//
//    @Test
//    void create_fail() throws Exception {
//        CreateSubjectDto dto = new CreateSubjectDto("Title Nooormal", 1L, 999999L);
//        String requestJson = objectMapper.writeValueAsString(dto);
//
//        mockMvc.perform(post("/subjects")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestJson))
//                .andExpect(status().isNotFound());
//    }

    @Test
    void getById_Fail_NotFound() throws Exception {
        long nonExistentSubjectId = 999L;

        mockMvc.perform(get("/subjects/{id}", nonExistentSubjectId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

//    @Test
//    void create_Fail_InvalidTitle() throws Exception {
//
//        CreateSubjectDto dto = new CreateSubjectDto("", 1L, 1L);
//
//        String requestJson = objectMapper.writeValueAsString(dto);
//
//        mockMvc.perform(post("/subjects")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestJson))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$[0]").value("must not be blank"));
//
//    }
}
