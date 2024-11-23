package com.accenture.javengers.horsefeeding.horse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name= "horse")
public class Horse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String guid;

    @Column(name = "horseName")
    private String horseName;

    @Column(name = "horseNickname")
    private String horseNickname;

    @Column(name = "breed")
    private String breed;

    @Column(name = "owner_id")
    private Integer owner_id;

    @Column(name = "stable_id")
    private Integer stable_id;

    @Column(name = "mealplan_id")
    private Integer mealplan_id;

    public Integer getId() {
        return id;
    }

    public String getGuid() {
        return guid;
    }

    public String getHorseName() {
        return horseName;
    }

    public String getHorseNickname() {
        return horseNickname;
    }

    public String getBreed() {
        return breed;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public Integer getStable_id() {
        return stable_id;
    }

    public Integer getMealplan_id() {
        return mealplan_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public void setHorseNickname(String horseNickname) {
        this.horseNickname = horseNickname;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public void setStable_id(Integer stable_id) {
        this.stable_id = stable_id;
    }

    public void setMealplan_id(Integer mealplan_id) {
        this.mealplan_id = mealplan_id;
    }
}
