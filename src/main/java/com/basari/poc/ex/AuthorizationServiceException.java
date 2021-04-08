package com.basari.poc.ex;

public class AuthorizationServiceException extends RuntimeException {

    public AuthorizationServiceException() {
    }

    public AuthorizationServiceException(String message) {
        super(message);
    }

    public AuthorizationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationServiceException(Throwable cause) {
        super(cause);
    }

    public AuthorizationServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
