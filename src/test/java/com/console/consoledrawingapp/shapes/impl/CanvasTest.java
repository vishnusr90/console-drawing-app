package com.console.consoledrawingapp.shapes.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CanvasTest {
    
    private Canvas canvas;

    @BeforeEach
    public void init() {
        canvas = new Canvas(20, 4);
    }

    @Test
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
}
