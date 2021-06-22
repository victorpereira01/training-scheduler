package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.dtos.TrainingDTO;
import com.victorpereira.go4wod.domains.dtos.TrainingUserDTO;
import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.domains.dtos.UserNewDTO;
import com.victorpereira.go4wod.domains.enums.UserType;
import com.victorpereira.go4wod.repositories.UserRepository;
import com.victorpereira.go4wod.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainingService trainingService;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll().stream().filter(user -> user.getType().equals(UserType.STUDENT))
                .collect(Collectors.toList());
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @CrossOrigin
    @Override
    public UserNewDTO findById(Long id) {
        return new UserNewDTO(userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found for id: " + id + ", of type: " + User.class.getName())));
    }

    @CrossOrigin
    @Override
    public UserNewDTO insertUser(UserNewDTO userNewDto) {
        User user = new User(userNewDto.getId(), null, userNewDto.getEmail(),
                userNewDto.getPassword(), null, UserType.STUDENT);
        return new UserNewDTO(userRepository.save(user));
    }

    @CrossOrigin
    @Override
    public UserNewDTO updateUser(Long id, UserNewDTO newUser) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found for id: " + id + ", of type: " + User.class.getName()));

        user.setName(newUser.getName());
        user.setBirthDate(newUser.getBirthDate());
        if (newUser.getEmail() != null) {
            user.setEmail(newUser.getEmail());
        }
        return new UserNewDTO(userRepository.save(user));
    }

    @CrossOrigin
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(findById(id).getId());
    }

    @CrossOrigin
    @Override
    public List<TrainingUserDTO> findAllTrainingsByUserId(Long id) {
        findById(id);
        List<Training> trainings = trainingService.findAllByUserId(id).stream().map(Training::new).collect(Collectors.toList());
        return trainings.stream().map(TrainingUserDTO::new).collect(Collectors.toList());
    }

    @CrossOrigin
    @Override
    public TrainingUserDTO findOneTrainingByUserId(Long userId, Long trainingId) {
        findById(userId);
        Training training = new Training(trainingService.findOneByUserId(userId, trainingId));
        return new TrainingUserDTO(training);
    }

    @CrossOrigin
    @Override
    public void deleteOneTrainingByUserId(Long userId, Long trainingId) {
        findById(userId);
        findOneTrainingByUserId(userId, trainingId);
        trainingService.removeTrainingFromUser(userId, trainingId);
    }

    @CrossOrigin
    @Override
    public void subscribeUserToTraining(Long userId, String date) {
        UserNewDTO userNewDTO = findById(userId);
        UserDTO userDTO = findAll().stream().filter(usr -> usr.getId().equals(userId)).findFirst().get();

        TrainingDTO trainingDTO = trainingService.findByDate(date);
        userDTO.setTrainings(Collections.singletonList(trainingDTO));

        User updatedUser = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userNewDTO.getPassword(),
                userNewDTO.getBirthDate(), userNewDTO.getType(), Collections.singletonList(new Training(trainingDTO)));
        userRepository.save(updatedUser);
    }
}
