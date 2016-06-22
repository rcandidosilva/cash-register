package com.sample.command.impl;

import com.sample.model.CashRegister;
import com.sample.model.CashNote;
import com.sample.command.Command;

public class ShowCommand implements Command {

    @Override
    public void execute(String[] input, CashRegister cash) {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        sb.append(cash.getTotal());
        sb.append(" ");
        for (CashNote m : cash.getNotes()) {
            sb.append(m.getQuantity()).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}