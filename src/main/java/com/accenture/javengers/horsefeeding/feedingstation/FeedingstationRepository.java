package com.accenture.javengers.horsefeeding.feedingstation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface FeedingstationRepository extends JpaRepository<Feedingstation, Integer> {

}