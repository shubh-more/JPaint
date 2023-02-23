package model;

import model.interfaces.IMovementObserver;
import model.interfaces.IShape;

import javax.sound.sampled.Clip;
import java.awt.datatransfer.Clipboard;
import java.util.Stack;

/**
 *     This is MVC class, it is data model for storing undo, redo shape(s).
 *     This class initiate at the beginning of the program so other classes are able to access it.
 */
public class ShapeList{
    private Stack<IShape> shapeList = new Stack<>();
    private Stack<IShape> undoRedoShapeList = new Stack<>();
    private Stack<Stack<IMovementObserver>> selectList = new Stack<>();
    private Stack<IShape> clipboard =new Stack<>();

    private Stack<Stack<IMovementObserver>> undoRedoSelectList = new Stack<>();
    private Stack<DrawingPoint> movementList = new Stack<>();
    private Stack<DrawingPoint> undoRedoMovementList = new Stack<>();

    private Stack<Stack<IShape>> undoRedoPasteItem = new Stack<>();



    public void addShape(IShape iShape) {
        shapeList.add(iShape);
        iShape.draw();
    }

    public Stack<IShape> getShapeList() {
        return shapeList;
    }

    public Stack<IShape> getUndoRedoShapeList() {
        return undoRedoShapeList;
    }

    public Stack<Stack<IMovementObserver>> getSelectList() {
        return selectList;
    }

    public Stack<Stack<IMovementObserver>> getUndoRedoSelectList() {
        return undoRedoSelectList;
    }

    public Stack<DrawingPoint> getMovementList() {
        return movementList;
    }

    public Stack<DrawingPoint> getUndoRedoMovementList() {
        return undoRedoMovementList;
    }


    public Stack<IShape> getClipboard() {
        return clipboard;
    }

    public Stack<Integer> getPasteList() {
        return getPasteList();
    }

    public Stack<Stack<IShape>> getUndoRedoPasteItem() {
       return undoRedoPasteItem;
    }




}
