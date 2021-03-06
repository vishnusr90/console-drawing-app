package com.console.consoledrawingapp.commands.impl;

import com.console.consoledrawingapp.commands.Command;
import com.console.consoledrawingapp.exception.InvalidCommandException;
import com.console.consoledrawingapp.shapes.Shape;
import com.console.consoledrawingapp.shapes.impl.Line;

public class LineCommand implements Command {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    
    public LineCommand(String[] remainingCommands) {
        if (!isValidCommand(remainingCommands)) {
            throw new InvalidCommandException("Please enter correct parameters for add a line command !");
        }
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
    public boolean isValidCommand(String[] commands) {
        return commands.length == 4 
            && commands[0] != " " 
            && commands[1] != " " 
            && commands[2] != " " 
            && commands[3] != " "; 
    }

    @Override
    public Shape getShape() {
        return new Line(x1, y1, x2, y2);
    }
}
