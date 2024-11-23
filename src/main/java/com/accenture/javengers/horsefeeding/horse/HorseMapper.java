package com.accenture.javengers.horsefeeding.horse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HorseMapper {

    @Mapping(source = "horseName", target = "horseName")
    HorseDto toDto(Horse horse);

    List<HorseDto> toDtos(List<Horse> horse);
}