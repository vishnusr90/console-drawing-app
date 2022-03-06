package com.console.consoledrawingapp.commands;

import com.console.consoledrawingapp.shapes.Shape;

public interface Command {
    public Shape getShape();
    public boolean isValidCommand(String[] commands);
}
