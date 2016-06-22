package com.sample.exception;

public class WrongCommandException extends Exception {

    public WrongCommandException() {
        super("Wrong command informed.");
    }

}
