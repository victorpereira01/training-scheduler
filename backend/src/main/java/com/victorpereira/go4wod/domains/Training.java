package com.victorpereira.go4wod.domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String wod;

    private LocalDate date;

    @ManyToMany(mappedBy = "trainings", fetch = FetchType.EAGER)
    private List<User> users;

    @PreRemove
    public void removeTrainingFromUsers() {
        for (User user : users) {
            user.getTrainings().remove(this);
        }
    }

    public Training(Long id, String wod, LocalDate date) {
        this.id = id;
        this.wod = wod;
        this.date = date;
    }
}
