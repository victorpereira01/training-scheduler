package com.victorpereira.go4wod.domains.dtos;

import com.victorpereira.go4wod.domains.Training;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class TrainingDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String wod;

    private LocalDate date;

    @Transient
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

