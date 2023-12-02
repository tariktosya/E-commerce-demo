package com.demo.app.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    GNR_0001(HttpStatus.NOT_FOUND, "Object not found."),
    GNR_0002(HttpStatus.CONFLICT, "Already exists.");

    private final HttpStatus httpStatus;
    private final String description;

    ErrorCode(HttpStatus httpStatus, String description) {
        this.httpStatus = httpStatus;
        this.description = description;
    }
}