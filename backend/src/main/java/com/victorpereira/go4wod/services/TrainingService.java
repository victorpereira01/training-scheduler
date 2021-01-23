package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.dtos.TrainingDTO;

import java.time.LocalDate;
import java.util.List;

public interface TrainingService {

    List<TrainingDTO> findAll();

    TrainingDTO findById(Long id);

    TrainingDTO findByDate(LocalDate date);

    TrainingDTO insertTraining(TrainingDTO training);

    TrainingDTO updateTraining(Long id, TrainingDTO training);

    void deleteTraining(Long id);
}
