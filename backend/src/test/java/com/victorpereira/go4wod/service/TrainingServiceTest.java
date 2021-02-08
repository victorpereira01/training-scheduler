package com.victorpereira.go4wod.service;

import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.dtos.TrainingDTO;
import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.domains.dtos.UserNewDTO;
import com.victorpereira.go4wod.domains.enums.UserType;
import com.victorpereira.go4wod.repositories.TrainingRepository;
import com.victorpereira.go4wod.repositories.UserRepository;
import com.victorpereira.go4wod.services.TrainingServiceImpl;
import com.victorpereira.go4wod.services.exceptions.AlreadyExistsException;
import com.victorpereira.go4wod.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TrainingServiceTest {

    @Mock
    private TrainingRepository trainingRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TrainingServiceImpl trainingService;

    @Test
    void whenInsertTrainingThenShouldBeCreated() {
        Training expectedSavedTraining = new Training();
        expectedSavedTraining.setId(1L);
        expectedSavedTraining.setWod("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        expectedSavedTraining.setDate(LocalDate.now());
        expectedSavedTraining.setUsers(new ArrayList<>());
        TrainingDTO expectedTrainingDTO = new TrainingDTO(expectedSavedTraining);

        when(trainingRepository.findAll()).thenReturn(new ArrayList<>());
        when(trainingRepository.save(expectedSavedTraining)).thenReturn(expectedSavedTraining);

        TrainingDTO createdTraining = trainingService.insertTraining(expectedTrainingDTO);
        assertEquals(expectedTrainingDTO.getId(), createdTraining.getId());
        assertEquals(expectedTrainingDTO.getWod(), createdTraining.getWod());
        assertEquals(expectedTrainingDTO.getDate(), createdTraining.getDate());
    }

    @Test
    void whenInsertTrainingThenAlreadyExistsExceptionShouldBeThrown() {
        Training expectedSavedTraining = new Training();
        expectedSavedTraining.setId(1L);
        expectedSavedTraining.setWod("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        expectedSavedTraining.setDate(LocalDate.now());
        expectedSavedTraining.setUsers(new ArrayList<>());
        TrainingDTO expectedTrainingDTO = new TrainingDTO(expectedSavedTraining);

        when(trainingRepository.findAll()).thenReturn(List.of(expectedSavedTraining));
        when(trainingRepository.save(expectedSavedTraining)).thenReturn(expectedSavedTraining);

        assertThrows(AlreadyExistsException.class, () -> trainingService.insertTraining(expectedTrainingDTO));
    }

    @Test
    void whenFindAllTrainingsThenShouldReturnTrainingsList() {
        Training expectedSavedTraining = new Training();
        expectedSavedTraining.setId(1L);
        expectedSavedTraining.setWod("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        expectedSavedTraining.setDate(LocalDate.now());
        expectedSavedTraining.setUsers(new ArrayList<>());
        TrainingDTO expectedTrainingDTO = new TrainingDTO(expectedSavedTraining);

        when(trainingRepository.findAll()).thenReturn(Collections.singletonList(expectedSavedTraining));

        List<TrainingDTO> foundTrainingDTOs = trainingService.findAll();

        assertThat(foundTrainingDTOs, is(not(empty())));
        assertThat(foundTrainingDTOs.get(0), is(equalTo(expectedTrainingDTO)));
    }

    @Test
    void whenFindAllTrainingsThenShouldReturnEmptyList() {
        when(trainingRepository.findAll()).thenReturn(Collections.emptyList());
        assertThat(trainingService.findAll(), is(empty()));
    }

    @Test
    void whenFindTrainingByDateThenShouldReturnTraining() {
        Training expectedSavedTraining = new Training();
        expectedSavedTraining.setId(1L);
        expectedSavedTraining.setWod("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        expectedSavedTraining.setDate(LocalDate.now());
        expectedSavedTraining.setUsers(new ArrayList<>());
        TrainingDTO expectedTrainingDTO = new TrainingDTO(expectedSavedTraining);

        when(trainingRepository.findByDate(expectedSavedTraining.getDate()))
                .thenReturn(Optional.of(expectedSavedTraining));

        TrainingDTO foundTrainingDTO = trainingService.findByDate(expectedSavedTraining.getDate());
        assertEquals(foundTrainingDTO.getId(), expectedTrainingDTO.getId());
        assertEquals(foundTrainingDTO.getWod(), expectedTrainingDTO.getWod());
        assertEquals(foundTrainingDTO.getDate(), expectedTrainingDTO.getDate());
    }

    @Test
    void whenFindTrainingByDateThenObjectNotFoundShouldBeThrown() {
        Training expectedSavedTraining = new Training();
        expectedSavedTraining.setId(1L);
        expectedSavedTraining.setWod("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        expectedSavedTraining.setDate(LocalDate.now());
        expectedSavedTraining.setUsers(new ArrayList<>());
        TrainingDTO expectedTrainingDTO = new TrainingDTO(expectedSavedTraining);

        when(trainingRepository.findAll()).thenReturn(List.of(expectedSavedTraining));
        when(trainingRepository.save(expectedSavedTraining)).thenReturn(expectedSavedTraining);

        assertThrows(ObjectNotFoundException.class, () -> trainingService.findByDate(expectedTrainingDTO.getDate()));
    }

    @Test
    void whenUpdateTrainingThenShouldUpdateTraining() {
        Training savedTraining = new Training();
        savedTraining.setId(1L);
        savedTraining.setWod("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        savedTraining.setDate(LocalDate.now());
        savedTraining.setUsers(new ArrayList<>());

        Training updatedTraining = new Training();
        updatedTraining.setId(1L);
        updatedTraining.setWod("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        updatedTraining.setDate(LocalDate.now());
        updatedTraining.setUsers(new ArrayList<>());
        TrainingDTO updatedTrainingDTO = new TrainingDTO(updatedTraining);

        List<Long> usersId = updatedTrainingDTO.getUsers().stream().map(UserDTO::getId).collect(Collectors.toList());
        when(userRepository.findAllById(usersId)).thenReturn(new ArrayList<>());
        when(trainingRepository.findById(savedTraining.getId())).thenReturn(Optional.of(savedTraining));
        when(trainingRepository.save(updatedTraining)).thenReturn(updatedTraining);

        TrainingDTO resultTraining = trainingService.updateTraining(savedTraining.getId(), updatedTrainingDTO);
        assertEquals(updatedTrainingDTO.getId(), resultTraining.getId());
        assertEquals(updatedTrainingDTO.getWod(), resultTraining.getWod());
        assertEquals(updatedTrainingDTO.getDate(), resultTraining.getDate());
    }

    @Test
    void whenDeleteTrainingThenShouldDeleteTraining() {
        Training expectedSavedTraining = new Training();
        expectedSavedTraining.setId(1L);
        expectedSavedTraining.setWod("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        expectedSavedTraining.setDate(LocalDate.now());
        expectedSavedTraining.setUsers(new ArrayList<>());
        TrainingDTO expectedTrainingDTO = new TrainingDTO(expectedSavedTraining);

        when(trainingRepository.findById(expectedSavedTraining.getId())).thenReturn(Optional.of(expectedSavedTraining));
        doNothing().when(trainingRepository).deleteById(expectedTrainingDTO.getId());

        trainingService.deleteTraining(expectedTrainingDTO.getId());
        verify(trainingRepository, times(1)).findById(expectedTrainingDTO.getId());
        verify(trainingRepository, times(1)).deleteById(expectedTrainingDTO.getId());
    }
}
