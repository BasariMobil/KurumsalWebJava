package com.basari.poc.ex;

public abstract class EntityNotFoundException extends NotFoundException {

    public EntityNotFoundException(Class<?> entityType, String message) {
        super(String.format("%s not found, %s", entityType.getSimpleName(), message));
    }

    public EntityNotFoundException(Class<?> entityType, String message, Throwable cause) {
        super(String.format("%s not found, %s", entityType.getSimpleName(), message), cause);
    }
}
