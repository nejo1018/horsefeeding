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

import java.time.LocalTime;
import java.util.List;
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

    public List<HorseDto> findUnfedHorsesForToday(){
        List<Integer> fedHorseIds = feedinglogRepository.findFedHorseIdsForToday();


        List<Horse> allHorses = horseRepository.findAll();


        List<Horse> unfedHorses = allHorses.stream()
                .filter(horse -> !fedHorseIds.contains(horse.getId()))
                .collect(Collectors.toList());


        return unfedHorses.stream()
                .map(horseMapper::toDto)
                .collect(Collectors.toList());
    }


    public FeedinglogDto feedHorse(FeedinglogDto feedinglogDto) {

        validateFeedingTime(feedinglogDto.getFood_time());


        Feedinglog feedinglog = new Feedinglog();
        feedinglog.setHorse_id(feedinglogDto.getHorse_id());
        feedinglog.setFeedingstation_id(feedinglogDto.getFeedingstation_id());
        feedinglog.setFood_date(feedinglogDto.getFood_date());
        feedinglog.setFood_time(feedinglogDto.getFood_time());
        feedinglog.setMealplan_id(feedinglogDto.getMealplan_id());


        Feedinglog savedFeedinglog = feedinglogRepository.save(feedinglog);


        FeedinglogDto savedDto = new FeedinglogDto();
        savedDto.setId(savedFeedinglog.getId());
        savedDto.setHorse_id(savedFeedinglog.getHorse_id());
        savedDto.setFeedingstation_id(savedFeedinglog.getFeedingstation_id());
        savedDto.setFood_date(savedFeedinglog.getFood_date());
        savedDto.setFood_time(savedFeedinglog.getFood_time());
        savedDto.setMealplan_id(savedFeedinglog.getMealplan_id());

        return savedDto;
    }



    private void validateFeedingTime(String foodTime) {

        LocalTime feedingTime = LocalTime.parse(foodTime);

        boolean isValid = (feedingTime.isAfter(LocalTime.of(7, 59)) && feedingTime.isBefore(LocalTime.of(11, 1))) ||
                (feedingTime.isAfter(LocalTime.of(12, 59)) && feedingTime.isBefore(LocalTime.of(16, 1))) ||
                (feedingTime.isAfter(LocalTime.of(19, 59)) && feedingTime.isBefore(LocalTime.of(23, 1)));

        if (!isValid) {
            throw new InvalidFeedingTimeException("Füttern ist nur in den Zeitfenstern 08-11, 13-16 und 20-23 Uhr erlaubt.");
        }
    }


}
