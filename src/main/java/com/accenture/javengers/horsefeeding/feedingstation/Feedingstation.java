package com.accenture.javengers.horsefeeding.feedingstation;

import com.accenture.javengers.horsefeeding.stable.Stable;
import jakarta.persistence.*;

import java.time.LocalTime;

/*
@Entity
@Table(name = "feedingstation")

public class Feedingstation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedingstation_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="stable_id", nullable = false)
    private Stable stable;

    @Column(name = "feeding_range")
    private String feedingRange;

    public Integer getId() {
        return id;
    }

    public Stable getStable() {
        return stable;
    }

    public String getFeedingRange() {
        return feedingRange;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStable(Stable stable) {
        this.stable = stable;
    }

    public void setFeedingRange(String feedingRange) {
        this.feedingRange = feedingRange;
    }

}
 */

@Entity
@Table(name = "feedingstation")
public class Feedingstation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedingstation_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "stable_id", nullable = false)
    private Stable stable;

    @Column(name = "feeding_range_start", nullable = false)
    private LocalTime feedingRangeStart;

    @Column(name = "feeding_range_end", nullable = false)
    private LocalTime feedingRangeEnd;

    // Getter und Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Stable getStable() {
        return stable;
    }

    public void setStable(Stable stable) {
        this.stable = stable;
    }

    public LocalTime getFeedingRangeStart() {
        return feedingRangeStart;
    }

    public void setFeedingRangeStart(LocalTime feedingRangeStart) {
        this.feedingRangeStart = feedingRangeStart;
    }

    public LocalTime getFeedingRangeEnd() {
        return feedingRangeEnd;
    }

    public void setFeedingRangeEnd(LocalTime feedingRangeEnd) {
        this.feedingRangeEnd = feedingRangeEnd;
    }
}

