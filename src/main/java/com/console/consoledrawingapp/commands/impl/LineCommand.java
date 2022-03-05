package com.console.consoledrawingapp.commands.impl;

import com.console.consoledrawingapp.commands.Command;

public class LineCommand implements Command {

    String[] commands;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    
    public LineCommand(String[] remainingCommands) {
        this.commands = remainingCommands;
        this.x1 = Integer.parseInt(remainingCommands[0]);
        this.y1 = Integer.parseInt(remainingCommands[1]);
        this.x2 = Integer.parseInt(remainingCommands[2]);
        this.y2 = Integer.parseInt(remainingCommands[3]);
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    @Override
    public void execute() {
        int x1 = Integer.parseInt(this.commands[0]);
        int y1 = Integer.parseInt(this.commands[1]);

        int x2 = Integer.parseInt(this.commands[2]);
        int y2 = Integer.parseInt(this.commands[3]);
    }
    
}
