package com.victorpereira.go4wod.services;

import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.dtos.TrainingDTO;
import com.victorpereira.go4wod.domains.dtos.TrainingUserDTO;
import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.domains.dtos.UserNewDTO;
import com.victorpereira.go4wod.domains.enums.UserType;
import com.victorpereira.go4wod.repositories.TrainingRepository;
import com.victorpereira.go4wod.repositories.UserRepository;
import com.victorpereira.go4wod.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        users = users.stream().filter(user -> user.getType().equals(UserType.STUDENT)).collect(Collectors.toList());
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserNewDTO findById(Long id) {
        return new UserNewDTO(userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found for id: " + id + ", of type: " + User.class.getName())));
    }

    @Override
    public UserNewDTO insertUser(UserNewDTO userNewDto) {
        User user = new User(userNewDto.getId(), null, userNewDto.getEmail(),
                userNewDto.getPassword(), null, UserType.STUDENT);
        return new UserNewDTO(userRepository.save(user));
    }

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

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(findById(id).getId());
    }

    @Override
    public List<TrainingUserDTO> findAllTrainingsByUserId(Long id) {
        findById(id);
        List<Training> trainings = trainingRepository.findAllByUserId(id);
        return trainings.stream().map(TrainingUserDTO::new).collect(Collectors.toList());
    }

    @Override
    public TrainingUserDTO findOneTrainingByUserId(Long userId, Long trainingId) {
        findById(userId);
        Training training = trainingRepository.findOneByUserId(userId, trainingId)
                .orElseThrow(() -> new ObjectNotFoundException("Training not found for user: " + userId));
        return new TrainingUserDTO(training);
    }

    @Override
    public void deleteOneTrainingByUserId(Long userId, Long trainingId) {
        findById(userId);
        findOneTrainingByUserId(userId, trainingId);
        trainingRepository.deleteOneTrainingByUserId(userId, trainingId);
    }

    @Override
    public void subscribeUserToTraining(Long userId, String date) {
        UserNewDTO userNewDTO = findById(userId);
        UserDTO userDTO = findAll().stream().filter(usr -> usr.getId().equals(userId)).findFirst().get();

        Training training = trainingRepository.findByDate(LocalDate.parse(date)).orElseThrow(() ->
                new ObjectNotFoundException("Object not found for date: " + date + ", of type: " + Training.class.getName()));
        userDTO.setTrainings(Collections.singletonList(new TrainingDTO(training)));

        User updatedUser = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userNewDTO.getPassword(),
                userNewDTO.getBirthDate(), userNewDTO.getType(), Collections.singletonList(training));
        userRepository.save(updatedUser);
    }

    private LocalDateTime formatDate(LocalDateTime localDateTime) {
        String[] splittedDate = localDateTime.toString().split("T");
        String date = splittedDate[0] + "T00:00:00";
        return LocalDateTime.parse(date);
    }
}
