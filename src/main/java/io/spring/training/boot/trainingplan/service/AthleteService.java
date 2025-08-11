package io.spring.training.boot.trainingplan.service;

import io.spring.training.boot.trainingplan.domain.Athlete;
import io.spring.training.boot.trainingplan.repositories.AthleteRepository;
import org.springframework.stereotype.Service;

@Service
public class AthleteService {

    private final AthleteRepository repository;

    public AthleteService(AthleteRepository repository) {
        this.repository = repository;
    }

    public long create(Athlete athlete) {

        if(repository.existsAthleteBySocialIdentifier(athlete.getSocialIdentifier())) {
            throw new IllegalArgumentException("Athlete already exists");
        }

        Athlete newAthlete = repository.save(athlete);

        return newAthlete.getId();
    }

    public Athlete findById(long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Athlete didn't found."));
    }

}
