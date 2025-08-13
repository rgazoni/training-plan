package io.spring.training.boot.trainingplan.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "workout_completion")
public class WorkoutCompletion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignment_id", referencedColumnName = "id")
    private WorkoutAssignment workoutAssignment;

    private LocalDateTime date;

    private float result;

    private int perceivedEffort;

    private String notes;
}
