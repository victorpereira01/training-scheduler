package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.dtos.TrainingUserDTO;
import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.domains.dtos.UserNewDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserNewDTO findById(Long id);

    UserNewDTO findByEmail(String email);

    UserNewDTO insertUser(UserNewDTO user);

    UserNewDTO updateUser(Long id, UserNewDTO user);

    void deleteUser(Long id);

    List<TrainingUserDTO> findAllTrainingsByUserId(Long id);

    TrainingUserDTO findOneTrainingByUserId(Long userId, Long trainingId);

    void deleteOneTrainingByUserId(Long userId, Long trainingId);

    void subscribeUserToTraining(Long userId, String date);
}
