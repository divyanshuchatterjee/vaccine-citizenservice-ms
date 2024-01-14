package com.vaccination.citizenService.exceptionHandler;

import com.vaccination.citizenService.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class CItizenControllerHandler {

    @ExceptionHandler(EmptyQueryParamException.class)
    public ResponseEntity<Error> handleNotFound(EmptyQueryParamException emptyQueryParamException){
        Error err = new Error();
        err.setError("Empty Query Parameter");
        err.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        err.setMessage(emptyQueryParamException.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
