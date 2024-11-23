package com.accenture.javengers.horsefeeding.mealplan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealplanRepository extends JpaRepository<Mealplan, Integer> {

}
