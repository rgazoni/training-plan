package io.spring.training.boot.trainingplan.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private LocalDateTime date;

    private String sport;

    private String distance;
}
