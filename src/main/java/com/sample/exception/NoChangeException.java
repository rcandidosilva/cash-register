package com.sample.exception;

public class NoChangeException extends Exception {

    public NoChangeException() {
        super("No change can be made.");
    }

}
