package model.Command;

import model.MovementAlert;
import model.ShapeList;
import model.DrawingPoint;
import model.interfaces.ICommand;
import model.interfaces.IStrategy;

/**
 * The main purpose of CommandMove is to update new coordinate to all observers
 */
public class CommandMove implements IStrategy, ICommand {

    private DrawingPoint drawingPoint;
    private ShapeList shapeList;

    MovementAlert movementAlert;
    public CommandMove(DrawingPoint drawingPoint, ShapeList shapeList) {
        this.drawingPoint = drawingPoint;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        movementAlert = new MovementAlert();
        movementAlert.addMovement(drawingPoint, shapeList);
        CommandMemory.add(this);
        System.out.println("Shapes are moving");
    }

    @Override
    public void undo() {
        if (shapeList.getMovementList().isEmpty()) {
            return;
        }
        movementAlert.undoMove(shapeList);
    }

    @Override
    public void redo() {
        if (shapeList.getUndoRedoMovementList().isEmpty()) {
            return;
        }
        movementAlert.redoMove(shapeList);
    }
}
