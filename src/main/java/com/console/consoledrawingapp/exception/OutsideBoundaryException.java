package com.console.consoledrawingapp.exception;

public class OutsideBoundaryException extends RuntimeException {
    public OutsideBoundaryException(String message) {
        super(message);
    }
}
