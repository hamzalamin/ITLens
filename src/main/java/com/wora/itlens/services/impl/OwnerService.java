package com.wora.itlens.services.impl;

import com.wora.itlens.models.dtos.owners.CreateOwnerDto;
import com.wora.itlens.models.dtos.owners.OwnerDto;
import com.wora.itlens.models.dtos.owners.UpdateOwnerDto;
import com.wora.itlens.repositories.OwnerRepository;
import com.wora.itlens.services.interfaces.IOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService implements IOwnerService {
    private final OwnerRepository ownerRepository;

    @Override
    public OwnerDto save(CreateOwnerDto createOwnerDto) {
        return null;
    }

    @Override
    public OwnerDto findById(Long aLong) {
        return null;
    }

    @Override
    public UpdateOwnerDto update(UpdateOwnerDto updateOwnerDto, Long aLong) {
        return null;
    }

    @Override
    public OwnerDto findAll() {
        return null;
    }

    @Override
    public Void delete(Long aLong) {
        return null;
    }
}
