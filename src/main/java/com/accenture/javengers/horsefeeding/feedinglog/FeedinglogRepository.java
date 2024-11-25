package com.accenture.javengers.horsefeeding.feedinglog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface FeedinglogRepository extends JpaRepository<Feedinglog, Integer> {

    /*
    @Query("SELECT f.horse_id FROM Feedinglog f WHERE DATE(f.food_date) = CURRENT_DATE")

    List<Integer> findFedHorseIdsForToday();
    */


    //boolean existsByHorseIdAndFeedingTimeAfter(Integer horseid, LocalDateTime feedingTime);
    boolean existsByHorseIdAndFoodDateAfter(Integer horseId, LocalDateTime foodDate);


    //@Query("SELECT f.horse_id FROM feedinglog f WHERE DATE(f.food_Date) = CURRENT_DATE")


   // @Query("SELECT f.horseId FROM Feedinglog f WHERE DATE(f.foodDate) = CURRENT_DATE")
   @Query("SELECT f.horseId FROM Feedinglog f WHERE DATE(f.foodDateTime) = CURRENT_DATE")

    List<Integer> findFedHorseIdsForToday();


}
