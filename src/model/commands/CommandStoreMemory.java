package model.commands;

import model.interfaces.InterfaceUndoRedo;

import java.util.Stack;

public class CommandStoreMemory {
	private static final Stack<InterfaceUndoRedo> memoryofundo = new Stack<InterfaceUndoRedo>();
	private static final Stack<InterfaceUndoRedo> memoryofredo = new Stack<InterfaceUndoRedo>();

	public static void add(InterfaceUndoRedo cmd) {
		memoryofundo.push(cmd);
		memoryofredo.clear();
	}

	public static boolean undo() {
		boolean result = !memoryofundo.empty();
		if (result) {
			InterfaceUndoRedo c = memoryofundo.pop();
			memoryofredo.push(c);
			c.undo();
		}

		return result;
	}

	public static boolean redo() {
		boolean result = !memoryofredo.empty();
		if (result) {
			InterfaceUndoRedo c = memoryofredo.pop();
			memoryofundo.push(c);
			c.redo();
		}
		return result;
	}

}

