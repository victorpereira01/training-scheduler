package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.Training;

import java.util.List;

public interface TrainingService {

    List<Training> findAll();

    Training findById(Long id);

    Training insertTraining(Training training);

    Training updateTraining(Long id, Training training);

    void deleteTraining(Long id);
}
