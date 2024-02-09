package com.mobi.manager.mobimanager.exceptions;

import com.mobi.manager.mobimanager.exceptions.errors.ModelExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
@Slf4j
public class ApiExceptionHandler {
    public static final String DEFAULT_INTERNAL_ERROR_MESSAGE = ErrorMessages.DEFAULT_INTERNAL_SERVER_ERROR;

    @ExceptionHandler({Exception.class, Throwable.class})
    public ResponseEntity<Object> internalExceptionHandler(RuntimeException ex) {
        log.info(ex.getLocalizedMessage(), ex);
        return buildErrorResponses(
                ex.getLocalizedMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z")));
    }
    @ExceptionHandler({ModelExistException.class})
    ResponseEntity<Object> handleConflict(RuntimeException ex) {
        log.info(ex.getLocalizedMessage(), ex);
        return buildErrorResponses(
                ex.getLocalizedMessage(),
                HttpStatus.CONFLICT,
                ZonedDateTime.now(ZoneId.of("Z")));
    }

    private ResponseEntity<Object> buildErrorResponses(String message, HttpStatus status, ZonedDateTime timeStamp) {
        return ResponseEntity.status(status).body(new ApiException(message, status, timeStamp));
    }

    private ApiException getApiException(RuntimeException ex, HttpStatus status) {
        log.error("", ex);
        return new ApiException(
                ex.getMessage(),
                status,
                ZonedDateTime.now(ZoneId.systemDefault())
        );
    }
}

