package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.dtos.TrainingDTO;
import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.repositories.TrainingRepository;
import com.victorpereira.go4wod.repositories.UserRepository;
import com.victorpereira.go4wod.services.exceptions.AlreadyExistsException;
import com.victorpereira.go4wod.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<TrainingDTO> findAll() {
        List<Training> products = trainingRepository.findAll();
        return products.stream().map(TrainingDTO::new).collect(Collectors.toList());
    }

    @Override
    public TrainingDTO findById(Long id) {
        return new TrainingDTO(trainingRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found for id: " + id + ", of type: " + Training.class.getName())));
    }

    @Override
    public TrainingDTO findByDate(LocalDate date) {
        return new TrainingDTO(trainingRepository.findByDate(date).orElseThrow(() ->
                new ObjectNotFoundException("Object not found for date: " + date + ", of type: " + Training.class.getName())));
    }

    @Override
    public TrainingDTO insertTraining(TrainingDTO training) {
        if (!alreadyExists(training)) {
            Training newTraining = new Training(training.getId(), training.getWod(), training.getDate(), new ArrayList<>());
            return new TrainingDTO(trainingRepository.save(newTraining));
        } else {
            throw new AlreadyExistsException("Training already exists with date: " + training.getDate());
        }
    }

    @Override
    public TrainingDTO updateTraining(Long id, TrainingDTO training) {
        TrainingDTO trainingDto = findById(id);

        List<Long> usersId = trainingDto.getUsers().stream().map(UserDTO::getId).collect(Collectors.toList());
        List<User> trainingUsers = userRepository.findAllById(usersId);

        trainingDto.setWod(training.getWod());

        Training newTraining = new Training(trainingDto.getId(), trainingDto.getWod(), trainingDto.getDate(), trainingUsers);
        return new TrainingDTO(trainingRepository.save(newTraining));
    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(findById(id).getId());
    }

    private boolean alreadyExists(TrainingDTO training) {
        List<TrainingDTO> trainings = findAll();
        if (trainings.size() == 0) {
            return false;
        }
        return trainings.stream().anyMatch(trn ->
                trn.getDate().equals(training.getDate()));
    }
}
