package com.wora.itlens.mappers;


import com.wora.itlens.mappers.api.GenericMapper;
import com.wora.itlens.models.dtos.owners.CreateOwnerDto;
import com.wora.itlens.models.dtos.owners.OwnerDto;
import com.wora.itlens.models.dtos.owners.UpdateOwnerDto;
import com.wora.itlens.models.entites.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper extends GenericMapper<OwnerDto, Owner> {
    Owner toEntity(CreateOwnerDto dto);
    Owner toEntity(UpdateOwnerDto dto);
    Owner toEntity(OwnerDto dto);
    OwnerDto toDto(Owner owner);
}
