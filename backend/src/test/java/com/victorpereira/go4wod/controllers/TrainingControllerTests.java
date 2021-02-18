package com.victorpereira.go4wod.controllers;

import com.victorpereira.go4wod.builder.TrainingBuilder;
import com.victorpereira.go4wod.controller.TrainingController;
import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.dtos.TrainingDTO;
import com.victorpereira.go4wod.services.TrainingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Collections;

import static com.victorpereira.go4wod.utils.JsonConvertionUtils.asJsonString;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TrainingControllerTests {

    private static final String API_URL_PATH = "/trainings";

    private MockMvc mockMvc;

    @Mock
    private TrainingService trainingService;

    @InjectMocks
    private TrainingController trainingController;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(trainingController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenGETAllIsCalledThenShouldReturnOkStatus() throws Exception {
        Training training = TrainingBuilder.builder().build().toTraining();
        TrainingDTO trainingDTO = new TrainingDTO(training);

        when(trainingService.findAll()).thenReturn(Collections.singletonList(trainingDTO));

        mockMvc.perform(get(API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(Integer.parseInt(trainingDTO.getId().toString()))))
                .andExpect(jsonPath("$[0].wod", is(trainingDTO.getWod())));
    }

    @Test
    void whenGETByDateIsCalledThenShouldReturnOkStatus() throws Exception {
        Training training = TrainingBuilder.builder().build().toTraining();
        TrainingDTO trainingDTO = new TrainingDTO(training);

        when(trainingService.findByDate(trainingDTO.getDate())).thenReturn(trainingDTO);

        mockMvc.perform(get(API_URL_PATH + "/" + trainingDTO.getDate())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(Integer.parseInt(trainingDTO.getId().toString()))))
                .andExpect(jsonPath("$.wod", is(trainingDTO.getWod())));
    }

    @Test
    void whenPOSTIsCalledThenShouldReturnCreatedStatus() throws Exception {
        Training training = TrainingBuilder.builder().build().toTraining();
        TrainingDTO trainingDTO = new TrainingDTO(training);

        when(trainingService.insertTraining(any(TrainingDTO.class))).thenReturn(trainingDTO);

        mockMvc.perform(post(API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(trainingDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(Integer.parseInt(trainingDTO.getId().toString()))))
                .andExpect(jsonPath("$.wod", is(trainingDTO.getWod())));
    }

    @Test
    void whenPUTIsCalledThenShouldReturnOkStatus() throws Exception {
        Training training = TrainingBuilder.builder().build().toTraining();

        Training updatedTraining = TrainingBuilder.builder()
                .wod("new wod")
                .build().toTraining();
        TrainingDTO updatedTrainingDTO = new TrainingDTO(updatedTraining);

        ResponseEntity<TrainingDTO> responseEntity = ResponseEntity.ok().body(updatedTrainingDTO);
        when(trainingService.updateTraining(any(), any())).thenReturn(responseEntity.getBody());

        mockMvc.perform(put(API_URL_PATH + "/" + training.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updatedTrainingDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(Integer.parseInt(updatedTrainingDTO.getId().toString()))))
                .andExpect(jsonPath("$.wod", is(updatedTrainingDTO.getWod())));
    }

    @Test
    void whenDELETEIsCalledThenShouldReturnNoContentStatus() throws Exception {
        Training training = TrainingBuilder.builder().build().toTraining();

        doNothing().when(trainingService).deleteTraining(training.getId());

        mockMvc.perform(delete(API_URL_PATH + "/" + training.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
