package com.accenture.javengers.horsefeeding.stable;

import com.accenture.javengers.horsefeeding.horse.Horse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StableRepository extends JpaRepository<Stable, Integer> {

}
