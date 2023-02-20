package model;

import model.Command.CommandMemory;
import model.interfaces.ICommand;
import model.interfaces.IShape;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

import java.util.Stack;

public class CreateShape implements ICommand {

    /*
    class to create shape through shape factory, and implement icommand it is able
    to do undo/redo the shape.
     */
    private PaintCanvasBase paintCanvas;
    private Shape shape;
    private ShapeList shapeList;

    public CreateShape(PaintCanvas paintCanvas, Shape shape, ShapeList shapeList) {
        this.paintCanvas = paintCanvas;
        this.shape = shape;
        this.shapeList = shapeList;
    }

    /*
    When we start run this class, it will push the new shape into ShapeList
    same time, we push our command to CommandMemory
     */
    @Override
    public void run() {
        ShapeFactory shapeFactory = new ShapeFactory();
        IShape newShape = shapeFactory.getShape(shape);
        shapeList.addShape(newShape);
        CommandMemory.add(this);
    }

    /*
    Undo just pop last shape from shapelist and add it to undoredolist
    Before we do that, we clear the shape on canvas.
     */
    @Override
    public void undo() {
        Stack<IShape> myShapeList = shapeList.getShapeList();
        Stack<IShape> myUndoRedoShapeList = shapeList.getUndoRedoShapeList();
        if (myShapeList.isEmpty()) {
            return;
        }
        myShapeList.lastElement().clear(paintCanvas.getGraphics2D());
        myUndoRedoShapeList.add(myShapeList.pop());

    }

    /*
    Redo is same as undo, we pop shape from undoRedo list and add it to shapeList, after that redraw
    this shape on canvas
     */
    @Override
    public void redo() {
        Stack<IShape> myShapeList = shapeList.getShapeList();
        Stack<IShape> myUndoRedoShapeList = shapeList.getUndoRedoShapeList();

        if (myUndoRedoShapeList.isEmpty()) {
            return;
        }
        shapeList.addShape(myUndoRedoShapeList.pop());

    }
}