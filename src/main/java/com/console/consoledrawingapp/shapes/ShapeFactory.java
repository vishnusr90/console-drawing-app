package com.console.consoledrawingapp.shapes;

import com.console.consoledrawingapp.commands.Command;
import com.console.consoledrawingapp.commands.impl.CanvasCommand;
import com.console.consoledrawingapp.commands.impl.FillAreaCommand;
import com.console.consoledrawingapp.commands.impl.LineCommand;
import com.console.consoledrawingapp.commands.impl.RectangleCommand;
import com.console.consoledrawingapp.exception.InvalidShapeException;
import com.console.consoledrawingapp.shapes.impl.BucketFill;
import com.console.consoledrawingapp.shapes.impl.Canvas;
import com.console.consoledrawingapp.shapes.impl.Line;
import com.console.consoledrawingapp.shapes.impl.Rectangle;

public class ShapeFactory {

    public static Shape getShape(Command command) {
        if (command instanceof CanvasCommand) {
            CanvasCommand canvasCommand = (CanvasCommand) command;
            return new Canvas(canvasCommand.getWidth(), canvasCommand.getHeight());
        } else if (command instanceof LineCommand) {
            LineCommand lineCommand = (LineCommand) command;
            return new Line(lineCommand.getX1(), lineCommand.getY1(), lineCommand.getX2(), lineCommand.getY2());
        } else if (command instanceof RectangleCommand) {
            RectangleCommand rectCommand = (RectangleCommand) command;
            return new Rectangle(rectCommand.getX1(), rectCommand.getY1(), rectCommand.getX2(), rectCommand.getY2());
        } else if (command instanceof FillAreaCommand) {
            FillAreaCommand fillAreaCommand = (FillAreaCommand) command;
            return new BucketFill(fillAreaCommand.getX(), fillAreaCommand.getY(), fillAreaCommand.getColor());
        } 
        throw new InvalidShapeException("Invalid shape encountered  !");
    }
}
