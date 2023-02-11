package model;

import model.interfaces.IMovementObserver;
import model.interfaces.IShape;

import java.util.Stack;

public class CollisionDetection {

    ShapeList shapeList;
    DrawingPoint drawingPoint;

    public CollisionDetection(ShapeList shapeList, DrawingPoint drawingPoint) {
        this.shapeList = shapeList;
        this.drawingPoint = drawingPoint;
    }

    public void addSelectShape() {
        int Ax = drawingPoint.getLeftCornerX();
        int Ay = drawingPoint.getLeftCornerY();
        int Aw = drawingPoint.getWidth();
        int Ah = drawingPoint.getHeight();
        Stack<IMovementObserver> lastList = new Stack<>();
        for (IShape shape: shapeList.getShapeList()) {
            int Bx = shape.getLeftCornerX();
            int By = shape.getLeftCornerY();
            int Bw = shape.getWidth();
            int Bh = shape.getHeight();
            if (Bx + Bw > Ax && By + Bh > Ay && Ax + Aw > Bx && Ay + Ah > By) {
                lastList.add((IMovementObserver) shape);
            }
        }
        shapeList.getSelectList().add(lastList);
    }
}
