package com.console.consoledrawingapp.shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.console.consoledrawingapp.commands.impl.CanvasCommand;
import com.console.consoledrawingapp.commands.impl.FillAreaCommand;
import com.console.consoledrawingapp.commands.impl.LineCommand;
import com.console.consoledrawingapp.commands.impl.RectangleCommand;
import com.console.consoledrawingapp.exception.InvalidShapeException;
import com.console.consoledrawingapp.shapes.impl.BucketFill;
import com.console.consoledrawingapp.shapes.impl.Canvas;
import com.console.consoledrawingapp.shapes.impl.Line;
import com.console.consoledrawingapp.shapes.impl.Rectangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShapeFactoryTest {

    @Test
    @DisplayName("test canvas creation with correct commands")
    public void testCanvasShapeWhenCorrectInstancePassed() {
        String[] commands = {"1", "2"};
        CanvasCommand command = new CanvasCommand(commands);
        Shape shape = ShapeFactory.getShape(command);
        assertTrue(shape instanceof Canvas);
        assertEquals(1, ((Canvas) shape).getX());
        assertEquals(2, ((Canvas) shape).getY());
    }

    @Test
    @DisplayName("test line creation with correct commands")
    public void testLineShapeWhenCorrectInstancePassed() {
        String[] commands = {"1", "2", "1", "4"};
        LineCommand command = new LineCommand(commands);
        Shape shape = ShapeFactory.getShape(command);
        assertTrue(shape instanceof Line);
        assertEquals(1, ((Line) shape).getX1());
        assertEquals(2, ((Line) shape).getY1());
        assertEquals(1, ((Line) shape).getX2());
        assertEquals(4, ((Line) shape).getY2());
    }

    @Test
    @DisplayName("test rectangle creation with correct commands")
    public void testRectangleShapeWhenCorrectInstancePassed() {
        String[] commands = {"1", "2", "3", "4"};
        RectangleCommand command = new RectangleCommand(commands);
        Shape shape = ShapeFactory.getShape(command);
        assertTrue(shape instanceof Rectangle);
        assertEquals(1, ((Rectangle) shape).getX1());
        assertEquals(2, ((Rectangle) shape).getY1());
        assertEquals(3, ((Rectangle) shape).getX2());
        assertEquals(4, ((Rectangle) shape).getY2());
    }

    @Test
    @DisplayName("test fill bucket operation with correct commands")
    public void testBucketFillShapeWhenCorrectInstancePassed() {
        String[] commands = {"10", "2", "c"};
        FillAreaCommand command = new FillAreaCommand(commands);
        Shape shape = ShapeFactory.getShape(command);
        assertTrue(shape instanceof BucketFill);
        assertEquals(10, ((BucketFill) shape).getX());
        assertEquals(2, ((BucketFill) shape).getY());
        assertEquals('c', ((BucketFill) shape).getColor());
    }
    
}
