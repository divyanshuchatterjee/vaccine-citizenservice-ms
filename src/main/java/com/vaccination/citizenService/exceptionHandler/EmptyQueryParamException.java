package com.vaccination.citizenService.exceptionHandler;

public class EmptyQueryParamException extends  RuntimeException{

    public EmptyQueryParamException(String message) {
        super(message);
    }
}
