package com.accenture.javengers.horsefeeding.food;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Integer id;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_amount")
    private Integer foodAmount;

    public Integer getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public Integer getFoodAmount() {
        return foodAmount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodAmount(Integer foodAmount) {
        this.foodAmount = foodAmount;
    }



}
