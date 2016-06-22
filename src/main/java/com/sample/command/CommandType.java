package com.sample.command;

import com.sample.command.impl.*;

public enum CommandType {

    SHOW(ShowCommand.class, "show"),
    PUT(PutCommand.class, "put"),
    TAKE(TakeCommand.class, "take"),
    CHANGE(ChangeCommand.class, "change"),
    QUIT(QuitCommand.class, "quit");

    private Class<? extends Command> commandClass;
    private String name;

    CommandType(Class<? extends Command> commandClass, String name) {
        this.commandClass = commandClass;
        this.name = name;
    }

    public Class<? extends Command> getCommandClass() {
        return commandClass;
    }

    public String getName() {
        return name;
    }

    public static CommandType find(String name) {
        for (CommandType type : values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        return null;
    }
}