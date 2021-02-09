package com.victorpereira.go4wod.builder;

import com.victorpereira.go4wod.domains.Training;
import com.victorpereira.go4wod.domains.User;
import lombok.Builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
public class TrainingBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String wod = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";

    @Builder.Default
    private final LocalDate date = LocalDate.now();

    @Builder.Default
    private final List<User> users = new ArrayList<>();

    public Training toTraining() {
        return new Training(id, wod, date, users);
    }
}
