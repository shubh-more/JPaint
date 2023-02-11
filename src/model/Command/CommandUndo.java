package model.Command;

import model.interfaces.ICommand;

public class CommandUndo implements ICommand {
    @Override
    public void run() {

    }

    @Override
    public void undo() {
        CommandMemory.undo();
    }

    @Override
    public void redo() {

    }
}
