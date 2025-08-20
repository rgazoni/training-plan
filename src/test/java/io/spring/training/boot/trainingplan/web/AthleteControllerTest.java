package io.spring.training.boot.trainingplan.web;

import io.spring.training.boot.trainingplan.domain.Athlete;
import io.spring.training.boot.trainingplan.service.AthleteService;
import io.spring.training.boot.trainingplan.web.mapper.AthleteMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.matchesPattern;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AthleteController.class)
public class AthleteControllerTest {

    @Autowired
    MockMvc mvc;
    @MockitoBean
    AthleteService service;
    @MockitoBean
    AthleteMapper mapper;

    @Test
    void createAthlete_returns201_andLocation() throws Exception {
        when(service.create(any())).thenReturn(123L);
        when(mapper.toEntity(any())).thenReturn(new Athlete());

        mvc.perform(post("/athletes/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                            "cpf": "65347150076",
                            "weightKg": 70.5,
                            "age": 31,
                            "firstName": "Michael",
                            "lastName": "Scott"
                        }
                        """))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", matchesPattern(".*athletes/123$")));
    }

    @Test
    void createAthlete_returns400_onInvalidPayload() throws Exception {
        mvc.perform(post("/athletes/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                            "weightKg": 70.5,
                            "age": 31,
                            "firstName": "Michael"
                    }
                 """))
                .andExpect(status().isBadRequest());
    }

}
