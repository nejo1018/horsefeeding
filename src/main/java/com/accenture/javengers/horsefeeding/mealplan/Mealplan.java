package com.accenture.javengers.horsefeeding.mealplan;
import com.accenture.javengers.horsefeeding.food.Food;
import jakarta.persistence.*;

@Entity
@Table(name = "mealplan")

public class Mealplan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealplan_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "food_id_1", nullable = false)
    private Food food1;

    @ManyToOne
    @JoinColumn(name = "food_id_2", nullable = false)
    private Food food2;

    @ManyToOne
    @JoinColumn(name = "food_id_3", nullable = false)
    private Food food3;

    @ManyToOne
    @JoinColumn(name = "food_id_4", nullable = false)
    private Food food4;

    public Integer getId() {
        return id;
    }

    public Food getFood1() {
        return food1;
    }

    public Food getFood2() {
        return food2;
    }

    public Food getFood3() {
        return food3;
    }

    public Food getFood4() {
        return food4;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFood1(Food food1) {
        this.food1 = food1;
    }

    public void setFood2(Food food2) {
        this.food2 = food2;
    }

    public void setFood3(Food food3) {
        this.food3 = food3;
    }

    public void setFood4(Food food4) {
        this.food4 = food4;
    }


}

