package io.spring.training.boot.trainingplan.internal.mapper;

import io.spring.training.boot.trainingplan.internal.domain.Athlete;
import io.spring.training.boot.trainingplan.internal.dto.AthleteDto;
import io.spring.training.boot.trainingplan.internal.dto.AthleteResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AthleteMapper {
    @Mapping(target = "socialIdentifier", source = "cpf")
    Athlete toEntity(AthleteDto dto);
    @Mapping(target = "cpf", source = "socialIdentifier")
    AthleteResponseDto toDto(Athlete entity);
}
