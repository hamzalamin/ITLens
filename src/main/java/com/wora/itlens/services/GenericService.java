package com.wora.itlens.services;

public interface GenericService<CREATE_DTO, UPDATE_DTO, DTO, ID>{
    DTO save(CREATE_DTO dto);
    DTO findById(ID id);
    DTO update(UPDATE_DTO dto, ID id);
    DTO findAll();
    Void delete(ID id);
}
