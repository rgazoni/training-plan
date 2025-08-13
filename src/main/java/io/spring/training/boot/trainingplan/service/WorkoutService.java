package io.spring.training.boot.trainingplan.service;

import io.spring.training.boot.trainingplan.domain.Workout;
import io.spring.training.boot.trainingplan.repositories.WorkoutRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private final WorkoutRepository repository;

    public WorkoutService(WorkoutRepository repository) {
        this.repository = repository;
    }

    public void create(Workout workout) {




    }
}
