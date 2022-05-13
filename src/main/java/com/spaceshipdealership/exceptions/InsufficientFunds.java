package com.spaceshipdealership.exceptions;

public class InsufficientFunds extends RuntimeException {
    public InsufficientFunds() {
        super("Insufficient funds for this transaction.");
    }
}
