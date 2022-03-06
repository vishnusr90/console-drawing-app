package com.console.consoledrawingapp.commands.impl;

import java.util.Scanner;

public class QuitCommand {
    private Scanner sc;

    public QuitCommand(Scanner sc) {
        this.sc = sc;
    }

    public void execute() {
        this.sc.close();
        System.exit(0);
    }
}
