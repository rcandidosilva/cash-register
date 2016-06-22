package com.sample.command.impl;

import com.sample.command.Command;
import com.sample.command.CommandFactory;
import com.sample.command.CommandType;
import com.sample.exception.InvalidArgumentException;
import com.sample.exception.InvalidInputException;
import com.sample.model.CashRegister;

/**
 * Represents the PUT command to be processed by the application
 */
public class PutCommand implements Command {

    @Override
    public String execute(CashRegister cash, String... input) throws Exception {
        try {

            int value20 = Integer.parseInt(input[0]);
            int value10 = Integer.parseInt(input[1]);
            int value5 = Integer.parseInt(input[2]);
            int value2 = Integer.parseInt(input[3]);
            int value1 = Integer.parseInt(input[4]);

            cash.add(value20, value10, value5, value2, value1);

            return CommandFactory.createCommand(CommandType.SHOW).execute(cash, input);

        } catch (InvalidArgumentException e) {
            throw e;

        } catch (Exception e) {
            throw new InvalidInputException();
        }
    }

}