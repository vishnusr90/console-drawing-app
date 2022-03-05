package com.console.consoledrawingapp.commands.impl;

import com.console.consoledrawingapp.commands.Command;

public class FillAreaCommand implements Command {

    private String[] commands;
    private int x;
    private int y;
    private char color;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getColor() {
        return color;
    }

    public FillAreaCommand(String[] remainingCommands) {
        this.commands = remainingCommands;
        this.x = Integer.parseInt(remainingCommands[0]);
        this.y = Integer.parseInt(remainingCommands[1]);
        this.color = remainingCommands[2].toCharArray()[0];
    }

    @Override
    public void execute() {
        int x = Integer.parseInt(this.commands[0]);
        int y = Integer.parseInt(this.commands[1]);
        char color = this.commands[2].charAt(0);
    }
    
}
