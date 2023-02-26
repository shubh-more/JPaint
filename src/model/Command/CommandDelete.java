package model.Command;

import model.DeleteShape;
import model.MovementAlert;
import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;

import java.util.Stack;

public class CommandDelete implements ICommand {

    ShapeList shapeList;
    MovementAlert movementAlert;
    Stack<Stack<IShape>> myUndoRedoDeleteList;
    DeleteShape deleteShape;

    public CommandDelete(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    public void run() {
        movementAlert = new MovementAlert();
        myUndoRedoDeleteList = shapeList.getUndoRedoDeleteList();
        deleteShape = new DeleteShape(shapeList);
        deleteShape.delete();
        CommandMemory.add(this);
    }

    @Override
    public void undo() {
        deleteShape.deleteShapeUndo();
        movementAlert.updateCurrentObserver(shapeList);
    }

    @Override
    public void redo() {
        deleteShape.delete();
    }
}
