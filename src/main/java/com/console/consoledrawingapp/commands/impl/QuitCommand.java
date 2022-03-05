package com.console.consoledrawingapp.commands.impl;

import java.util.Scanner;

import com.console.consoledrawingapp.commands.Command;
import com.console.consoledrawingapp.exception.InvalidCommandException;

public class QuitCommand implements Command {
    private Scanner sc;

    public QuitCommand(Scanner sc) {
        this.sc = sc;
        if (!isValidCommand(null)) {
            throw new InvalidCommandException("Please enter correct parameters for filling area command !");
        }
    }

    public void execute() {
        this.sc.close();
        System.exit(0);
    }

    @Override
    public boolean isValidCommand(String[] commands) {
        return sc != null;
    }
}
