package com.victorpereira.go4wod.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private LocalDateTime date;

    @ManyToMany(mappedBy = "trainings", fetch = FetchType.EAGER)
    private List<User> users;

    public Training(Long id, String wod, LocalDateTime date) {
        this.id = id;
        this.wod = wod;
        this.date = date;
    }
}
