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

    private LocalDateTime date;

    private String sport;

    private String trainType;

    private LocalTime duration;

    private String distance;

    private String description;
}
