package com.accenture.javengers.horsefeeding.horse;

/*public class HorseDto {

    private String horseName;
    private String horseNickname;
    private String breed;

    public String getHorseName() {
        return horseName;
    }

    public String getHorseNickname() {
        return horseNickname;
    }

    public String getBreed() {
        return breed;
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

}*/

public class HorseDto {
    private Integer id;
    private String guid;
    private String horseName;
    private String horseNickname;
    private String breed;
    private Integer owner_id;
    private Integer stable_id;
    private Integer mealplan_id;

    // Getter und Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getHorseName() {
        return horseName;
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

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public String getHorseNickname() {
        return horseNickname;
    }

    public void setHorseNickname(String horseNickname) {
        this.horseNickname = horseNickname;
    }

    public String getBreed() {
        return breed;
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
