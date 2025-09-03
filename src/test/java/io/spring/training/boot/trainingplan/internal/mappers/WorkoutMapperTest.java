package io.spring.training.boot.trainingplan.internal.mappers;

import io.spring.training.boot.trainingplan.internal.domain.Workout;
import io.spring.training.boot.trainingplan.internal.domain.common.Sport;
import io.spring.training.boot.trainingplan.internal.dto.WorkoutDto;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WorkoutMapperTest {
    WorkoutMapper mapper = Mappers.getMapper(WorkoutMapper.class);

    @Test
    void toEntity_mapsDto() {
        String name = "Lactate Threshold Test (LT Test)";
        Sport sport = Sport.RUN;
        String trainType = "TEST";
        Duration duration = Duration.parse("PT1H30M");
        Integer distanceM = 1_000;
        String description = "This exercise has the goal of determine someone's training zones";

        var dto = new WorkoutDto(
                name,
                sport,
                trainType,
                duration,
                distanceM,
                description
        );

        Workout entity = mapper.toEntity(dto);

        assertThat(entity.getName()).isEqualTo(name);
        assertThat(entity.getSport()).isEqualTo(sport);
        assertThat(entity.getTrainType()).isEqualTo(trainType);
        assertThat(entity.getDurationMin()).isEqualTo(duration);
        assertThat(entity.getDistanceM()).isEqualTo(distanceM);
        assertThat(entity.getDescription()).isEqualTo(description);
    }
}
