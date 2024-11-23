package com.accenture.javengers.horsefeeding.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodMapper foodMapper;

    @GetMapping("/food")
    public ResponseEntity<List<FoodDto>> readFood() {
        List<FoodDto> foodDtos = foodService.readFood();
        return ResponseEntity.ok(foodDtos);
    }
}
