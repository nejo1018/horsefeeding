package com.accenture.javengers.horsefeeding.feedinglog;

import com.accenture.javengers.horsefeeding.feedinglog.exceptions.InvalidFeedingTimeException;
import com.accenture.javengers.horsefeeding.feedingstation.Feedingstation;
import com.accenture.javengers.horsefeeding.feedingstation.FeedingstationRepository;
import com.accenture.javengers.horsefeeding.horse.Horse;
import com.accenture.javengers.horsefeeding.horse.HorseDto;
import com.accenture.javengers.horsefeeding.horse.HorseMapper;
import com.accenture.javengers.horsefeeding.horse.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedinglogService {

    @Autowired
    private FeedinglogRepository feedinglogRepository;

    @Autowired
    private FeedinglogMapper feedinglogMapper;

    @Autowired
    private HorseRepository horseRepository;

    @Autowired
    private HorseMapper horseMapper;

    @Autowired
    private FeedingstationRepository feedingstationRepository;


    public List<FeedinglogDto> readFeedinglog() {
        List<Feedinglog> all = feedinglogRepository.findAll();
        return feedinglogMapper.toDtos(all);
    }

    public List<HorseDto> findUnfedHorsesForToday() {
        List<Integer> fedHorseIds = feedinglogRepository.findFedHorseIdsForToday();

        // Hole alle Pferde aus der Datenbank
        List<Horse> allHorses = horseRepository.findAll();

        // Filtere die Pferde, deren IDs NICHT in der Liste der gefütterten IDs sind
        List<Horse> unfedHorses = allHorses.stream()
                .filter(horse -> !fedHorseIds.contains(horse.getId()))
                .collect(Collectors.toList());

        // Mappe die ungefütterten Pferde auf HorseDto und gib sie zurück
        return unfedHorses.stream()
                .map(horseMapper::toDto)
                .collect(Collectors.toList());
    }


    /*
    public FeedinglogDto feedHorse(FeedinglogDto feedinglogDto) {
        // Validierung der Fütterungszeit
        validateFeedingTime(feedinglogDto.getFood_time());

        // Mapping von DTO zu Entity
        Feedinglog feedinglog = new Feedinglog();
        feedinglog.setHorse_id(feedinglogDto.getHorse_id());
        feedinglog.setFeedingstation_id(feedinglogDto.getFeedingstation_id());
        feedinglog.setFood_date(feedinglogDto.getFood_date());
        feedinglog.setFood_time(feedinglogDto.getFood_time());
        feedinglog.setMealplan_id(feedinglogDto.getMealplan_id());

        // Speichere den neuen Fütterungseintrag
        Feedinglog savedFeedinglog = feedinglogRepository.save(feedinglog);

        // Mapping von Entity zurück zu DTO
        FeedinglogDto savedDto = new FeedinglogDto();
        savedDto.setId(savedFeedinglog.getId());
        savedDto.setHorse_id(savedFeedinglog.getHorse_id());
        savedDto.setFeedingstation_id(savedFeedinglog.getFeedingstation_id());
        savedDto.setFood_date(savedFeedinglog.getFood_date());
        savedDto.setFood_time(savedFeedinglog.getFood_time());
        savedDto.setMealplan_id(savedFeedinglog.getMealplan_id());

        return savedDto;
    }

     */

    public FeedinglogDto feedHorse(FeedinglogDto feedinglogDto) {
        // Validierung der Fütterungszeit
        validateFeedingTime(feedinglogDto.getFoodDateTime().toLocalTime());

        // Mapping von DTO zu Entity
        Feedinglog feedinglog = feedinglogMapper.toEntity(feedinglogDto);

        // Speichere den neuen Fütterungseintrag
        Feedinglog savedFeedinglog = feedinglogRepository.save(feedinglog);

        // Mapping von Entity zurück zu DTO
        return feedinglogMapper.toDto(savedFeedinglog);
    }

    /**
     * Validiert, ob die angegebene Fütterungszeit in den erlaubten Zeitfenstern liegt.
     */
    private void validateFeedingTime(LocalTime feedingTime) {
        if (feedingTime == null) {
            throw new IllegalArgumentException("Feeding time cannot be null");
        }

        boolean isValid = (feedingTime.isAfter(LocalTime.of(8, 0)) && feedingTime.isBefore(LocalTime.of(11, 0)))
                || (feedingTime.isAfter(LocalTime.of(13, 0)) && feedingTime.isBefore(LocalTime.of(16, 0)))
                || (feedingTime.isAfter(LocalTime.of(20, 0)) && feedingTime.isBefore(LocalTime.of(23, 0)));

        if (!isValid) {
            throw new IllegalArgumentException("Feeding time is outside allowed ranges.");
        }
    }



    public List<HorseDto> getEligibleHorses(Optional<LocalTime> requestedTime) {
        LocalTime timeToCheck = requestedTime.orElse(LocalTime.now());

        // Alle Pferde abrufen
        List<Horse> allHorses = horseRepository.findAll();

        // Filtern der Pferde, die aktuell gefüttert werden können
        List<Horse> eligibleHorses = allHorses.stream()
                .filter(horse -> isTimeValidForFeeding(timeToCheck))
                .collect(Collectors.toList());

        // Umwandeln in DTOs
        return eligibleHorses.stream()
                .map(horseMapper::toDto)
                .collect(Collectors.toList());
    }

    private boolean isTimeValidForFeeding(LocalTime timeToCheck) {
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


    public FeedinglogDto createFeedinglog(FeedinglogDto feedinglogDto) {
        validateFeedingTime(feedinglogDto.getFoodDateTime().toLocalTime());


        if (feedinglogDto.getFeedingStationId() == null) {
            throw new IllegalArgumentException("FeedingStationId cannot be null.");
        }

        // Mapping von DTO zu Entity
        Feedinglog feedinglog = feedinglogMapper.toEntity(feedinglogDto);

        // Speichere den neuen Fütterungseintrag in der Datenbank
        Feedinglog savedFeedinglog = feedinglogRepository.save(feedinglog);

        // Mapping von Entity zurück zu DTO
        return feedinglogMapper.toDto(savedFeedinglog);
    }








}
