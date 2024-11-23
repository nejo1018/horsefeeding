package com.accenture.javengers.horsefeeding.mealplan;

public class MealplanDto {

    private Integer mealplan_id;
    private String food1;
    private String food2;
    private String food3;
    private String food4;

    public Integer getMealplan_id() {
        return mealplan_id;
    }

    public String getFood1() {
        return food1;
    }

    public String getFood2() {
        return food2;
    }

    public String getFood3() {
        return food3;
    }

    public String getFood4() {
        return food4;
    }

    public void setMealplan_id(Integer mealplan_id) {
        this.mealplan_id = mealplan_id;
    }

    public void setFood1(String food1) {
        this.food1 = food1;
    }

    public void setFood2(String food2) {
        this.food2 = food2;
    }

    public void setFood3(String food3) {
        this.food3 = food3;
    }

    public void setFood4(String food4) {
        this.food4 = food4;
    }
}
