package com.console.consoledrawingapp;

import com.console.consoledrawingapp.commands.Command;
import com.console.consoledrawingapp.commands.impl.RectangleCommand;
import com.console.consoledrawingapp.exception.InvalidBoundaryException;

public class Canvas {

    private char[][] canvas;
    private int width;
    private int height;
    private final char HORIZONTAL = '-';
    private final char VERTICAL = '|';
    private final char LINE = 'x';
    private final char EMPTY_SPACE = ' ';

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvas = new char[height+2][width+2];
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

    public void addLine(int x1, int y1, int x2, int y2) {
        for(int i=y1; i<=y2;i++) {
            for(int j =x1;j<=x2;j++) {
                canvas[i][j] = LINE;
            }
        }
    }

    public void addRectangle(Command command) {
        RectangleCommand rectangle = (RectangleCommand) command;
        int x1 = rectangle.getX1();
        int x2 = rectangle.getX2();
        int y1 = rectangle.getY1();
        int y2 = rectangle.getY2();
        addLine(x1, y1, x2, y1);
        addLine(x1, y1, x1, y2);
        addLine(x2, y1, x2, y2);
        addLine(x1, y2, x2, y2);
    }

    public void fillCanvas(int x, int y, char color) {
        if (!isValidAreaToFill(x, y)) {
            throw new InvalidBoundaryException("Please enter coordinates within canvas boundary to fill");
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
 
    public void printCanvas() {
        int m = canvas.length;
        int n = canvas[0].length;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println("");
        }
    }

    public boolean isValidAreaToFill(int x, int y) {
        return x >=1 && x < this.width+2
                && y >=1 && y < this.height+2 
                && this.canvas[y][x] == ' ';
    }
}
