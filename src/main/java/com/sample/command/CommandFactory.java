package com.sample.command;

import com.sample.exception.WrongCommandException;

public class CommandFactory {

    public static Command createCommand(CommandType type) throws WrongCommandException {
        try {
            return type.getCommandClass().newInstance();
        } catch (Exception ex) {
            throw new WrongCommandException();
        }
    }

    public static Command createCommand(String name) throws WrongCommandException {
        CommandType type = CommandType.find(name);
        if (type != null) {
            return createCommand(type);
        } else {
            throw new WrongCommandException();
        }
    }

}