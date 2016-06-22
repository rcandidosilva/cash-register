package com.sample;

import com.sample.command.Command;
import com.sample.command.CommandFactory;
import com.sample.exception.InvalidInputException;
import com.sample.exception.WrongCommandException;
import com.sample.model.CashRegister;

import java.util.Arrays;
import java.util.Scanner;

public class App {

    /**
     * This is the main application function
     *
     * @param args
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("ready");
            Scanner reader = new Scanner(System.in);
            String input = reader.next();
            String[] arguments = input.split(" ");
            String actionCommand = arguments[0].toLowerCase();
            try {
                if (input.contains("-")) throw new InvalidInputException();
                try {
                    // create and execute the specific command informed.
                    Command command = CommandFactory.createCommand(actionCommand);
                    String message = command.execute(CashRegister.getInstance(),
                            Arrays.copyOfRange(arguments, 1, arguments.length));
                    System.out.println(message);
                } catch (WrongCommandException ex) {
                    System.out.println(ex.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
