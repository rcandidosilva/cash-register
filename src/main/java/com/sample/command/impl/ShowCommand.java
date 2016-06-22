package com.sample.command.impl;

import com.sample.model.CashRegister;
import com.sample.model.CashNote;
import com.sample.command.Command;

/**
 * Represents the SHOW command to be processed by the application
 */
public class ShowCommand implements Command {

    @Override
    public String execute(CashRegister cash, String... input) {
        StringBuilder sb = new StringBuilder();
        sb.append("$").append(cash.getTotal()).append(" ");
        for (CashNote m : cash.getNotes()) {
            sb.append(m.getQuantity()).append(" ");
        }
        return sb.toString().trim();
    }

}