package com.victorpereira.go4wod.domains.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserType {

    TRAINER(0), STUDENT(1);

    @Getter
    private int code;

    public static UserType toEnum(Integer code) {
        if (code == null)
            return null;

        for (UserType usr : UserType.values()) {
            if (code.equals(usr.getCode()))
                return usr;
        }
        throw new IllegalArgumentException("Invalid UserType id: " + code);
    }
}

