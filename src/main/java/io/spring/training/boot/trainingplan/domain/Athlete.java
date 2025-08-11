package io.spring.training.boot.trainingplan.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
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
    private Double weight;

    @Column(nullable = false)
    private Integer age;
}
