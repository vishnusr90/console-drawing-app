package com.console.consoledrawingapp.shapes.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.console.consoledrawingapp.exception.InvalidShapeException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    @Test
    @DisplayName("test valid rectangle creation")
    public void testValidRectangle() {
        Rectangle rectangle = new Rectangle(1, 2, 6, 2);
        assertTrue(rectangle.isValidShape());
    }

    @Test
    @DisplayName("test invalid rectangle creation")
    public void testInvalidShapeExcpetion() {
        Exception exception = assertThrows(InvalidShapeException.class, () -> {
            new Rectangle(1, -2, -6, 2);
        });
        assertEquals("Invalid coordinates for rectangle !", exception.getMessage());
    }
}
