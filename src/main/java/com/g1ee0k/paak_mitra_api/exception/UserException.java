package com.g1ee0k.paak_mitra_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserException {
    @ExceptionHandler(value = UserExistsException.class)
    public ResponseEntity<Object> exception(UserExistsException userExistsException) {
        return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = InvalidCredentialsException.class)
    public ResponseEntity<Object> invalidCred(InvalidCredentialsException invalidCredentialsException) {
        return new ResponseEntity<>("Invalid Credentials", HttpStatus.NOT_ACCEPTABLE);
    }
}

