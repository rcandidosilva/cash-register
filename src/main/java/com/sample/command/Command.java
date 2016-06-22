package com.sample.command;

import com.sample.model.CashRegister;

/**
 * Command interface to define all commands processed by the application
 */
public interface Command {

    /**
     * Abstract execute command to be implemented by different commands.
     *
     * @param input
     * @param cash
     * @throws Exception
     */
    void execute(String[] input, CashRegister cash) throws Exception;

}