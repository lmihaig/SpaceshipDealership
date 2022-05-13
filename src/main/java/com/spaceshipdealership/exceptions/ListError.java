package com.spaceshipdealership.exceptions;

public class ListError extends RuntimeException {
    public ListError(String obj) {
        super(String.format("No %s to list.", obj));
    }
}
