package com.accenture.javengers.horsefeeding.feedingstation;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface FeedingstationMapper {

    @Mapping(source = "stable.stableName", target = "stable_name")
    @Mapping(source = "id", target = "feedingstation_id")
    @Mapping(source = "feedingRange", target = "feeding_range")

    FeedingstationDto toDto(Feedingstation feedingstation);
    List<FeedingstationDto> toDtos(List<Feedingstation> feedingstation);
}

