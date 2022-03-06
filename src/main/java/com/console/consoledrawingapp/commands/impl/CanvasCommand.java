package com.console.consoledrawingapp.commands.impl;

import com.console.consoledrawingapp.commands.Command;
import com.console.consoledrawingapp.exception.InvalidCommandException;
import com.console.consoledrawingapp.shapes.Shape;
import com.console.consoledrawingapp.shapes.impl.Canvas;

public class CanvasCommand implements Command {
    private int width;
    private int height;

    public CanvasCommand() { }
    
    public CanvasCommand(String[] remainingCommands) {
        if (!isValidCommand(remainingCommands)) {
            throw new InvalidCommandException("Please enter correct parameters for creating canvas command !");
        }
        this.width = Integer.parseInt(remainingCommands[0]);
        this.height = Integer.parseInt(remainingCommands[1]);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean isValidCommand(String[] commands) {
        return commands.length == 2 
            && commands[0] != " " 
            && commands[1] != " ";  
    }

    @Override
    public Shape getShape() {
        return new Canvas(width, height);
    }
}
