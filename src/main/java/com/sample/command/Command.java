package com.sample.command;

import com.sample.model.CashRegister;

/**
 * Command interface to define all commands processed by the application
 */
public interface Command {

    /**
     * Abstract execute command to be implemented by different commands.
     *
     * @param cash
     * @param input
     * @throws Exception
     */
    String execute(CashRegister cash, String... input) throws Exception;

}