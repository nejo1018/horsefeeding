package com.accenture.javengers.horsefeeding.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodMapper foodMapper;

    public List<FoodDto> readFood(){

        List<Food> all = foodRepository.findAll();
        return foodMapper.toDtos(all);
    }
}
