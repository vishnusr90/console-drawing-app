package com.console.consoledrawingapp.shapes.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.console.consoledrawingapp.exception.OutsideBoundaryException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CanvasTest {
    
    private Canvas canvas;

    @BeforeEach
    public void init() {
        canvas = new Canvas(20, 4);
    }

    @Test
    @DisplayName("test canvas creation")
	public void testCreatingCanvas() {
		char[][] testCanvas = canvas.createCanvas();
        assertEquals(6, testCanvas.length);
        assertEquals(22, testCanvas[0].length);
        String canvasTest = canvas.printCanvas();
        assertEquals("----------------------\n"+
                     "|                    |\n"+
                     "|                    |\n"+
                     "|                    |\n"+
                     "|                    |\n"+
                     "----------------------\n", canvasTest);
	}

    @Test
    @DisplayName("test line creation - 1")
    public void testCreatingLine1() {
        canvas.createCanvas();
        canvas.addLine(1, 2, 6, 2);
        String canvasTest = canvas.printCanvas();
        assertEquals("----------------------\n"+
                     "|                    |\n"+
                     "|xxxxxx              |\n"+
                     "|                    |\n"+
                     "|                    |\n"+
                     "----------------------\n", canvasTest);
    }   
    
    @Test
    @DisplayName("test line creation - 2")
    public void testCreatingLine2() {
        canvas.createCanvas();
        canvas.addLine(6, 3, 6, 4);
        String canvasTest = canvas.printCanvas();
        assertEquals("----------------------\n"+
                     "|                    |\n"+
                     "|                    |\n"+
                     "|     x              |\n"+
                     "|     x              |\n"+
                     "----------------------\n", canvasTest);
    }

    @Test
    @DisplayName("test line creation with reverse- 3")
    public void testCreatingLine3() {
        canvas.createCanvas();
        canvas.addLine(6, 4, 6, 3);
        String canvasTest = canvas.printCanvas();
        assertEquals("----------------------\n"+
                     "|                    |\n"+
                     "|                    |\n"+
                     "|     x              |\n"+
                     "|     x              |\n"+
                     "----------------------\n", canvasTest);
    }

    @Test
    @DisplayName("test rectangle creation")
    public void testCreatingRectangle() {
        canvas.createCanvas();
        canvas.addRectangle(14, 1, 18, 3);
        String canvasTest = canvas.printCanvas();
        assertEquals("----------------------\n"+
                     "|             xxxxx  |\n"+
                     "|             x   x  |\n"+
                     "|             xxxxx  |\n"+
                     "|                    |\n"+
                     "----------------------\n", canvasTest);
    }

    @Test
    @DisplayName("test rectangle creation from reverse direction")
    public void testCreatingRectangleWithReverse() {
        canvas.createCanvas();
        canvas.addRectangle(18, 3, 14, 1);
        String canvasTest = canvas.printCanvas();
        assertEquals("----------------------\n"+
                     "|             xxxxx  |\n"+
                     "|             x   x  |\n"+
                     "|             xxxxx  |\n"+
                     "|                    |\n"+
                     "----------------------\n", canvasTest);
    }

    @Test
    @DisplayName("test bucket fill creation")
    public void testCreatingBucketFill() {
        canvas.createCanvas();
        canvas.addRectangle(14, 1, 18, 3);
        canvas.fillCanvas(10, 3, 'o');
        String canvasTest = canvas.printCanvas();
        assertEquals("----------------------\n"+
                     "|oooooooooooooxxxxxoo|\n"+
                     "|ooooooooooooox   xoo|\n"+
                     "|oooooooooooooxxxxxoo|\n"+
                     "|oooooooooooooooooooo|\n"+
                     "----------------------\n", canvasTest);
    }

    @Test 
    @DisplayName("test when coordinates are not within canvas boundary")
    public void testOutsideBoundaryCoordinates() {
        canvas.createCanvas();
        Exception exception = assertThrows(OutsideBoundaryException.class, () -> {
            canvas.addLine(40, 40, 1, 1);
        });
        assertEquals("Initial coordinates are outside the canvas !", exception.getMessage());
    }
}
