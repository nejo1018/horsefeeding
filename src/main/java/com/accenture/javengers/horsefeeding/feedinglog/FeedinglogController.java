package com.accenture.javengers.horsefeeding.feedinglog;
import com.accenture.javengers.horsefeeding.Service.FeedingMonitoringService;
import com.accenture.javengers.horsefeeding.horse.HorseDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("feed-horses")
public class FeedinglogController {

    @Autowired
    private FeedinglogService feedinglogService;

    @Autowired
    private FeedinglogMapper feedinglogMapper;

    @Autowired
    private FeedingMonitoringService feedingMonitoringService;

    @GetMapping("/feedinglog")
    public ResponseEntity<List<FeedinglogDto>> readFeedinglog() {
        List<FeedinglogDto> feedinglogDtos = feedinglogService.readFeedinglog();
        return ResponseEntity.ok(feedinglogDtos);
    }

    @GetMapping("/unfed-horses")
    public ResponseEntity<List<HorseDto>> getUnfedHorsesForToday() {
        List<HorseDto> unfedHorses = feedinglogService.findUnfedHorsesForToday();
        return ResponseEntity.ok(unfedHorses);
    }


    @PostMapping("/feed")
    public ResponseEntity<FeedinglogDto> createFeedinglog(@RequestBody FeedinglogDto feedinglogDto) {
        try {
            FeedinglogDto createdFeedinglog = feedinglogService.createFeedinglog(feedinglogDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedinglog);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/eligible-horses")
    public ResponseEntity<List<HorseDto>> getEligibleHorses(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time) {
        // Standardzeit verwenden, wenn keine Zeit angegeben ist
        LocalTime timeToCheck = (time != null) ? time : LocalTime.now();

        // Service aufrufen und die berechtigten Pferde abrufen
        List<HorseDto> eligibleHorses = feedinglogService.getEligibleHorses(Optional.of(timeToCheck));
        return ResponseEntity.ok(eligibleHorses);
    }

    @GetMapping("/not-fed")
    public ResponseEntity<List<HorseDto>> getHorsesNotFedForMoreThanXHours(
            @RequestParam int hours,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time) {
        LocalTime currentTime = (time != null) ? time : LocalTime.now();

        // Service aufrufen
        List<HorseDto> horsesNotFed = feedingMonitoringService.getHorsesNotFedForMoreThanXHours(hours, currentTime);
        return ResponseEntity.ok(horsesNotFed);
    }

}
