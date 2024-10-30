package com.wora.itlens.services;

public interface IGenericService <Entity>{
    Entity save(Entity entity);
    Entity findById(Long id);
    Entity update(Entity entity, Long id);
    Entity findAll();
    Void delete(Long id);
}
