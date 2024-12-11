package com.bcnc.interview.infrastructure.out.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Exception thrown when a Price was not found
 */
public class NegativeValueNotAllowedException extends CustomException {

    private static final String NEGATIVE_VALUE_MESSAGE = "The field {fieldName} cannot be lower than 0";
    private static final String NEGATIVE_VALUE_TITLE = "NEGATIVE VALUE NOT ALLOWED";

    public NegativeValueNotAllowedException(String fieldName) {
        super(NEGATIVE_VALUE_MESSAGE.replace("{fieldName}", fieldName),
                NEGATIVE_VALUE_TITLE, HttpStatus.BAD_REQUEST);
    }
}
