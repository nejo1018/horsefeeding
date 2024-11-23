package com.accenture.javengers.horsefeeding.stable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StableMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "stableName", target = "stableName")
    StableDto toDto(Stable stable);

    List<StableDto> toDtos(List<Stable> stable);
}
