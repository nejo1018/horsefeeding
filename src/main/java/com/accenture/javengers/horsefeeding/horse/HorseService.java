package com.accenture.javengers.horsefeeding.horse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

        // GUID wird hier automatisch generiert
        horse.setGuid(UUID.randomUUID().toString());

        horse.setHorseName(horseDto.getHorseName());
        horse.setHorseNickname(horseDto.getHorseNickname());
        horse.setBreed(horseDto.getBreed());
        horse.setOwner_id(horseDto.getOwner_id());
        horse.setStable_id(horseDto.getStable_id());
        horse.setMealplan_id(horseDto.getMealplan_id());

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

    public void deleteHorseById(Integer id) {
        if (!horseRepository.existsById(id)) {
            throw new IllegalArgumentException("Pferd mit ID " + id + " existiert nicht.");
        }
        horseRepository.deleteById(id);
    }

    public HorseDto updateHorse(Integer id, HorseDto horseDto) {
        // Überprüfe, ob das Pferd existiert
        Horse horse = horseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pferd mit ID " + id + " existiert nicht."));

        // Aktualisiere die Felder des Pferdes
        horse.setHorseName(horseDto.getHorseName());
        horse.setHorseNickname(horseDto.getHorseNickname());
        horse.setBreed(horseDto.getBreed());
        horse.setOwner_id(horseDto.getOwner_id());
        horse.setStable_id(horseDto.getStable_id());
        horse.setMealplan_id(horseDto.getMealplan_id());

        // Speichere die Änderungen in der Datenbank
        Horse updatedHorse = horseRepository.save(horse);

        // Mapping von Entity zu DTO
        HorseDto updatedHorseDto = new HorseDto();
        updatedHorseDto.setId(updatedHorse.getId());
        updatedHorseDto.setGuid(updatedHorse.getGuid());
        updatedHorseDto.setHorseName(updatedHorse.getHorseName());
        updatedHorseDto.setHorseNickname(updatedHorse.getHorseNickname());
        updatedHorseDto.setBreed(updatedHorse.getBreed());
        updatedHorseDto.setOwner_id(updatedHorse.getOwner_id());
        updatedHorseDto.setStable_id(updatedHorse.getStable_id());
        updatedHorseDto.setMealplan_id(updatedHorse.getMealplan_id());

        return updatedHorseDto;
    }


}
