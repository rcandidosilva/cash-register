package com.sample.exception;

/**
 * Wrong command informed application exception
 */
public class WrongCommandException extends Exception {

    public WrongCommandException() {
        super("Wrong command informed.");
    }

}
