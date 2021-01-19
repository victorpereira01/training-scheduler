package com.victorpereira.go4wod.repositories;

import com.victorpereira.go4wod.domains.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
}
