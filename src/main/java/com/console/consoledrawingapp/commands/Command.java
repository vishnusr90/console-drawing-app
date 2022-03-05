package com.console.consoledrawingapp.commands;

public interface Command {
    public void execute();
    public boolean isValidCommand(String[] commands);
}
