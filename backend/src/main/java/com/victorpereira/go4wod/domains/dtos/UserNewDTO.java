package com.victorpereira.go4wod.domains.dtos;

import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.enums.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserNewDTO {

    private Long id;

    private String name;

    private String email;

    private String password;

    private LocalDate birthDate;

    private UserType type;

    private List<TrainingDTO> trainings = new ArrayList<>();

    public UserNewDTO(Long id, String name, String email, String password, LocalDate birthDate, UserType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.type = type;
    }

    public UserNewDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.birthDate = user.getBirthDate();
        this.type = user.getType();
    }
}
