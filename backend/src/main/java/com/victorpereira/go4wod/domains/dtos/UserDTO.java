package com.victorpereira.go4wod.domains.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.enums.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String email;

    private LocalDate birthDate;

    private UserType type;

    @JsonIgnore
    private List<TrainingDTO> trainings;

    public UserDTO(Long id, String name, String email, LocalDate birthDate, UserType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.type = type;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.birthDate = user.getBirthDate();
        this.type = user.getType();
    }
}
