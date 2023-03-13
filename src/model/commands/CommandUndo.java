package model.commands;

import model.interfaces.InterfaceCommand;

public class CommandUndo implements InterfaceCommand {
    @Override
    public void run() {
        CommandStoreMemory.undo();
    }
}
