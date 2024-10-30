package com.wora.itlens.mappers;


import com.wora.itlens.models.dtos.owners.CreateOwnerDto;
import com.wora.itlens.models.dtos.owners.UpdateOwnerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper<OwnerDto, Owner> {
    Owner toEntity(CreateOwnerDto dto);
    Owner toEntity(UpdateOwnerDto dto);
    OwnerDto toDto(Owner owner);
}
