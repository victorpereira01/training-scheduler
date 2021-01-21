package com.victorpereira.go4wod.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.victorpereira.go4wod.domains.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private LocalDate birthDate;

    private UserType type;

    @ManyToMany
    @JoinTable(name = "tb_user_training",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "training_id"))
    @Setter(AccessLevel.NONE)
    private List<Training> trainings = new ArrayList<>();
}
