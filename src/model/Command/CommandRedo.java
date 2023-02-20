package model.Command;

import model.interfaces.ICommand;

public class CommandRedo implements ICommand {
    @Override
    public void run() {

    }

    @Override
    public void undo() { CommandMemory.undo();

    }

    @Override
    public void redo() {
        CommandMemory.redo();
    }
}
