package com.accenture.javengers.horsefeeding.feedinglog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


@Repository
public interface FeedinglogRepository extends JpaRepository<Feedinglog, Integer> {

    @Query("SELECT f.horse_id FROM Feedinglog f WHERE DATE(f.food_date) = CURRENT_DATE")
    List<Integer> findFedHorseIdsForToday();

}
