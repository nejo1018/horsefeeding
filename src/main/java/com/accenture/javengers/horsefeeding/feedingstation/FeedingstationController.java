package com.accenture.javengers.horsefeeding.feedingstation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class FeedingstationController {

    @Autowired
    private FeedingstationService feedingstationService;

    @Autowired
    private FeedingstationMapper feedingstationMapper;

    @GetMapping("/feedingstations")
    public ResponseEntity<List<FeedingstationDto>> readFeedingstation() {
        List<FeedingstationDto> feedingstationDtos = feedingstationService.readFeedingstation();
        return ResponseEntity.ok(feedingstationDtos);
    }
}
