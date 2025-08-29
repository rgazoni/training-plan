package io.spring.training.boot.trainingplan.web;

import io.spring.training.boot.trainingplan.internal.domain.Athlete;
import io.spring.training.boot.trainingplan.internal.service.AthleteService;
import io.spring.training.boot.trainingplan.web.mapper.AthleteMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
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

    @Test
    void createAthlete_returns400_onInvalidCPF() throws Exception {
        mvc.perform(post("/athletes/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                    {
                            "cpf": "156$c",
                            "weightKg": 70.5,
                            "age": 31,
                            "firstName": "Michael",
                            "lastName": "Scott"
                    }
                 """))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    Exception ex = result.getResolvedException();
                    assertThat(ex).isInstanceOf(MethodArgumentNotValidException.class);
                    var manve = (MethodArgumentNotValidException) ex;
                    assert manve != null;
                    var msg = Objects.requireNonNull(manve.getBindingResult()
                                    .getFieldError("cpf"))
                            .getDefaultMessage();
                    assertThat(msg).contains("invalid Brazilian");
                });

    }

}
