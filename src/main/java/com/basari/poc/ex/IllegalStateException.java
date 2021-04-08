package com.basari.poc.ex;

public class IllegalStateException extends java.lang.RuntimeException {

    public IllegalStateException() {
    }

    public IllegalStateException(String message) {
        super(message);
    }

    public IllegalStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalStateException(Throwable cause) {
        super(cause);
    }

    public IllegalStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
