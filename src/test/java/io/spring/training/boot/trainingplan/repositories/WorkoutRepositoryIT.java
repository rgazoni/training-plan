package io.spring.training.boot.trainingplan.repositories;

import io.spring.training.boot.trainingplan.internal.domain.Workout;
import io.spring.training.boot.trainingplan.internal.domain.common.Sport;
import io.spring.training.boot.trainingplan.internal.repositories.WorkoutRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class WorkoutRepositoryIT {

    @Autowired
    TestEntityManager em;
    @Autowired
    WorkoutRepository wr;

    @Test
    void savesWorkout_andCheckDataIntegrity() {
        Workout workout = persistValidWorkout();

        Optional<Workout> found = wr.findById(workout.getId());

        assertThat(found).isPresent().get()
                .extracting(Workout::getId).isEqualTo(workout.getId());

    }

    private Workout persistValidWorkout() {
        var workout = Workout.builder()
                .name("Lactate Threshold Test (LT Test)")
                .sport(Sport.RUN)
                .trainType("TEST")
                .durationMin(LocalTime.of(0, 45, 0))
                .distanceM(8000)
                .intensity((short) 10)
                .description("This exercise has the goal of determine someone's training zones")
                .build();

        em.persistAndFlush(workout);
        return workout;
    }

}
