package io.spring.training.boot.trainingplan.domain;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sport;

    @Column(nullable = false)
    private String trainType;

    @Column(nullable = false)
    private LocalTime duration;

    @Column(nullable = false)
    private String distance;

    private short intensity;

    private String description;

    @OneToMany(mappedBy = "workout",
    fetch = FetchType.LAZY)
    private List<WorkoutAssignment> workoutAssignmentList;
}
