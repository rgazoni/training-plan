package io.spring.training.boot.trainingplan.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor // Safe lombok and JPA interaction - Builder
@AllArgsConstructor // Safe lombok and JPA interaction - Builder
@Entity
@Table(name = "athlete")
public class Athlete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String socialIdentifier;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Double weightKg;

    @Column(nullable = false)
    private Integer age;

    @OneToMany(mappedBy = "athlete",
    fetch = FetchType.LAZY)
    @ToString.Exclude // Safe lombok jpa interaction - ToString
    private List<WorkoutAssignment> workoutAssignments;
}
