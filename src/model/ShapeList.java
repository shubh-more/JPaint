package model;

import model.interfaces.IShape;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

import java.util.Stack;

public class ShapeList{

    /*
    Shape list is the class mainly for storing undo, redo shape(s) information.
    This class initiate at the beginning of the program so other classes are able to access it.
     */

    private PaintCanvas paintCanvas;
    private Stack<IShape> shapeList = new Stack<>();
    private Stack<IShape> undoRedoShapeList = new Stack<>();

    public ShapeList(PaintCanvas paintCanvas) {
        this.paintCanvas = paintCanvas;
    }

    public void addShape(IShape iShape) {
        shapeList.add(iShape);
        iShape.draw(paintCanvas.getGraphics2D());
    }


    public Stack<IShape> getShapeList() {
        return shapeList;
    }

    public Stack<IShape> getUndoRedoShapeList() {
        return undoRedoShapeList;
    }
}