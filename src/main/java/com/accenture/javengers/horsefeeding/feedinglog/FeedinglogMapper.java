package com.accenture.javengers.horsefeeding.feedinglog;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FeedinglogMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "horse_id", target = "horse_id")
    @Mapping(source = "feedingstation_id", target = "feedingstation_id")
    @Mapping(source = "food_date", target = "food_date")
    @Mapping(source = "mealplan_id", target = "mealplan_id")
    FeedinglogDto toDto(Feedinglog feedinglog);

    List<FeedinglogDto> toDtos(List<Feedinglog> feedinglog);
}
