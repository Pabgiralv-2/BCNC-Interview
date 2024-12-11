package com.bcnc.interview.infrastructure.out.exceptions;

import org.springframework.http.*;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Service to handle the exceptions thrown
 */
@ControllerAdvice
public class ExceptionService extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> createResponseEntity(@Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        ProblemDetail errorMessage = (ProblemDetail) body;
        assert errorMessage != null;
        ExceptionResponse exception = new ExceptionResponse(errorMessage.getDetail(), statusCode.toString());
        return new ResponseEntity<>(exception, headers, statusCode);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ExceptionResponse> handleRestException(CustomException ex) {
        ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), ex.getTitle());
        return new ResponseEntity<>(exception, ex.getStatus());
    }

}