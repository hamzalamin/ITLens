package com.wora.itlens.owner.repository;

import com.wora.itlens.models.dtos.owners.CreateOwnerDto;
import com.wora.itlens.models.dtos.owners.OwnerDto;
import com.wora.itlens.models.entites.Owner;
import com.wora.itlens.repositories.OwnerRepository;
import com.wora.itlens.services.interfaces.IOwnerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class OwnerRepositoryTest {

    @Autowired
    private  OwnerRepository ownerRepository;

    @Autowired
    private IOwnerService ownerService;

    @Test
    void testSaveOwner(){
        CreateOwnerDto createOwnerDto = new CreateOwnerDto("Hamza");
        OwnerDto savedOwner = ownerService.save(createOwnerDto);

        Owner foundOwner = ownerRepository.findById(savedOwner.id()).orElse(null);

        assertNotNull(foundOwner);
        assertEquals("Hamza", foundOwner.getName());
    }

    @Test
    void testSaveNullName(){
        CreateOwnerDto createOwnerDto = new CreateOwnerDto(null);
        OwnerDto savedOwner = ownerService.save(createOwnerDto);
        Owner foundOwner = ownerRepository.findById(savedOwner.id()).orElse(null);

        assertEquals(null, foundOwner.getName());
    }

}
