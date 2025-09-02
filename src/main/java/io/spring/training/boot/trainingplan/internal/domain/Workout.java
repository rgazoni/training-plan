package io.spring.training.boot.trainingplan.internal.domain;

import io.spring.training.boot.trainingplan.internal.domain.common.Sport;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.util.List;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sport sport;

    @Column(nullable = false)
    private String trainType;

    @Column(name = "duration_min")
    private Duration durationMin;

    @Column(name = "distance_m")
    private Integer distanceM;

    private short intensity;

    private String description;

    @Setter
    @OneToMany(mappedBy = "workout",
    fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<WorkoutAssignment> workoutAssignmentList;

}
