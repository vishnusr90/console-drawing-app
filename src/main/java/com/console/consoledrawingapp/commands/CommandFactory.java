package com.console.consoledrawingapp.commands;

import java.util.Arrays;
import java.util.Scanner;

import com.console.consoledrawingapp.commands.impl.CanvasCommand;
import com.console.consoledrawingapp.commands.impl.LineCommand;
import com.console.consoledrawingapp.commands.impl.RectangleCommand;
import com.console.consoledrawingapp.commands.impl.FillAreaCommand;
import com.console.consoledrawingapp.commands.impl.QuitCommand;
import com.console.consoledrawingapp.exception.InvalidCommandException;

public class CommandFactory {
    
    public static Command getCommand(String userInput, Scanner sc) {
        String[] input = userInput.split(" ");
        String mainCommand = input[0].toLowerCase();
        String[] remainingCommands = Arrays.copyOfRange(input, 1, input.length);

        switch(mainCommand) {
            case "c": return new CanvasCommand(remainingCommands);
            case "l": return new LineCommand(remainingCommands);
            case "r": return new RectangleCommand(remainingCommands);
            case "b": return new FillAreaCommand(remainingCommands);
            case "q": new QuitCommand(sc).execute();
            default:
                throw new InvalidCommandException("Please enter correct commands !");
        }
    }
}
