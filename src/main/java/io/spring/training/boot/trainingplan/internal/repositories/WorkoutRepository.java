package io.spring.training.boot.trainingplan.internal.repositories;

import io.spring.training.boot.trainingplan.internal.domain.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    boolean existsByName(String name);
}
