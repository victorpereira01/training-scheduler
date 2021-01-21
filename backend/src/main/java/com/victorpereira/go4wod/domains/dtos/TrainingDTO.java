package com.victorpereira.go4wod.domains.dtos;

import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String wod;

    private LocalDate date;

    private List<UserDTO> users;

    public TrainingDTO(Long id, String wod, LocalDate date) {
        this.id = id;
        this.wod = wod;
        this.date = date;
    }

    public TrainingDTO(Training training) {
        this.id = training.getId();
        this.wod = training.getWod();
        this.date = training.getDate();
        this.users = training.getUsers().stream()
                .map(UserDTO::new).collect(Collectors.toList());
    }
}

