package com.spaceshipdealership.model.exceptions;

public class ListErrorException extends RuntimeException {
    public ListErrorException(String obj) {
        super(String.format("No %s to list.", obj));
    }
}
