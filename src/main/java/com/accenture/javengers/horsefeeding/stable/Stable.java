package com.accenture.javengers.horsefeeding.stable;
import com.accenture.javengers.horsefeeding.feedingstation.Feedingstation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


@Entity
@Table(name = "stable")
public class Stable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stable_id")
    private Integer id;

    @Column(name = "stableName")
    private String stableName;

    @JsonIgnore
    @OneToMany(mappedBy = "stable")
    private Set<Feedingstation> feedingstation;

    public Integer getId() {
        return id;
    }

    public String getStableName() {
        return stableName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStableName(String stableName) {
        this.stableName = stableName;
    }

}
