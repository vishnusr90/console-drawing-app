package com.console.consoledrawingapp;

import java.util.Scanner;

import javax.management.InstanceNotFoundException;

import com.console.consoledrawingapp.commands.Command;
import com.console.consoledrawingapp.commands.impl.CanvasCommand;
import com.console.consoledrawingapp.commands.impl.FillAreaCommand;
import com.console.consoledrawingapp.commands.impl.LineCommand;
import com.console.consoledrawingapp.commands.impl.QuitCommand;
import com.console.consoledrawingapp.commands.impl.RectangleCommand;
import com.console.consoledrawingapp.exception.InvalidCommandException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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
				} catch (InvalidCommandException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
		
	}

	public void processCommand(Command command) {

		if (command instanceof QuitCommand) {
			QuitCommand quitCommand = (QuitCommand) command;
			quitCommand.execute();
		} else if (command instanceof CanvasCommand) {
			CanvasCommand canvasCommad = (CanvasCommand) command;
			this.canvas = new Canvas(canvasCommad.getWidth(), canvasCommad.getHeight());
			this.canvas.createCanvas();
		} else if (command instanceof LineCommand) {
			LineCommand lineCommand = (LineCommand) command;
			int x1 = lineCommand.getX1();
			int x2 = lineCommand.getX2();
			int y1 = lineCommand.getY1();
			int y2 = lineCommand.getY2();
			this.canvas.addLine(x1, y1, x2, y2);
			this.canvas.printCanvas();
		} else if (command instanceof RectangleCommand) {
			RectangleCommand rectCommand = (RectangleCommand) command;
			this.canvas.addRectangle(rectCommand);
			this.canvas.printCanvas();
		} else if (command instanceof FillAreaCommand) {
			FillAreaCommand areaCommand = (FillAreaCommand) command;
			int x = areaCommand.getX();
			int y = areaCommand.getY();
			char c = areaCommand.getColor();
			this.canvas.fillCanvas(x, y, c);
		}
	} 
}
