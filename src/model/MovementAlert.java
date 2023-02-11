package model;

import model.interfaces.IMovementObserver;

import java.util.Stack;

/**
 * I have used the Observer Pattern
 * USed to CommandSelect to addObserver and used by CommandMove to update new coordinate to all observers
 */
public class MovementAlert {

    private Stack<IMovementObserver> observers;

    public void addObserver(ShapeList shapeList, DrawingPoint drawingPoint) {
        model.CollisionDetection collisionDetection = new model.CollisionDetection(shapeList, drawingPoint);
        collisionDetection.addSelectShape();
    }

    public void addMovement(DrawingPoint drawingPoint, ShapeList shapeList) {
        shapeList.getMovementList().add(drawingPoint);
        observers = shapeList.getSelectList().lastElement();
        notifyAllObservers(drawingPoint, shapeList);
    }

    public void undoMove(ShapeList shapeList) {
        DrawingPoint drawingPoint = shapeList.getMovementList().lastElement().switchPoint();
        shapeList.getUndoRedoMovementList().add(shapeList.getMovementList().pop());
        observers = shapeList.getSelectList().lastElement();
        notifyAllObservers(drawingPoint, shapeList);
    }

    public void redoMove(ShapeList shapeList) {
        DrawingPoint drawingPoint = shapeList.getUndoRedoMovementList().lastElement().switchPoint();
        shapeList.getMovementList().add(shapeList.getUndoRedoMovementList().pop());
        observers = shapeList.getSelectList().lastElement();
        notifyAllObservers(drawingPoint, shapeList);
    }

    private void notifyAllObservers(DrawingPoint drawingPoint, ShapeList shapeList) {
        observers.forEach(observer -> observer.clear());
        observers.forEach(observer -> observer.update(drawingPoint));
        shapeList.getShapeList().forEach(shape -> shape.draw());
    }
}
