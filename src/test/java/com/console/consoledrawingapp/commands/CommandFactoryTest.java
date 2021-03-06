package com.console.consoledrawingapp.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Scanner;

import com.console.consoledrawingapp.commands.impl.CanvasCommand;
import com.console.consoledrawingapp.commands.impl.FillAreaCommand;
import com.console.consoledrawingapp.commands.impl.LineCommand;
import com.console.consoledrawingapp.commands.impl.RectangleCommand;
import com.console.consoledrawingapp.exception.InvalidCommandException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommandFactoryTest {
    private Scanner sc;
    
    @BeforeEach
    public void init() {
        sc = new Scanner(System.in);
    }

    @Test
    @DisplayName("test canvas command with correct parameters")
    public void testCanvasCommandWithCorrectCommands() {
        String commands = "C 20 4";
        Command command = CommandFactory.getCommand(commands, sc);
        assertTrue(command instanceof CanvasCommand);
        assertEquals(20, ((CanvasCommand) command).getWidth());
        assertEquals(4, ((CanvasCommand) command).getHeight());
    }

    @Test
    @DisplayName("test canvas command with incorrect parameters")
    public void testCanvasCommandWithIncorrect() {
        String commands = "C 20";
        Exception exception = assertThrows(InvalidCommandException.class, () -> {
            CommandFactory.getCommand(commands, sc);
        });
        assertEquals("Please enter correct parameters for creating canvas command !", exception.getMessage());
    }

    @Test
    @DisplayName("test line command with correct parameters")
    public void testLineCommandWithCorrectCommands() {
        String commands = "L 1 2 6 2";
        Command command = CommandFactory.getCommand(commands, sc);
        assertTrue(command instanceof LineCommand);
        assertEquals(1, ((LineCommand) command).getX1());
        assertEquals(2, ((LineCommand) command).getY1());
        assertEquals(6, ((LineCommand) command).getX2());
        assertEquals(2, ((LineCommand) command).getY2());
    }

    @Test
    @DisplayName("test line command with incorrect parameters")
    public void testLineCommandIncorrect() {
        String commands = "L 20";
        Exception exception = assertThrows(InvalidCommandException.class, () -> {
            CommandFactory.getCommand(commands, sc);
        });
        assertEquals("Please enter correct parameters for add a line command !", exception.getMessage());
    }


    @Test
    @DisplayName("test rectangle command with correct parameters")
    public void testRectangleCommandWithCorrectCommands() {
        String commands = "R 14 1 18 3";
        Command command = CommandFactory.getCommand(commands, sc);
        assertTrue(command instanceof RectangleCommand);
        assertEquals(14, ((RectangleCommand) command).getX1());
        assertEquals(1, ((RectangleCommand) command).getY1());
        assertEquals(18, ((RectangleCommand) command).getX2());
        assertEquals(3, ((RectangleCommand) command).getY2());
    }

    @Test
    @DisplayName("test rectangle command with incorrect parameters")
    public void testRectangleCommandWithIncorrectCommands() {
        String commands = "R";
        Exception exception = assertThrows(InvalidCommandException.class, () -> {
            CommandFactory.getCommand(commands, sc);
        });
        assertEquals("Please enter correct parameters for adding a rectangle command !", exception.getMessage());
    }

    @Test
    @DisplayName("test fill area command with correct parameters")
    public void testFillAreaCommandWithCorrectCommands() {
        String commands = "B 10 3 o";
        Command command = CommandFactory.getCommand(commands, sc);
        assertTrue(command instanceof FillAreaCommand);
        assertEquals(10, ((FillAreaCommand) command).getX());
        assertEquals(3, ((FillAreaCommand) command).getY());
        assertEquals('o', ((FillAreaCommand) command).getColor());
    }

    @Test
    @DisplayName("test fill area command with incorrect parameters")
    public void testFillAreaCommandWithIncorrectCommands() {
        String commands = "B";
        Exception exception = assertThrows(InvalidCommandException.class, () -> {
            CommandFactory.getCommand(commands, sc);
        });
        assertEquals("Please enter correct parameters for filling area command !", exception.getMessage());
    }
}
