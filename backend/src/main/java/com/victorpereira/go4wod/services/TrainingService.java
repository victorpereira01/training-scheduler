package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.dtos.TrainingDTO;

import java.time.LocalDate;
import java.util.List;

public interface TrainingService {

    List<TrainingDTO> findAll();

    Training findById(Long id);

    Training findByDate(LocalDate date);

    Training insertTraining(Training training);

    Training updateTraining(Long id, Training training);

    void deleteTraining(Long id);
}
