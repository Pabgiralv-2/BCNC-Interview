package com.bcnc.interview.infrastructure.out.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


/**
 * DTO to display all the exceptions handled
 */
@Data
public class ExceptionResponse {
    private String message;
    private String code;
    private final LocalDateTime date;

    public ExceptionResponse(String message, String code) {
        this.code = code;
        this.message = message;
        this.date = LocalDateTime.now();
    }
}
