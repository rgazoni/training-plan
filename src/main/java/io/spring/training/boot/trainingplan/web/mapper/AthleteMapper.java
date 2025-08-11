package io.spring.training.boot.trainingplan.web.mapper;

import io.spring.training.boot.trainingplan.domain.Athlete;
import io.spring.training.boot.trainingplan.web.dto.AthleteCreateDto;
import io.spring.training.boot.trainingplan.web.dto.AthleteResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AthleteMapper {
    @Mapping(target = "socialIdentifier", source = "cpf")
    Athlete toEntity(AthleteCreateDto dto);
    AthleteResponseDto toDto(Athlete entity);
}
