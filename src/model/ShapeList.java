package model;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
import model.interfaces.IShape;
=======
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae

<<<<<<< HEAD
import model.interfaces.IShape;
=======
import javax.sound.sampled.Clip;
import java.awt.datatransfer.Clipboard;
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
import java.util.Stack;

/**
 * This is MVC class, it is data model for storing undo, redo shape(s). This class initiate at the
 * beginning of the program so other classes are able to access it.
 */
public class ShapeList {

    private Stack<IShape> shapeList = new Stack<>();
    private Stack<IShape> undoRedoShapeList = new Stack<>();
<<<<<<< HEAD
    private Stack<Stack<IShape>> selectList = new Stack<>();
    private Stack<Stack<IShape>> undoRedoSelectList = new Stack<>();
=======
<<<<<<< HEAD
    private Stack<Stack<IShape>> selectList = new Stack<>();
    private Stack<Stack<IShape>> undoRedoSelectList = new Stack<>();
=======
<<<<<<< HEAD
    private Stack<Stack<IShape>> selectList = new Stack<>();
    private Stack<IShape> clipboard =new Stack<>();

    private Stack<Stack<IShape>> undoRedoSelectList = new Stack<>();
=======
    private Stack<Stack<IMovementObserver>> selectList = new Stack<>();
    private Stack<IShape> clipboard =new Stack<>();

    private Stack<Stack<IMovementObserver>> undoRedoSelectList = new Stack<>();
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
    private Stack<DrawingPoint> movementList = new Stack<>();
    private Stack<DrawingPoint> undoRedoMovementList = new Stack<>();
    private Stack<IShape> clipboard = new Stack<>();
    private Stack<Integer> pasteList = new Stack<>();
    private Stack<Stack<IShape>> undoRedoPasteItem = new Stack<>();
    private Stack<Stack<IShape>> undoRedoDeleteList = new Stack<>();
<<<<<<< HEAD
=======

    private Stack<Stack<IShape>> undoRedoPasteItem = new Stack<>();


>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9

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

    public Stack<Stack<IShape>> getSelectList() {
        return selectList;
    }

    public Stack<Stack<IShape>> getUndoRedoSelectList() {
        return undoRedoSelectList;
    }

    public Stack<DrawingPoint > getMovementList() {
        return movementList;
    }

    public Stack<DrawingPoint> getUndoRedoMovementList() {
        return undoRedoMovementList;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======

>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
    public Stack<IShape> getClipboard() {
        return clipboard;
    }

    public Stack<Integer> getPasteList() {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
        return pasteList;
    }

    public Stack<Stack<IShape>> getUndoRedoPasteItem() {
        return undoRedoPasteItem;
    }

    public Stack<Stack<IShape>> getUndoRedoDeleteList() {
        return undoRedoDeleteList;
    }
<<<<<<< HEAD
=======
=======
        return getPasteList();
    }

    public Stack<Stack<IShape>> getUndoRedoPasteItem() {
       return undoRedoPasteItem;
    }




>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
}
