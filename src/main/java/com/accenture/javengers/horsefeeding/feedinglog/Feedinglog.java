package com.accenture.javengers.horsefeeding.feedinglog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

/*
@Entity
@Table(name = "feedinglog")
public class Feedinglog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedinglog_id")
    private Integer id;

    @Column(name = "horse_id")
    private Integer horse_id;

    @Column(name = "feedingstation_id")
    private Integer feedingstation_id;

    @Column(name = "food_date")
    private String food_date;

    @Column(name = "food_time")
    private String food_time;

    @Column(name = "mealplan_id")
    private Integer mealplan_id;

    public Integer getId() {
        return id;
    }

    public Integer getHorse_id() {
        return horse_id;
    }

    public Integer getFeedingstation_id() {
        return feedingstation_id;
    }

    public String getFood_date() {
        return food_date;
    }

    public String getFood_time() {
        return food_time;
    }

    public Integer getMealplan_id() {
        return mealplan_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHorse_id(Integer horse_id) {
        this.horse_id = horse_id;
    }

    public void setFeedingstation_id(Integer feedingstation_id) {
        this.feedingstation_id = feedingstation_id;
    }

    public void setFood_time(String food_time) {
        this.food_time = food_time;
    }

    public void setMealplan_id(Integer mealplan_id) {
        this.mealplan_id = mealplan_id;
    }

    public void setFood_date(String food_date) {
        this.food_date = food_date;
    }
}
*/

@Entity
@Table(name = "feedinglog")
public class Feedinglog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedinglog_id")
    private Integer id;

    @Column(name = "horse_id")
    private Integer horseId;

    @Column(name = "feedingstation_id")
    private Integer feedingStationId;

    @Column(name = "food_date")
    private LocalDateTime foodDate;

    @Column(name = "food_time")
    private String foodTime;

    @Column(name = "mealplan_id")
    private Integer mealplanId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHorseId() {
        return horseId;
    }

    public void setHorseId(Integer horseId) {
        this.horseId = horseId;
    }

    public Integer getFeedingStationId() {
        return feedingStationId;
    }

    public void setFeedingStationId(Integer feedingStationId) {
        this.feedingStationId = feedingStationId;
    }

    public LocalDateTime getFoodDate() {
        return foodDate;
    }

    public void setFoodDate(LocalDateTime foodDate) {
        this.foodDate = foodDate;
    }

    public String getFoodTime() {
        return foodTime;
    }

    public void setFoodTime(String foodTime) {
        this.foodTime = foodTime;
    }

    public Integer getMealplanId() {
        return mealplanId;
    }

    public void setMealplanId(Integer mealplanId) {
        this.mealplanId = mealplanId;
    }
}
