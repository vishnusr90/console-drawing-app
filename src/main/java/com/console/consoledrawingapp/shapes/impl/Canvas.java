package com.console.consoledrawingapp.shapes.impl;

import com.console.consoledrawingapp.exception.InvalidShapeException;
import com.console.consoledrawingapp.shapes.Shape;

public class Canvas implements Shape {
    private char[][] canvas;
    private int width;
    private int height;
    private final char HORIZONTAL = '-';
    private final char VERTICAL = '|';
    private final char LINE = 'x';
    private final char EMPTY_SPACE = ' ';

    public Canvas() { }
    
    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvas = new char[height+2][width+2];
        if (!isValidShape()) {
            throw new InvalidShapeException("Invalid coordinates for canvas !");
        }
    }

    public int getX() {
        return width;
    }

    public int getY() {
        return height;
    }

    public void process(Shape shape) {
        if (shape instanceof Line) {
            Line line = (Line) shape;
            addLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            addRectangle(rectangle.getX1(), rectangle.getY1(), rectangle.getX2(), rectangle.getY2());
        } else if (shape instanceof BucketFill) {
            BucketFill bucket = (BucketFill) shape;
            fillCanvas(bucket.getX(), bucket.getY(), bucket.getColor());
        }
        this.printCanvas();
    }

    public char[][] createCanvas() {

        for(int i=0;i<this.width+2;i++) {
            canvas[0][i] = HORIZONTAL;
        } 
        
        for(int j=1;j<(this.height+1);j++) {
            canvas[j][0] = VERTICAL;

            for(int m=1;m<this.width+2;m++) {
                canvas[j][m] = EMPTY_SPACE;
            }
            canvas[j][this.width+1] = VERTICAL;
        }

        for(int i=0;i<this.width+2;i++) {
            canvas[this.height+1][i] = HORIZONTAL;
        }

        printCanvas();
        return canvas;
    }

    public char[][] addLine(int x1, int y1, int x2, int y2) {
        if (!isValidLine(x1, y1, x2, y2)) {
            throw new InvalidShapeException("Please enter correct coordinates !");
        }
        for(int i=y1; i<=y2;i++) {
            for(int j =x1;j<=x2;j++) {
                canvas[i][j] = LINE;
            }
        }
        return canvas;
    }

    public void addRectangle(int x1, int y1, int x2, int y2) {
        addLine(x1, y1, x2, y1);
        addLine(x1, y1, x1, y2);
        addLine(x2, y1, x2, y2);
        addLine(x1, y2, x2, y2);
    }

    public void fillCanvas(int x, int y, char color) {
        if (!isValidAreaToFill(x, y)) {
            return;
        }

        if (this.canvas[y][x] == ' ') {
            this.canvas[y][x] = color;
        }

        // Breadth first search
        fillCanvas(x+1, y, color);
        fillCanvas(x-1, y, color);
        fillCanvas(x, y+1, color);
        fillCanvas(x, y-1, color);
    }
 
    public String printCanvas() {
        int m = canvas.length;
        int n = canvas[0].length;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(canvas[i][j]);
                sb.append(canvas[i][j]);
            }
            sb.append("\n");
            System.out.println("");
        }
        return sb.toString();
    }

    public boolean isValidAreaToFill(int x, int y) {
        return x >=1 && x < (this.width+2)
                && y >=1 && y < (this.height+2) 
                && this.canvas[y][x] == ' ';
    }

    public boolean isValidLine(int x1, int y1, int x2, int y2) {
        return x1 >= 1
            && x1 < (this.width+2)
            && x2 >=1 
            && x2 < (this.width+2)
            && y1 >= 1
            && y1 < (this.height+2)
            && y2 >=1 
            && y2 < (this.height+2);
    }

    @Override
    public boolean isValidShape() {
        return width >= 1 && height >= 1;
    }
}
