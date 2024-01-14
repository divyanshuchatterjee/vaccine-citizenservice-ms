package com.vaccination.citizenService.model;

public class Error {

    private String error;
    private String status;
    private String message;

    public void setError(String error) {
        this.error = error;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
