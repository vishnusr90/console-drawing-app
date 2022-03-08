package com.console.consoledrawingapp.shapes.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.console.consoledrawingapp.exception.InvalidShapeException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("test valid line creation")
    public void testValidLine() {
        Line line = new Line(1, 2, 6, 2);
        assertTrue(line.isValidShape());
    }

    @Test
    @DisplayName("test invalid line creation")
    public void testInvalidShapeExcpetion() {
        Exception exception = assertThrows(InvalidShapeException.class, () -> {
            new Line(1, 2, -6, 2);
        });
        assertEquals("Invalid coordinates for line !", exception.getMessage());
    }
}
