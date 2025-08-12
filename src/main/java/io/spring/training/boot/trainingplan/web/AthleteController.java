package io.spring.training.boot.trainingplan.web;

import io.spring.training.boot.trainingplan.domain.Athlete;
import io.spring.training.boot.trainingplan.service.AthleteService;
import io.spring.training.boot.trainingplan.web.dto.AthleteDto;
import io.spring.training.boot.trainingplan.web.dto.AthleteResponseDto;
import io.spring.training.boot.trainingplan.web.mapper.AthleteMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("athletes")
@Controller
public class AthleteController {
    private final AthleteService service;
    private final AthleteMapper mapper;

    public AthleteController(AthleteService service, AthleteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/")
    public ResponseEntity<Void> create(@Validated @RequestBody AthleteDto athlete) {
        Athlete athleteRequestEntity = mapper.toEntity(athlete);
        long id = service.create(athleteRequestEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }

    @GetMapping("/{id}")
    public AthleteResponseDto findById(@PathVariable long id) {
        return mapper.toDto(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAthlete(@RequestBody AthleteDto newBody, @PathVariable long id) {
        Athlete athlete = mapper.toEntity(newBody);
        boolean isUpdated = service.updateAthlete(id, athlete);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return isUpdated ?
                ResponseEntity
                        .noContent()
                        .location(location)
                        .build() :
                ResponseEntity
                        .created(location)
                        .build();
    }


}
