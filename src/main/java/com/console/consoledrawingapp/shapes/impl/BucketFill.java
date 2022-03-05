package com.console.consoledrawingapp.shapes.impl;

import com.console.consoledrawingapp.shapes.Shape;

public class BucketFill implements Shape {
    private int x;
    private int y;
    private char color;

    public BucketFill(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getColor() {
        return color;
    }

    @Override
    public boolean isValidShape() {
        return x >=1 
            && y >= 1 
            && Character.isLetter(color);
    }
}
