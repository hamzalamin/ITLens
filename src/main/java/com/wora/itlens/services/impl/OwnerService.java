package com.wora.itlens.services.impl;

import com.wora.itlens.exceptions.EntityNotFoundException;
import com.wora.itlens.mappers.OwnerMapper;
import com.wora.itlens.models.dtos.owners.CreateOwnerDto;
import com.wora.itlens.models.dtos.owners.OwnerDto;
import com.wora.itlens.models.dtos.owners.UpdateOwnerDto;
import com.wora.itlens.models.entites.Owner;
import com.wora.itlens.repositories.OwnerRepository;
import com.wora.itlens.services.interfaces.IOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OwnerService implements IOwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public OwnerDto save(CreateOwnerDto createOwnerDto) {
        Owner owner = ownerMapper.toEntity(createOwnerDto);
        Owner savedOwner = ownerRepository.save(owner);
        return ownerMapper.toDto(savedOwner);
    }

    @Override
    public OwnerDto findById(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Owner", id));
        return ownerMapper.toDto(owner);
    }

    @Override
    public OwnerDto update(UpdateOwnerDto updateOwnerDto, Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Owner", id));

        owner.setName(updateOwnerDto.name());
        Owner updatedOwner = ownerRepository.save(owner);
        return ownerMapper.toDto(updatedOwner);
    }

    @Override
    public List<OwnerDto> findAll() {
        return ownerRepository.findAll().stream()
                .map(ownerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Void delete(Long id) {
        return null;
    }
}
