package io.spring.training.boot.trainingplan.repositories;

import io.spring.training.boot.trainingplan.domain.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
