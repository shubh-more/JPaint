package model;

import model.interfaces.IShape;

import java.util.Stack;

/**
 * This is Observer Pattern It used by SelectCommand to addObserver and used by MoveCommand to
 * update new coordinate to all observers
 */
public class MovementAlert {

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b
    private Stack<IShape> observers;

    public void addObserver(ShapeList shapeList, DrawingPoint drawingPoint) {
        CollisionDetection collisionDetection = new CollisionDetection(shapeList, drawingPoint);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
    //private Stack<IShape> observers;
=======
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
    private Stack<IShape> observers;

    public void addObserver(ShapeList shapeList, DrawingPoint DrawingPoint) {
        CollisionDetection collisionDetection = new CollisionDetection(shapeList, DrawingPoint);
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b
        DrawingPoint drawingPoint = shapeList.getMovementList().lastElement().switchPoint();
=======
        DrawingPoint DrawingPoint = shapeList.getMovementList().lastElement().switchPoint();
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
        shapeList.getUndoRedoMovementList().add(shapeList.getMovementList().pop());
<<<<<<< HEAD
        observers = (Stack<IShape>) shapeList.getShapeList().lastElement();
=======
        observers = shapeList.getSelectList().lastElement();
<<<<<<< HEAD
        notifyAllObservers(drawingPoint, shapeList);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
        notifyAllObservers(DrawingPoint, shapeList);
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b
    }

    public void redoMove(ShapeList shapeList) {
        if (shapeList.getUndoRedoMovementList().isEmpty()) {
            return;
        }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b
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
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
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
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b
            OutlineDecorator outline = new OutlineDecorator();
            outline.draw(observer);
        }
    }

    public void updateCurrentObserver(ShapeList shapeList) {
        shapeList.getShapeList().forEach(observer -> observer.clear());
        shapeList.getShapeList().forEach(observer -> observer.draw());
<<<<<<< HEAD
        for (IShape observer : shapeList.getSelectList().lastElement()) {
=======
<<<<<<< HEAD
        for (IShape observer : shapeList.getSelectList().lastElement()) {
=======
<<<<<<< HEAD
        for (IShape observer : shapeList.getSelectList().lastElement()) {
=======
<<<<<<< HEAD
        for (IShape observer : shapeList.getSelectList().lastElement()) {
=======
<<<<<<< HEAD
        for (IShape observer : (Stack<IShape>) shapeList.getShapeList().lastElement()) {
=======
        for (IShape observer : shapeList.getSelectList().lastElement()) {
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b
            OutlineDecorator outline = new OutlineDecorator();
            outline.draw(observer);
        }
    }
}
