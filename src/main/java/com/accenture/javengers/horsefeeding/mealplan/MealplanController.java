package com.accenture.javengers.horsefeeding.mealplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealplanController {

    @Autowired
    private MealplanService mealplanService;

    @Autowired
    private MealplanMapper mealplanMapper;

    @GetMapping("/mealplan")
    public ResponseEntity<List<MealplanDto>> readHorse() {
        List<MealplanDto> mealplanDtos = mealplanService.readMealplan();
        return ResponseEntity.ok(mealplanDtos);
    }
}
