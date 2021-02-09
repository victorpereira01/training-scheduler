package com.victorpereira.go4wod.builder;

import com.victorpereira.go4wod.domains.User;
import com.victorpereira.go4wod.domains.enums.UserType;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class UserBuilder {

    @Builder.Default
    private final Long id = 1L;

    @Builder.Default
    private final String name = "User Name";

    @Builder.Default
    private final String email = "user@mail.com";

    @Builder.Default
    private final String password = "123";

    @Builder.Default
    private final LocalDate birthDate = LocalDate.now();

    @Builder.Default
    private final UserType type = UserType.STUDENT;

    public User toUser() {
        return new User(this.id, this.name, this.email, this.password, this.birthDate, this.type);
    }
}
