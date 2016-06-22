package com.sample.command.impl;

import com.sample.command.Command;
import com.rocketmiles.sample.exception.BaseException;
import com.sample.exception.InvalidArgumentException;
import com.sample.exception.InvalidInputException;
import com.sample.model.CashRegister;
import com.sample.command.CommandFactory;
import com.sample.command.CommandType;

import static com.sample.command.CommandFactory.createCommand;

public class PutCommand implements Command {

    @Override
    public void execute(String[] input, CashRegister cash) throws BaseException {
        try {

            int value20 = Integer.parseInt(input[1]);
            int value10 = Integer.parseInt(input[2]);
            int value5 = Integer.parseInt(input[3]);
            int value2 = Integer.parseInt(input[4]);
            int value1 = Integer.parseInt(input[5]);

            cash.add(value20, value10, value5, value2, value1);

            CommandFactory.createCommand(CommandType.SHOW).execute(input, cash);

        } catch (InvalidArgumentException e) {
            throw e;

        } catch (Exception e) {
            throw new InvalidInputException();
        }
    }

}