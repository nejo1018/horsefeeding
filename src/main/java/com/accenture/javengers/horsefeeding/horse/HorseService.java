package com.accenture.javengers.horsefeeding.horse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorseService {

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private HorseMapper horseMapper;


    public List<HorseDto> readHorse() {
        List<Horse> all = horseRepository.findAll();
        return horseMapper.toDtos(all);
    }

    public HorseDto createHorse(HorseDto horseDto) {
        // Mapping von DTO zu Entity
        Horse horse = new Horse();
        horse.setGuid(horseDto.getGuid());
        horse.setHorseName(horseDto.getHorseName());
        horse.setHorseNickname(horseDto.getHorseNickname());
        horse.setBreed(horseDto.getBreed());
        horse.setOwner_id(horseDto.getOwner_id());
        horse.setStable_id(horseDto.getStable_id());
        horse.setMealplan_id(horseDto.getMealplan_id());

        // Speichern des neuen Pferdes in der Datenbank
        Horse savedHorse = horseRepository.save(horse);

        // Mapping von Entity zu DTO
        HorseDto savedHorseDto = new HorseDto();
        savedHorseDto.setId(savedHorse.getId());
        savedHorseDto.setGuid(savedHorse.getGuid());
        savedHorseDto.setHorseName(savedHorse.getHorseName());
        savedHorseDto.setHorseNickname(savedHorse.getHorseNickname());
        savedHorseDto.setBreed(savedHorse.getBreed());
        savedHorseDto.setOwner_id(savedHorse.getOwner_id());
        savedHorseDto.setStable_id(savedHorse.getStable_id());
        savedHorseDto.setMealplan_id(savedHorse.getMealplan_id());

        return savedHorseDto;
    }


}
