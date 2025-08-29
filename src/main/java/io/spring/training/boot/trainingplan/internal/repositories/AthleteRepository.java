package io.spring.training.boot.trainingplan.internal.repositories;

import io.spring.training.boot.trainingplan.internal.domain.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    boolean existsAthleteBySocialIdentifier(String socialIdentifier);
}
