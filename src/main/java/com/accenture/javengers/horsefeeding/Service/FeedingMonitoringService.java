package com.accenture.javengers.horsefeeding.Service;
import com.accenture.javengers.horsefeeding.feedinglog.FeedinglogRepository;
import com.accenture.javengers.horsefeeding.horse.Horse;
import com.accenture.javengers.horsefeeding.horse.HorseDto;
import com.accenture.javengers.horsefeeding.horse.HorseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedingMonitoringService {

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private FeedinglogRepository feedinglogRepository;

    public List<HorseDto> getHorsesNotFedForMoreThanXHours(int hours, LocalTime currentTime) {
        // Berechnete Schwellezeit
        LocalDateTime thresholdTime = LocalDateTime.now().minusHours(hours);

        // Alle Pferde abrufen
        List<Horse> allHorses = horseRepository.findAll();

        // Filter: Pferde, die nicht gefüttert wurden, obwohl sie berechtigt sind
        List<Horse> horsesNotFed = allHorses.stream()
                .filter(horse -> isHorseNotFed(horse, thresholdTime, currentTime))
                .collect(Collectors.toList());

        // Mapping zu DTOs
        return horsesNotFed.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private boolean isHorseNotFed(Horse horse, LocalDateTime thresholdTime, LocalTime currentTime) {
        // Prüfen, ob das Pferd in den Feedinglogs innerhalb des Zeitfensters erfasst ist
        boolean wasFed = feedinglogRepository.existsByHorseIdAndFoodDateAfter(horse.getId(), thresholdTime);

        // Prüfen, ob das Pferd berechtigt ist und nicht gefüttert wurde
        return !wasFed && isTimeValidForFeeding(currentTime);
    }

    private boolean isTimeValidForFeeding(LocalTime timeToCheck) {
        // Prüfen, ob die Zeit in einem der gültigen Zeitfenster liegt
        return (timeToCheck.isAfter(LocalTime.of(8, 0)) && timeToCheck.isBefore(LocalTime.of(11, 0)))
                || (timeToCheck.isAfter(LocalTime.of(13, 0)) && timeToCheck.isBefore(LocalTime.of(16, 0)))
                || (timeToCheck.isAfter(LocalTime.of(20, 0)) && timeToCheck.isBefore(LocalTime.of(23, 0)));
    }

    private HorseDto mapToDto(Horse horse) {
        HorseDto dto = new HorseDto();
        dto.setId(horse.getId());
        dto.setGuid(horse.getGuid());
        dto.setHorseName(horse.getHorseName());
        dto.setHorseNickname(horse.getHorseNickname());
        dto.setBreed(horse.getBreed());
        dto.setOwner_id(horse.getOwner_id());
        dto.setStable_id(horse.getStable_id());
        dto.setMealplan_id(horse.getMealplan_id());
        return dto;
    }
}
