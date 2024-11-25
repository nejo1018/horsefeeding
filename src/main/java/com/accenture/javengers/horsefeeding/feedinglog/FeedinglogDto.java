package com.accenture.javengers.horsefeeding.feedinglog;

import java.time.LocalDateTime;

public class FeedinglogDto {
    private Integer id;
    private Integer horseId;

    private Integer feedingStationId;
    private LocalDateTime foodDate;
    private String foodTime;
    private Integer mealplanId;
    private LocalDateTime foodDateTime;
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
