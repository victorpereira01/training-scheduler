package com.victorpereira.go4wod.controller;

import com.victorpereira.go4wod.domains.dtos.TrainingDTO;
import com.victorpereira.go4wod.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<TrainingDTO>> findAll() {
        List<TrainingDTO> trainings = trainingService.findAll();
        return ResponseEntity.ok().body(trainings);
    }

    @GetMapping(value = "/{date}")
    public ResponseEntity<TrainingDTO> findByDate(@PathVariable String date) {
        String formattedDate = date.concat("T00:00:00");
        TrainingDTO trainingDTO = trainingService.findByDate(date);
        return ResponseEntity.ok().body(trainingDTO);
    }

    @PostMapping
    public ResponseEntity<TrainingDTO> insert(@RequestBody TrainingDTO training) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(training.getId()).toUri();
        TrainingDTO newTraining = trainingService.insertTraining(training);
        return ResponseEntity.created(uri).body(newTraining);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TrainingDTO> update(@PathVariable Long id, @RequestBody TrainingDTO training) {
        TrainingDTO newTraining = trainingService.updateTraining(id, training);
        return ResponseEntity.ok().body(newTraining);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trainingService.deleteTraining(id);
        return ResponseEntity.noContent().build();
    }
}
