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
    public ResponseEntity<Error> handleNotFound(){
        Error err = new Error();
        err.setError("Empty Query Parameter");
        err.setStatus(HttpStatus.BAD_REQUEST.getReasonPhrase());
        err.setMessage("The request body is missing a required field, please check again");
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
