package model.Command;

import model.interfaces.ICommand;

import java.util.Stack;

public class CommandMemory {
    private static final Stack<ICommand> undoStackMemory = new Stack<>();
    private static final Stack<ICommand> redoStackMemory = new Stack<>();

    public static void add(ICommand cmd) {
        undoStackMemory.push(cmd);
        redoStackMemory.clear();
    }

    public static boolean undo() {
        boolean result = !undoStackMemory.empty();
        if (result) {
            ICommand c = undoStackMemory.pop();
            redoStackMemory.push(c);
            c.undo();
        }
        return result;
    }

    public static boolean redo() {
        boolean result = !redoStackMemory.empty();
        if (result) {
            ICommand c = redoStackMemory.pop();
            undoStackMemory.push(c);
            c.redo();
        }
        return result;
    }
}
