package com.demo.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({ CustomException.class })
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        log.error(ex.getErrorCode().getDescription() + " (" + ex.getMessage() + ")\n" + ex.getStackTrace()[0] + "\n");
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), ex.getErrorCode().getDescription()), ex.getErrorCode().getHttpStatus());
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    protected ResponseEntity<ErrorResponse> handleUniqueConstraintException() {
        return handleCustomException(new CustomException(ErrorCode.GNR_0002));
    }
}