package com.victorpereira.go4wod.controllers;

import com.victorpereira.go4wod.builder.TrainingBuilder;
import com.victorpereira.go4wod.builder.UserBuilder;
import com.victorpereira.go4wod.controller.UserController;
import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.dtos.TrainingDTO;
import com.victorpereira.go4wod.domains.dtos.TrainingUserDTO;
import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.domains.dtos.UserNewDTO;
import com.victorpereira.go4wod.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.victorpereira.go4wod.utils.JsonConvertionUtils.asJsonString;

@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    private static final String API_URL_PATH = "/users";

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenGETAllIsCalledThenShouldReturnOKStatus() throws Exception {
        User user = UserBuilder.builder().build().toUser();
        UserDTO userDTO = new UserDTO(user);

        when(userService.findAll()).thenReturn(Collections.singletonList(userDTO));

        mockMvc.perform(get(API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(Integer.parseInt(userDTO.getId().toString()))))
                .andExpect(jsonPath("$[0].name", is(userDTO.getName())))
                .andExpect(jsonPath("$[0].email", is(userDTO.getEmail())));
    }

    @Test
    void whenPOSTIsCalledThenShoulReturnCreatedStatus() throws Exception {
        User user = UserBuilder.builder().build().toUser();
        UserNewDTO userNewDTO = new UserNewDTO(user);

        when(userService.insertUser(userNewDTO)).thenReturn(userNewDTO);

        mockMvc.perform(post(API_URL_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(userNewDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(Integer.parseInt(userNewDTO.getId().toString()))))
                .andExpect(jsonPath("$.name", is(userNewDTO.getName())))
                .andExpect(jsonPath("$.email", is(userNewDTO.getEmail())));
    }

    @Test
    void whenPUTIsCalledThenShoulReturnOkStatus() throws Exception {
        User user = UserBuilder.builder().build().toUser();

        User updatedUser = UserBuilder.builder()
                .name("New Name")
                .email("newemail@mail.com")
                .build().toUser();
        UserNewDTO updatedUserNewDTO = new UserNewDTO(updatedUser);

        ResponseEntity<UserNewDTO> responseEntity = ResponseEntity.ok().body(updatedUserNewDTO);
        when(userService.updateUser(any(), any())).thenReturn(responseEntity.getBody());

        mockMvc.perform(put(API_URL_PATH + "/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updatedUserNewDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(Integer.parseInt(updatedUserNewDTO.getId().toString()))))
                .andExpect(jsonPath("$.name", is(updatedUserNewDTO.getName())))
                .andExpect(jsonPath("$.email", is(updatedUserNewDTO.getEmail())));
    }

    @Test
    void whenDELETEIsCalledThenShouldReturnNoContentStatus() throws Exception {
        User user = UserBuilder.builder().build().toUser();

        doNothing().when(userService).deleteUser(user.getId());

        mockMvc.perform(delete(API_URL_PATH + "/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void whenGETUserTrainingsIsCalledThenShouldReturnOkStatus() throws Exception {
        User user = UserBuilder.builder().build().toUser();

        Training training = TrainingBuilder.builder().build().toTraining();
        TrainingUserDTO trainingDTO = new TrainingUserDTO(training);
        when(userService.findAllTrainingsByUserId(any())).thenReturn(Collections.singletonList(trainingDTO));

        mockMvc.perform(get(API_URL_PATH + "/" + user.getId() + "/trainings")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(Integer.parseInt(trainingDTO.getId().toString()))))
                .andExpect(jsonPath("$[0].wod", is(trainingDTO.getWod())));
    }

    @Test
    void whenGETUserTrainingByIdIsCalledThenShouldReturnOkStatus() throws Exception {
        User user = UserBuilder.builder().build().toUser();

        Training training = TrainingBuilder.builder().build().toTraining();
        TrainingUserDTO trainingDTO = new TrainingUserDTO(training);
        when(userService.findOneTrainingByUserId(any(), any())).thenReturn(trainingDTO);

        mockMvc.perform(get(API_URL_PATH + "/" + user.getId() + "/trainings/" + training.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(Integer.parseInt(trainingDTO.getId().toString()))))
                .andExpect(jsonPath("$.wod", is(trainingDTO.getWod())));
    }

    @Test
    void whenDELETEUserTrainingByIdIsCalledThenShouldReturnNoContentStatus() throws Exception {
        User user = UserBuilder.builder().build().toUser();
        Training training = TrainingBuilder.builder().build().toTraining();

        doNothing().when(userService).deleteOneTrainingByUserId(any(), any());

        mockMvc.perform(delete(API_URL_PATH + "/" + user.getId() + "/trainings/" + training.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
