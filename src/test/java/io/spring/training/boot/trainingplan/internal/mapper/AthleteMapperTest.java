package io.spring.training.boot.trainingplan.internal.mapper;

import io.spring.training.boot.trainingplan.internal.domain.Athlete;
import io.spring.training.boot.trainingplan.internal.dto.AthleteDto;
import io.spring.training.boot.trainingplan.internal.mapper.AthleteMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AthleteMapperTest {
    AthleteMapper mapper = Mappers.getMapper(AthleteMapper.class);

    @Test
    void toEntity_mapsDto() {
        String cpf = "65347150076";
        Double weight = 50.5;
        int age = 29;
        String firstName = "Dwight";
        String lastName = "Schrute";

       var dto = new AthleteDto(
               cpf,
               weight,
               age,
               firstName,
               lastName
       );

      var entity = mapper.toEntity(dto);

      assertThat(entity.getSocialIdentifier()).isEqualTo(cpf);
      assertThat(entity.getAge()).isEqualTo(age);
      assertThat(entity.getWeightKg()).isEqualTo(weight);
      assertThat(entity.getFirstName()).isEqualTo(firstName);
      assertThat(entity.getLastName()).isEqualTo(lastName);
    }

    @Test
    void toDto_mapsEntity() {
        String cpf = "65347150076";
        Double weight = 50.5;
        int age = 29;
        String firstName = "Dwight";
        String lastName = "Schrute";

        var entity = Athlete.builder()
                .id(123L)
                .weightKg(weight)
                .age(age)
                .socialIdentifier(cpf)
                .firstName(firstName)
                .lastName(lastName)
                .build();

        var dto = mapper.toDto(entity);

        assertThat(dto.cpf()).isEqualTo(cpf);
        assertThat(dto.age()).isEqualTo(age);
        assertThat(dto.weightKg()).isEqualTo(weight);
        assertThat(dto.firstName()).isEqualTo(firstName);
        assertThat(dto.lastName()).isEqualTo(lastName);
    }
}
