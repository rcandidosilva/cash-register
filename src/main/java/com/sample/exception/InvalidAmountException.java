package com.sample.exception;

public class InvalidAmountException extends Exception {

    public InvalidAmountException() {
        super("Insufficient fund.");
    }

}
