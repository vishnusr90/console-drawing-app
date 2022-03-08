package com.console.consoledrawingapp.shapes.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.console.consoledrawingapp.exception.InvalidShapeException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BucketFillTest {
    
    @Test
    @DisplayName("test bucket fill creation with correct commands")
    public void testValidLine() {
        BucketFill bucket = new BucketFill(1, 2, 'c');
        assertTrue(bucket.isValidShape());
    }

    @Test
    @DisplayName("test bucket fill creation with incorrect commands")
    public void testInvalidShapeExcpetion() {
        Exception exception = assertThrows(InvalidShapeException.class, () -> {
            new BucketFill(1, -1, '1');
        });
        assertEquals("Invalid parameters for bucket fill !", exception.getMessage());
    }
}
