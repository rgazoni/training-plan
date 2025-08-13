package io.spring.training.boot.trainingplan.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "workout_assignment")
public class WorkoutAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athlete_id", nullable = false)
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @Column(nullable = false)
    private LocalDateTime planned_date;

    @OneToOne(mappedBy = "workoutAssignment")
    private WorkoutCompletion workoutCompletion;

}