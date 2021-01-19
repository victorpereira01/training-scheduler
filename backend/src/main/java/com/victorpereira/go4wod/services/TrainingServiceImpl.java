package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.repositories.TrainingRepository;
import com.victorpereira.go4wod.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public List<Training> findAll() {
        return trainingRepository.findAll();
    }

    @Override
    public Training findById(Long id) {
        return trainingRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found for id: " + id + ", of type: " + Training.class.getName()));
    }

    @Override
    public Training insertTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Training updateTraining(Long id, Training training) {
        Training newTraining = findById(id);
        newTraining.setWod(training.getWod());
        newTraining.setDate(training.getDate());
        return trainingRepository.save(newTraining);
    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(findById(id).getId());
    }
}
