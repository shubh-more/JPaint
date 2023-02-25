package model.Command;

import model.*;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import model.interfaces.IStrategy;

import java.util.Stack;


public class CommandSelect implements IStrategy, ICommand {

    private DrawingPoint drawingPoint;
    private ShapeList shapeList;
    private Stack<Stack<IShape>> mySelectList;
    private Stack<Stack<IShape>> myUndoRedoList;

    public CommandSelect(DrawingPoint drawingPoint, ShapeList shapeList) {
        this.drawingPoint = drawingPoint;
        this.shapeList = shapeList;
        System.out.println("Shape selected");
    }

    @Override
    public void run() {
        mySelectList = shapeList.getSelectList();
        myUndoRedoList = shapeList.getUndoRedoSelectList();
        MovementAlert movementAlert = new MovementAlert();
        movementAlert.addObserver(shapeList, drawingPoint);
        CommandMemory.add(this);
    }

    @Override
    public void undo() {
        if (mySelectList.isEmpty()) {
            return;
        }
        myUndoRedoList.add(mySelectList.pop());
    }

    @Override
    public void redo() {
        if (myUndoRedoList.isEmpty()) {
            return;
        }
        mySelectList.add(myUndoRedoList.pop());
    }
}
