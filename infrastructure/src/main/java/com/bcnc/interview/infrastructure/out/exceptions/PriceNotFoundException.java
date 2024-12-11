package com.bcnc.interview.infrastructure.out.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Exception thrown when a Price was not found
 */
public class PriceNotFoundException extends CustomException {

    private static final String PRICE_NOT_FOUND_MESSAGE = "No price was found";
    private static final String PRICE_NOT_FOUND_TITLE = "PRICE NOT FOUND";

    public PriceNotFoundException() {
        super(PRICE_NOT_FOUND_MESSAGE, PRICE_NOT_FOUND_TITLE, HttpStatus.NOT_FOUND);
    }
}
