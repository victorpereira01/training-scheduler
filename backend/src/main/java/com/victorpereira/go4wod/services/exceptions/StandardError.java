package com.victorpereira.go4wod.services.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long timestamp;

    private Integer status;

    private String error;

    private String messsage;

    private String path;
}
