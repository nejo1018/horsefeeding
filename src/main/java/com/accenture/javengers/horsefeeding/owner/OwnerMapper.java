package com.accenture.javengers.horsefeeding.owner;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface OwnerMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "city", target = "city")
    OwnerDto toDto(Owner owner);
    List<OwnerDto> toDtos(List<Owner> owner);
}
