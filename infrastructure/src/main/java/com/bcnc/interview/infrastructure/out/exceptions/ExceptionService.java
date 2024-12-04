package com.bcnc.interview.infrastructure.out.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Service to handle the exceptions thrown
 */
@Slf4j
@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleRestException(CustomException ex){
//        log.debug(LogUtils.coreMarker, "ExceptionService - handleRestException - Exception caught with code ["
//                + ex.getCode() + "], message [" + ex.getMessage() + "] and status [" + ex.getStatus() + "]");
        ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), ex.getCode());
        return new ResponseEntity<>(exception, ex.getStatus());
    }

}

