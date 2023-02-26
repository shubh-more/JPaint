package model;

import model.interfaces.IShape;

import java.util.Stack;

/**
 * This is Observer Pattern It used by SelectCommand to addObserver and used by MoveCommand to
 * update new coordinate to all observers
 */
public class MovementAlert {

    private Stack<IShape> observers;

    public void addObserver(ShapeList shapeList, DrawingPoint drawingPoint) {
        CollisionDetection collisionDetection = new CollisionDetection(shapeList, drawingPoint);
        collisionDetection.addSelectShape();
    }

    public void addMovement(DrawingPoint drawingPoint, ShapeList shapeList) {
        shapeList.getMovementList().add(drawingPoint);
        observers = shapeList.getSelectList().lastElement();
        notifyAllObservers(drawingPoint, shapeList);
    }

    public void undoMove(ShapeList shapeList) {
        if (shapeList.getMovementList().isEmpty()) {
            return;
        }
        DrawingPoint drawingPoint = shapeList.getMovementList().lastElement().switchPoint();
        shapeList.getUndoRedoMovementList().add(shapeList.getMovementList().pop());
        observers = shapeList.getSelectList().lastElement();
        notifyAllObservers(drawingPoint, shapeList);
    }

    public void redoMove(ShapeList shapeList) {
        if (shapeList.getUndoRedoMovementList().isEmpty()) {
            return;
        }
        DrawingPoint drawingPoint = shapeList.getUndoRedoMovementList().lastElement();
        shapeList.getMovementList().add(shapeList.getUndoRedoMovementList().pop());
        observers = shapeList.getSelectList().lastElement();
        notifyAllObservers(drawingPoint, shapeList);
    }

    private void notifyAllObservers(DrawingPoint drawingPoint, ShapeList shapeList) {
        shapeList.getShapeList().forEach(observer -> observer.clear());
        observers.forEach(observer -> observer.update(drawingPoint));
//        shapeList.getShapeList().forEach(shape -> shape.draw());
        shapeList.getShapeList().forEach(observer -> observer.draw());
        for (IShape observer : shapeList.getSelectList().lastElement()) {
            OutlineDecorator outline = new OutlineDecorator();
            outline.draw(observer);
        }
    }

    public void updateCurrentObserver(ShapeList shapeList) {
        shapeList.getShapeList().forEach(observer -> observer.clear());
        shapeList.getShapeList().forEach(observer -> observer.draw());
        for (IShape observer : shapeList.getSelectList().lastElement()) {
            OutlineDecorator outline = new OutlineDecorator();
            outline.draw(observer);
        }
    }
}
