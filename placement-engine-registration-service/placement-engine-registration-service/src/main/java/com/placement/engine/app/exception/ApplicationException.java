package com.placement.engine.app.exception;

public class ApplicationException extends RuntimeException {

    ErrorStatus errorStatus;
    String message;

    Exception originalException;

    public ApplicationException(ErrorStatus errorStatus, String message) {
        this.errorStatus = errorStatus;
        this.message = message;
    }
    public ApplicationException(ErrorStatus errorStatus, String message, Exception originalException) {
            this.errorStatus = errorStatus;
            this.message = message;
            this.originalException = originalException;

    }
}
