package io.spring.training.boot.trainingplan.internal.repositories;

import io.spring.training.boot.trainingplan.internal.domain.Workout;
import io.spring.training.boot.trainingplan.internal.domain.common.Sport;
import io.spring.training.boot.trainingplan.internal.repositories.WorkoutRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Slf4j
@DataJpaTest
public class WorkoutRepositoryIT {

    @Autowired
    TestEntityManager em;
    @Autowired
    WorkoutRepository wr;

    @Test
    void savesWorkout_andCompareId() {
        Workout workout = persistValidWorkout();

        Optional<Workout> found = wr.findById(workout.getId());

        assertThat(found).isPresent().get()
                .extracting(Workout::getId).isEqualTo(workout.getId());

    }

    @Test
    void savesWorkout_andCheckIfItExistsByName() {
        Workout workout = persistValidWorkout();

        boolean exists = wr.existsByName(workout.getName());

        assertThat(exists).isTrue();
    }

    private Workout persistValidWorkout() {
        var workout = Workout.builder()
                .name("Lactate Threshold Test (LT Test)")
                .sport(Sport.RUN)
                .trainType("TEST")
                .durationMin(Duration.parse("PT1H30M"))
                .distanceM(8000)
                .intensity((short) 10)
                .description("This exercise has the goal of determine someone's training zones")
                .build();

        em.persistAndFlush(workout);
        log.info(String.format("TEST: The workout persisted correctly. Id: %d, Name: %s, Desc: %s", workout.getId(), workout.getName(), workout.getDescription()));
        return workout;
    }

}
