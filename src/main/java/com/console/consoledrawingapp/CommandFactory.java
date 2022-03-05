package com.console.consoledrawingapp;

import java.util.Arrays;
import java.util.Scanner;

import com.console.consoledrawingapp.commands.Command;
import com.console.consoledrawingapp.commands.impl.CanvasCommand;
import com.console.consoledrawingapp.commands.impl.LineCommand;
import com.console.consoledrawingapp.commands.impl.RectangleCommand;
import com.console.consoledrawingapp.commands.impl.FillAreaCommand;
import com.console.consoledrawingapp.commands.impl.QuitCommand;
import com.console.consoledrawingapp.exception.InvalidCommandException;

public class CommandFactory {
    
    public static Command getCommand(String userInput, Scanner sc) {
        String[] input = userInput.split(" ");
        String mainCommand = input[0];
        String[] remainingCommands = Arrays.copyOfRange(input, 1, input.length);

        Arrays.stream(remainingCommands).forEach(i -> System.out.println(i));

        switch(mainCommand) {
            case "C": return new CanvasCommand(remainingCommands);
            case "L": return new LineCommand(remainingCommands);
            case "R": return new RectangleCommand(remainingCommands);
            case "B": return new FillAreaCommand(remainingCommands);
            case "Q": return new QuitCommand(sc);
            default:
                throw new InvalidCommandException("Please enter correct commands !");
        }
    }
}
