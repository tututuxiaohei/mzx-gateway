package com.mzx.gateway.exception;

import org.springframework.http.HttpStatus;

public class SignVerifyException extends CustomizeException {

    private SignVerifyException(HttpStatus httpStatus, Integer status, String message) {
        super(httpStatus, status, message);
    }

    public static SignVerifyException create(HttpStatus httpStatus, Integer status, String message) {
        return new SignVerifyException(httpStatus, status, message);
    }
}
