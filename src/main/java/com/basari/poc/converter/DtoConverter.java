package com.basari.poc.converter;

public interface DtoConverter<ENTITY,DTO> {
    DTO convertToDto(ENTITY entity);
}
