package io.spring.training.boot.trainingplan.domain;

import io.spring.training.boot.trainingplan.domain.common.Sport;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "race")
@Data
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sport sport;

    @Column(nullable = false)
    private String distance;
}
