package io.spring.training.boot.trainingplan.internal.mappers;

import io.spring.training.boot.trainingplan.internal.domain.Workout;
import io.spring.training.boot.trainingplan.internal.dto.WorkoutDto;
import org.mapstruct.Mapper;

@Mapper
public interface WorkoutMapper {
    Workout toEntity(WorkoutDto dto);

    //@Mapping(target = "distanceMeters", source = "distanceM")
    //WorkoutDto toDto(Workout entity);
}
