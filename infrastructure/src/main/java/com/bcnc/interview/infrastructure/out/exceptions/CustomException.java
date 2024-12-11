package com.bcnc.interview.infrastructure.out.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * This exception has all the fields needed to have all the information needed
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private final String message;
    private final String title;
    private final HttpStatus status;

}
