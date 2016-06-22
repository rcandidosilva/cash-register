package com.sample.exception;

/**
 * Invalid cash amount application exception
 */
public class InvalidAmountException extends Exception {

    public InvalidAmountException() {
        super("Insufficient cash available.");
    }

}
