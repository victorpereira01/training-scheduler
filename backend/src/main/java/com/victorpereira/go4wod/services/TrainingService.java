package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.dtos.TrainingDTO;

import java.util.List;
import java.util.Optional;

public interface TrainingService {

    List<TrainingDTO> findAll();

    TrainingDTO findById(Long id);

    TrainingDTO findByDate(String date);

    TrainingDTO insertTraining(TrainingDTO training);

    TrainingDTO updateTraining(Long id, TrainingDTO training);

    void deleteTraining(Long id);

    List<TrainingDTO> findAllByUserId(Long userId);

    TrainingDTO findOneByUserId(Long userId, Long trainingId);

    void removeTrainingFromUser(Long userId, Long trainingId);
}
