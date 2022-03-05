package com.console.consoledrawingapp.commands.impl;

import java.util.Scanner;

import com.console.consoledrawingapp.commands.Command;

public class QuitCommand implements Command {

    Scanner sc;

    public QuitCommand(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void execute() {
        sc.close();
        System.exit(0);
    }
    
}
