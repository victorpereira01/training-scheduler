package com.victorpereira.go4wod.controller;

import com.victorpereira.go4wod.domains.dtos.TrainingUserDTO;
import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.domains.dtos.UserNewDTO;
import com.victorpereira.go4wod.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<UserNewDTO> insert(@Validated @RequestBody UserNewDTO user) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        UserNewDTO newUser = userService.insertUser(user);
        return ResponseEntity.created(uri).body(newUser);
    }

    @GetMapping(value = "/email")
    public ResponseEntity<UserNewDTO> findByEmail(@Validated @RequestParam(value = "value") String email) {
        return ResponseEntity.ok().body(userService.findByEmail(email));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserNewDTO> update(@PathVariable Long id, @RequestBody UserNewDTO user) {
        UserNewDTO newUser = userService.updateUser(id, user);
        return ResponseEntity.ok().body(newUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/trainings")
    @Transactional(readOnly = true)
    public ResponseEntity<List<TrainingUserDTO>> findAllTrainingsByUserId(@PathVariable Long id) {
        List<TrainingUserDTO> trainingList = userService.findAllTrainingsByUserId(id);
        return ResponseEntity.ok().body(trainingList);
    }

    @GetMapping(value = "/{userId}/trainings/{trainingId}")
    @Transactional(readOnly = true)
    public ResponseEntity<TrainingUserDTO> findOneTrainingByUserId(
            @PathVariable("userId") Long userId,
            @PathVariable("trainingId") Long trainingId) {
        TrainingUserDTO training = userService.findOneTrainingByUserId(userId, trainingId);
        return ResponseEntity.ok().body(training);
    }

    @DeleteMapping(value = "/{userId}/trainings/{trainingId}")
    @Transactional
    public ResponseEntity<Void> deleteOneTrainingByUserId(
            @PathVariable("userId") Long userId,
            @PathVariable("trainingId") Long trainingId) {
        userService.deleteOneTrainingByUserId(userId, trainingId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{userId}/trainings/{date}")
    public ResponseEntity<Void> subscribeUserToTraining(
            @PathVariable("userId") Long userId,
            @PathVariable("date") String date) {
        userService.subscribeUserToTraining(userId, date);
        return ResponseEntity.noContent().build();
    }
}
