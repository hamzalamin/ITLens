package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.owners.CreateOwnerDto;
import com.wora.itlens.models.dtos.owners.OwnerDto;
import com.wora.itlens.services.impl.OwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerDto> createOwner(@RequestBody @Valid CreateOwnerDto createOwnerDto){
        return new ResponseEntity<>(ownerService.save(createOwnerDto), HttpStatus.OK);
    }

}
