package com.spaceshipdealership.model.exceptions;

public class StaffRemovalException extends RuntimeException {
    public StaffRemovalException() {
        super("Cannot remove this staff member. (Staff member cannot remove self)");
    }
}
