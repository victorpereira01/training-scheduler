package com.victorpereira.go4wod.controller;

import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.services.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping
    public ResponseEntity<List<Training>> findAll() {
        List<Training> trainings = trainingService.findAll();
        return ResponseEntity.ok().body(trainings);
    }

    @GetMapping(value = "/{date}")
    public ResponseEntity<Training> findByDate(@PathVariable String date) throws ParseException {
        Training training = trainingService.findByDate(LocalDate.parse(date));
        return ResponseEntity.ok().body(training);
    }

    @PostMapping
    public ResponseEntity<Training> insert(@RequestBody Training training) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(training.getId()).toUri();
        Training newTraining = trainingService.insertTraining(training);
        return ResponseEntity.created(uri).body(newTraining);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Training> update(@PathVariable Long id, @RequestBody Training training) {
        Training newTraining = trainingService.updateTraining(id, training);
        return ResponseEntity.ok().body(newTraining);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trainingService.deleteTraining(id);
        return ResponseEntity.noContent().build();
    }
}
