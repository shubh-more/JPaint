package model;

import model.interfaces.IShape;

import java.util.Stack;

/**
 * This is Observer Pattern It used by SelectCommand to addObserver and used by MoveCommand to
 * update new coordinate to all observers
 */
public class MovementAlert {

<<<<<<< HEAD
    //private Stack<IShape> observers;
=======
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
    private Stack<IShape> observers;

    public void addObserver(ShapeList shapeList, DrawingPoint DrawingPoint) {
        CollisionDetection collisionDetection = new CollisionDetection(shapeList, DrawingPoint);
        collisionDetection.addSelectShape();
    }

    public void addMovement(DrawingPoint DrawingPoint, ShapeList shapeList) {
        shapeList.getMovementList().add(DrawingPoint);
<<<<<<< HEAD
      //  observers = shapeList.getSelectList().lastElement();
        observers = (Stack<IShape>) shapeList.getShapeList().lastElement();
=======
        observers = shapeList.getSelectList().lastElement();
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
        notifyAllObservers(DrawingPoint, shapeList);
    }

    public void undoMove(ShapeList shapeList) {
        if (shapeList.getMovementList().isEmpty()) {
            return;
        }
        DrawingPoint DrawingPoint = shapeList.getMovementList().lastElement().switchPoint();
        shapeList.getUndoRedoMovementList().add(shapeList.getMovementList().pop());
<<<<<<< HEAD
        observers = (Stack<IShape>) shapeList.getShapeList().lastElement();
=======
        observers = shapeList.getSelectList().lastElement();
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
        notifyAllObservers(DrawingPoint, shapeList);
    }

    public void redoMove(ShapeList shapeList) {
        if (shapeList.getUndoRedoMovementList().isEmpty()) {
            return;
        }
        DrawingPoint DrawingPoint = shapeList.getUndoRedoMovementList().lastElement();
        shapeList.getMovementList().add(shapeList.getUndoRedoMovementList().pop());
<<<<<<< HEAD
        observers = (Stack<IShape>) shapeList.getShapeList().lastElement();
=======
        observers = shapeList.getSelectList().lastElement();
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
        notifyAllObservers(DrawingPoint, shapeList);
    }

    private void notifyAllObservers(DrawingPoint DrawingPoint, ShapeList shapeList) {
        shapeList.getShapeList().forEach(observer -> observer.clear());
        observers.forEach(observer -> observer.update(DrawingPoint));
<<<<<<< HEAD
        shapeList.getShapeList().forEach(observer -> observer.draw());
      //  for (IShape observer : shapeList.getSelectList().lastElement())
        for (IShape observer : (Stack<IShape>) shapeList.getShapeList().lastElement()){
=======
//        shapeList.getShapeList().forEach(shape -> shape.draw());
        shapeList.getShapeList().forEach(observer -> observer.draw());
        for (IShape observer : shapeList.getSelectList().lastElement()) {
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
            OutlineDecorator outline = new OutlineDecorator();
            outline.draw(observer);
        }
    }

    public void updateCurrentObserver(ShapeList shapeList) {
        shapeList.getShapeList().forEach(observer -> observer.clear());
        shapeList.getShapeList().forEach(observer -> observer.draw());
<<<<<<< HEAD
        for (IShape observer : (Stack<IShape>) shapeList.getShapeList().lastElement()) {
=======
        for (IShape observer : shapeList.getSelectList().lastElement()) {
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
            OutlineDecorator outline = new OutlineDecorator();
            outline.draw(observer);
        }
    }
}
