package com.console.consoledrawingapp;

import java.util.Scanner;

import com.console.consoledrawingapp.commands.Command;
import com.console.consoledrawingapp.commands.CommandFactory;
import com.console.consoledrawingapp.commands.impl.CanvasCommand;
import com.console.consoledrawingapp.exception.CanvasNotFoundException;
import com.console.consoledrawingapp.exception.OutsideBoundaryException;
import com.console.consoledrawingapp.exception.InvalidCommandException;
import com.console.consoledrawingapp.exception.InvalidShapeException;
import com.console.consoledrawingapp.shapes.Shape;
import com.console.consoledrawingapp.shapes.ShapeFactory;
import com.console.consoledrawingapp.shapes.impl.Canvas;

// @SpringBootApplication
public class ConsoleDrawingAppApplication {

	private Canvas canvas;
	public static void main(String[] args) {
		// SpringApplication.run(ConsoleDrawingAppApplication.class, args);
		ConsoleDrawingAppApplication app = new ConsoleDrawingAppApplication();
		try (Scanner sc = new Scanner(System.in)) {
			while(true) {
				System.out.println("Enter you command");
				String userInput = sc.nextLine();
				try {
					Command command = CommandFactory.getCommand(userInput, sc);
					app.processCommand(command);
				} catch (InvalidCommandException | OutsideBoundaryException | CanvasNotFoundException | InvalidShapeException ex) {
					System.out.println(ex.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public void processCommand(Command command) {
		if (command instanceof CanvasCommand) {
			Shape shape = ShapeFactory.getShape(command);
			this.canvas = (Canvas) shape;
			this.canvas.createCanvas();
		} else {
			if (this.canvas == null) {
				throw new CanvasNotFoundException("Please create the canvas first !");
			}
			Shape shape = ShapeFactory.getShape(command);
			this.canvas.process(shape);
		}
	}
}
