package com.accenture.javengers.horsefeeding.feedingstation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedingstationRepository extends JpaRepository<Feedingstation, Integer> {

}
