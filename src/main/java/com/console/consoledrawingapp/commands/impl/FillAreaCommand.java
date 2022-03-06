package com.console.consoledrawingapp.commands.impl;

import com.console.consoledrawingapp.commands.Command;
import com.console.consoledrawingapp.exception.InvalidCommandException;
import com.console.consoledrawingapp.shapes.Shape;
import com.console.consoledrawingapp.shapes.impl.BucketFill;

public class FillAreaCommand implements Command {
    private int x;
    private int y;
    private char color;

    public FillAreaCommand(String[] remainingCommands) {
        if (!isValidCommand(remainingCommands)) {
            throw new InvalidCommandException("Please enter correct parameters for filling area command !");
        }
        this.x = Integer.parseInt(remainingCommands[0]);
        this.y = Integer.parseInt(remainingCommands[1]);
        this.color = remainingCommands[2].toCharArray()[0];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getColor() {
        return color;
    }

    @Override
    public boolean isValidCommand(String[] commands) {
        return commands.length == 3 
            && commands[0] != " " 
            && commands[1] != " " 
            && commands[2] != " ";
    }

    @Override
    public Shape getShape() {
        return new BucketFill(x, y, color);
    }
}
