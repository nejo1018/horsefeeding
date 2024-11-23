package com.accenture.javengers.horsefeeding.food;

public class FoodDto {

    private Integer id;
    private String foodName;
    private String foodAmount;

    public Integer getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodAmount() {
        return foodAmount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodAmount(String foodAmount) {
        this.foodAmount = foodAmount;
    }
}
