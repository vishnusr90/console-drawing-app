package com.console.consoledrawingapp.shapes;

import com.console.consoledrawingapp.commands.Command;

public class ShapeFactory {

    public static Shape getShape(Command command) {
        return command.getShape();
    }
}
