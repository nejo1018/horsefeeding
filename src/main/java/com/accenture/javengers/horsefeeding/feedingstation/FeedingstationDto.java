package com.accenture.javengers.horsefeeding.feedingstation;

/*
public class FeedingstationDto {

    private Integer feedingstation_id;
    private String feeding_range;
    private String stable_name;

    public Integer getFeedingstation_id() {
        return feedingstation_id;
    }

    public String getFeeding_range() {
        return feeding_range;
    }

    public String getStable_name() {
        return stable_name;
    }

    public void setFeedingstation_id(Integer feedingstation_id) {
        this.feedingstation_id = feedingstation_id;
    }

    public void setFeeding_range(String feeding_range) {
        this.feeding_range = feeding_range;
    }

    public void setStable_name(String stable_name) {
        this.stable_name = stable_name;
    }
}

 */

public class FeedingstationDto {

    private Integer feedingstation_id;
    private String stable_name;
    private String feeding_range;

    // Getter und Setter
    public Integer getFeedingstation_id() {
        return feedingstation_id;
    }

    public void setFeedingstation_id(Integer feedingstation_id) {
        this.feedingstation_id = feedingstation_id;
    }

    public String getStable_name() {
        return stable_name;
    }

    public void setStable_name(String stable_name) {
        this.stable_name = stable_name;
    }

    public String getFeeding_range() {
        return feeding_range;
    }

    public void setFeeding_range(String feeding_range) {
        this.feeding_range = feeding_range;
    }
}
