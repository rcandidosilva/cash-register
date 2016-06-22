package com.sample.command.impl;

import com.sample.model.CashRegister;
import com.sample.command.Command;

public class QuitCommand implements Command {

    @Override
    public void execute(String[] input, CashRegister cashMachine) {
        System.out.println("Bye");
        System.exit(1);
    }

}