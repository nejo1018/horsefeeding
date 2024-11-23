package com.accenture.javengers.horsefeeding.mealplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class MealplanService {

    @Autowired
    private MealplanRepository mealplanRepository;

    @Autowired
    private MealplanMapper mealplanMapper;

    public List<MealplanDto> readMealplan(){
        List<Mealplan> all = mealplanRepository.findAll();
        return mealplanMapper.toDtos(all);
    }
}
