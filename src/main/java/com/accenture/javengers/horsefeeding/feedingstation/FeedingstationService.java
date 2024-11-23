package com.accenture.javengers.horsefeeding.feedingstation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedingstationService {

    @Autowired
    private FeedingstationRepository feedingstationRepository;

    @Autowired
    private FeedingstationMapper feedingstationMapper;

    public List<FeedingstationDto> readFeedingstation() {

        List<Feedingstation> all = feedingstationRepository.findAll();
        return feedingstationMapper.toDtos(all);
    }
}
