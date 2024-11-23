package com.accenture.javengers.horsefeeding.mealplan;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface MealplanMapper {

    @Mapping(source = "id", target = "mealplan_id")
    @Mapping(source = "food1.foodName", target = "food1")
    @Mapping(source = "food2.foodName", target = "food2")
    @Mapping(source = "food3.foodName", target = "food3")
    @Mapping(source = "food4.foodName", target = "food4")

    MealplanDto toDto(Mealplan mealplan);
    List<MealplanDto> toDtos(List<Mealplan> mealplan);

}
