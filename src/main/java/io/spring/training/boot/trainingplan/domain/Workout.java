package io.spring.training.boot.trainingplan.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String sport;

    @Column(nullable = false)
    private String trainType;

    @Column(nullable = false)
    private LocalTime duration;

    @Column(nullable = false)
    private String distance;

    private String description;
}
