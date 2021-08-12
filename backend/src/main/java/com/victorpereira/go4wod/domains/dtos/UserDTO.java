package com.victorpereira.go4wod.domains.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.victorpereira.go4wod.domains.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    @JsonIgnore
    private List<TrainingDTO> trainings;

    public UserDTO(Long id, String name, LocalDate birthDate, String email) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.birthDate = user.getBirthDate();
        this.email = user.getEmail();
    }
}
