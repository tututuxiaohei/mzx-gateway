package com.mzx.gateway.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomizeException extends RuntimeException {

    private HttpStatus httpStatus;

    private Integer status;

    private String message;

    protected CustomizeException(HttpStatus httpStatus, Integer status, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.status = status;
        this.message = message;
    }


    public static CustomizeException create(HttpStatus httpStatus, Integer status, String message) {
        return new CustomizeException(httpStatus, status, message);
    }
}
