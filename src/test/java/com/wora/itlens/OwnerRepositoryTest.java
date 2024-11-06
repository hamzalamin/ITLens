package com.wora.itlens;

import com.wora.itlens.models.entites.Owner;
import com.wora.itlens.repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
public class OwnerRepositoryTest {

    @Autowired
    private  OwnerRepository ownerRepository;

    @Test
    void testSaveOwner(){
        Owner owner = new Owner(null, "Hamza", List.of());
        ownerRepository.save(owner);

        Owner foundOwner = ownerRepository.findById(owner.getId()).orElse(null);

        assertNotNull(foundOwner);
        assertEquals("Hamza", foundOwner.getName());
    }
}
