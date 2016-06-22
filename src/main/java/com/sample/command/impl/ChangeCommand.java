package com.sample.command.impl;

import com.sample.model.CashRegister;
import com.sample.command.Command;
import com.rocketmiles.sample.exception.BaseException;
import com.sample.exception.InvalidAmountException;
import com.sample.exception.InvalidInputException;
import com.sample.exception.NoChangeException;
import com.sample.command.CommandFactory;
import com.sample.command.CommandType;

import static com.sample.command.CommandFactory.createCommand;

public class ChangeCommand implements Command {

    @Override
    public void execute(String[] input, CashRegister cash) throws BaseException {
        try {
            int value = Integer.parseInt(input[1]);
            if (input.length > 2) throw new Exception();
            CashRegister result = cash.processChange(value);

            CommandFactory.createCommand(CommandType.SHOW).execute(input, result);

        } catch (InvalidAmountException | NoChangeException e) {
            throw e;
        } catch (Exception e) {
            throw new InvalidInputException();
        }
    }

}