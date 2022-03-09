package com.console.consoledrawingapp.shapes;

import com.console.consoledrawingapp.commands.Command;

/**
 * Shape factory return the corresponding shape object based on what command user inputs
 */
public class ShapeFactory {

    public static Shape getShape(Command command) {
        return command.getShape();
    }
}
