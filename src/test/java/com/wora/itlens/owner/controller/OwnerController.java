package com.wora.itlens.owner.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.OwnerMapper;
import com.wora.itlens.models.dtos.owners.CreateOwnerDto;
import com.wora.itlens.models.dtos.owners.OwnerDto;
import com.wora.itlens.models.entites.Owner;
import com.wora.itlens.repositories.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OwnerController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerMapper ownerMapper;

    @Test
    void testCreateOwnerIntegration() throws Exception{
        CreateOwnerDto createOwnerDto = new CreateOwnerDto("Hamza");
        Owner ownerEntity = ownerMapper.toEntity(createOwnerDto);
        System.out.println("3la hadaa null ?? : " + ownerEntity.getId());
        Owner savedOwner = ownerRepository.save(ownerEntity);
        System.out.println("machi null brooojola: " + savedOwner.getId());

        mockMvc.perform(post("/owners")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createOwnerDto)))
                .andExpect(status().isOk());

        Owner foundOwner = ownerRepository.findById(savedOwner.getId())
                .orElseThrow(() -> new EntityNotFoundException("Owner", savedOwner.getId()));

        assertNotNull(foundOwner);
        assertEquals("Hamza", foundOwner.getName());
    }

    @Test
    void testGetAllOwnerIntegration() throws Exception{
        List<Owner> owners = ownerRepository.findAll().stream()
                .toList();
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Hamza"));

    }


}
