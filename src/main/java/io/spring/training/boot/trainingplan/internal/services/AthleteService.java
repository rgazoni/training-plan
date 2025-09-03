package io.spring.training.boot.trainingplan.internal.services;

import io.spring.training.boot.trainingplan.internal.domain.Athlete;
import io.spring.training.boot.trainingplan.internal.repositories.AthleteRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

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

    public boolean updateAthlete(long id, Athlete athlete) {

        AtomicBoolean isUpdated = new AtomicBoolean(false);

        repository.findById(id)
                .map(person -> {
                    person.setAge(athlete.getAge());
                    person.setWeightKg(athlete.getWeightKg());
                    person.setFirstName(athlete.getFirstName());
                    person.setLastName(athlete.getLastName());
                    person.setSocialIdentifier(athlete.getSocialIdentifier());
                    isUpdated.set(true);
                    return repository.save(person);
                })
                .orElseGet(() -> repository.save(athlete));

        return isUpdated.get();
    }

    public void deleteAthlete(long id) {
        repository.deleteById(id);
    }
}
