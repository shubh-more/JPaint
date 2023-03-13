package model.commands;

import model.interfaces.InterfaceCommand;


public class CommandRedo implements InterfaceCommand {
    @Override
    public void run()  {
        CommandStoreMemory.redo();
    }

}
