package com.accenture.javengers.horsefeeding.feedinglog;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;


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
   // @Column(name = "feedingstation_id", nullable = false)
    private Integer feedingStationId;

    @Column(name = "food_date")
    private LocalDateTime foodDate;

    @Column(name = "food_time")
    private String foodTime;

    @Column(name = "food_datetime")
    private LocalDateTime foodDateTime;

    @Column(name = "mealplan_id")
    private Integer mealplanId;

    @Column(name = "finishedmeal")
    private Boolean finishedmeal;

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

    public LocalDateTime getFoodDateTime() { return foodDateTime; }

    public void setFoodDateTime(LocalDateTime foodDateTime) { this.foodDateTime = foodDateTime; }

    public Boolean getFinishedmeal() { return finishedmeal; }

    public void setFinishedmeal(Boolean finishedmeal) { this.finishedmeal = finishedmeal; }
}
