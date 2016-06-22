package com.sample.command.impl;

import com.sample.model.CashRegister;
import com.sample.command.Command;

/**
 * Represents the QUIT command to be processed by the application
 */
public class QuitCommand implements Command {

    @Override
    public String execute(CashRegister cashMachine, String... input) {
        System.out.println("Bye");
        System.exit(1);
        return null;
    }

}