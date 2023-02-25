package model;

import model.interfaces.IShape;

import java.util.Stack;

/**
 * This is Observer Pattern It used by SelectCommand to addObserver and used by MoveCommand to
 * update new coordinate to all observers
 */
public class MovementAlert {

    //private Stack<IShape> observers;
    private Stack<IShape> observers;

    public void addObserver(ShapeList shapeList, DrawingPoint DrawingPoint) {
        CollisionDetection collisionDetection = new CollisionDetection(shapeList, DrawingPoint);
        collisionDetection.addSelectShape();
    }

    public void addMovement(DrawingPoint DrawingPoint, ShapeList shapeList) {
        shapeList.getMovementList().add(DrawingPoint);
      //  observers = shapeList.getSelectList().lastElement();
        observers = (Stack<IShape>) shapeList.getShapeList().lastElement();
        notifyAllObservers(DrawingPoint, shapeList);
    }

    public void undoMove(ShapeList shapeList) {
        if (shapeList.getMovementList().isEmpty()) {
            return;
        }
        DrawingPoint DrawingPoint = shapeList.getMovementList().lastElement().switchPoint();
        shapeList.getUndoRedoMovementList().add(shapeList.getMovementList().pop());
        observers = (Stack<IShape>) shapeList.getShapeList().lastElement();
        notifyAllObservers(DrawingPoint, shapeList);
    }

    public void redoMove(ShapeList shapeList) {
        if (shapeList.getUndoRedoMovementList().isEmpty()) {
            return;
        }
        DrawingPoint DrawingPoint = shapeList.getUndoRedoMovementList().lastElement();
        shapeList.getMovementList().add(shapeList.getUndoRedoMovementList().pop());
        observers = (Stack<IShape>) shapeList.getShapeList().lastElement();
        notifyAllObservers(DrawingPoint, shapeList);
    }

    private void notifyAllObservers(DrawingPoint DrawingPoint, ShapeList shapeList) {
        shapeList.getShapeList().forEach(observer -> observer.clear());
        observers.forEach(observer -> observer.update(DrawingPoint));
        shapeList.getShapeList().forEach(observer -> observer.draw());
      //  for (IShape observer : shapeList.getSelectList().lastElement())
        for (IShape observer : (Stack<IShape>) shapeList.getShapeList().lastElement()){
            OutlineDecorator outline = new OutlineDecorator();
            outline.draw(observer);
        }
    }

    public void updateCurrentObserver(ShapeList shapeList) {
        shapeList.getShapeList().forEach(observer -> observer.clear());
        shapeList.getShapeList().forEach(observer -> observer.draw());
        for (IShape observer : (Stack<IShape>) shapeList.getShapeList().lastElement()) {
            OutlineDecorator outline = new OutlineDecorator();
            outline.draw(observer);
        }
    }
}
