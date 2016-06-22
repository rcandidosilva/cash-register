package com.sample.command.impl;

import com.sample.command.Command;
import com.sample.command.CommandFactory;
import com.sample.command.CommandType;
import com.sample.exception.InvalidAmountException;
import com.sample.exception.InvalidInputException;
import com.sample.exception.NoChangeException;
import com.sample.model.CashRegister;

/**
 * Represents the CHANGE command to be processed by the application
 */
public class ChangeCommand implements Command {

    @Override
    public String execute(CashRegister cash, String... input) throws Exception {
        try {
            int value = Integer.parseInt(input[0]);
            if (input.length > 1) throw new Exception();
            CashRegister result = cash.processChange(value);

            return CommandFactory.createCommand(CommandType.SHOW).execute(result, input);

        } catch (InvalidAmountException | NoChangeException e) {
            throw e;
        } catch (Exception e) {
            throw new InvalidInputException();
        }
    }

}