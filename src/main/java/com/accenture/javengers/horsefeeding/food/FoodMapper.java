package com.accenture.javengers.horsefeeding.food;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    @Mapping(source = "foodName", target = "foodName")
    @Mapping(source = "foodAmount", target = "foodAmount")
    FoodDto toDto(Food food);

    List<FoodDto> toDtos(List<Food> food);
}
