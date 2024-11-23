package com.accenture.javengers.horsefeeding.feedinglog;
import com.accenture.javengers.horsefeeding.horse.HorseDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("feed-horses")
public class FeedinglogController {

    @Autowired
    private FeedinglogService feedinglogService;

    @Autowired
    private FeedinglogMapper feedinglogMapper;

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

    /*
    @PostMapping
    public ResponseEntity<FeedinglogDto> feedHorse(@RequestBody FeedinglogDto feedinglogDto) {
        try {
            FeedinglogDto createdFeedinglog = feedinglogService.feedHorse(feedinglogDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedinglog);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
     */

    @PostMapping
    public ResponseEntity<FeedinglogDto> feedHorse(@RequestBody FeedinglogDto feedinglogDto) {
        try {
            // Service übernimmt die Berechnung der feedingstation_id
            FeedinglogDto createdFeedinglog = feedinglogService.feedHorse(feedinglogDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedinglog);
        } catch (IllegalArgumentException e) {
            // Gibt einen BAD_REQUEST zurück, wenn die Exception geworfen wird
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
