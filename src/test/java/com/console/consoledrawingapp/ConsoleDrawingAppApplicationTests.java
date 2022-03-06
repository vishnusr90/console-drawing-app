package com.console.consoledrawingapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.console.consoledrawingapp.commands.Command;
import com.console.consoledrawingapp.commands.impl.LineCommand;
import com.console.consoledrawingapp.exception.CanvasNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// @SpringBootTest
class ConsoleDrawingAppApplicationTests {

	private ConsoleDrawingAppApplication app;
	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void init() {
		app = new ConsoleDrawingAppApplication();
	}

	@Test
	public void testCreatingShapeWithoutCanvas() {
		String[] commands = {"1", "2", "3", "4"};
		Command command = new LineCommand(commands);
		Exception exception = assertThrows(CanvasNotFoundException.class, () -> {
			app.processCommand(command);
		});
		assertEquals("Please create the canvas first !", exception.getMessage());
	}
}
