package com.wora.itlens.mappers.api;

public interface GenericMapper<Entity, Dto> {
    Entity toEntity(Dto dto);
    Dto toDto(Entity entity);
}
