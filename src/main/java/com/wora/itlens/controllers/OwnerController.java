package com.wora.itlens.controllers;

import com.wora.itlens.models.dtos.owners.CreateOwnerDto;
import com.wora.itlens.models.dtos.owners.OwnerDto;
import com.wora.itlens.models.dtos.owners.UpdateOwnerDto;
import com.wora.itlens.services.interfaces.IOwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final IOwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerDto> createOwner(@RequestBody @Valid CreateOwnerDto createOwnerDto){
        return new ResponseEntity<>(ownerService.save(createOwnerDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OwnerDto>> findAllOwners(){
        List<OwnerDto> ownerDtoList = ownerService.findAll();
        return new ResponseEntity<>(ownerDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto> findById(@PathVariable("id") Long id){
        OwnerDto owner = ownerService.findById(id);
        return new ResponseEntity<>(owner, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDto> updateOwner(
            @PathVariable("id")
            @RequestBody @Valid Long id, UpdateOwnerDto updateOwnerDto){
        return new ResponseEntity<>(ownerService.update(updateOwnerDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id){
            ownerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
