package io.spring.training.boot.trainingplan.web.mapper;

import io.spring.training.boot.trainingplan.domain.Athlete;
import io.spring.training.boot.trainingplan.web.dto.AthleteDto;
import io.spring.training.boot.trainingplan.web.dto.AthleteResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AthleteMapper {
    @Mapping(target = "socialIdentifier", source = "cpf")
    Athlete toEntity(AthleteDto dto);
    AthleteResponseDto toDto(Athlete entity);
}
