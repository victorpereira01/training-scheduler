package com.victorpereira.go4wod.domains;

import com.victorpereira.go4wod.domains.dtos.UserDTO;
import com.victorpereira.go4wod.domains.enums.UserType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Size(min = 4, max = 100, message = "Email must be between 4 and 100 characters")
    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 4, message = "Password must be bigger than 4 characters")
    private String password;

    private LocalDate birthDate;

    private UserType type;

    @ManyToMany
    @JoinTable(name = "tb_user_training",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    @Setter(AccessLevel.NONE)
    private List<Training> trainings = new ArrayList<>();

    public User(Long id, String name, String email, String password, LocalDate birthDate, UserType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.type = type;
    }

    public User(Long id, String name, String email, String password, LocalDate birthDate,
                UserType type, List<Training> trainings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.type = type;
        this.trainings = trainings;
    }

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.trainings = userDTO.getTrainings().stream().map(Training::new).collect(Collectors.toList());
    }
}
