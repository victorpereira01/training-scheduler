package com.victorpereira.go4wod.domains.dtos;

import com.victorpereira.go4wod.domains.Training;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String wod;

    private LocalDate date;

    public TrainingUserDTO(Training training) {
        this.id = training.getId();
        this.wod = training.getWod();
        this.date = training.getDate();
    }
}


