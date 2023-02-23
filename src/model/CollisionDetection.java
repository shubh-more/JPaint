package model;


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
        Stack<IShape> lastList = new Stack<>();
        for (IShape shape: shapeList.getShapeList()) {
            int Bx = shape.getShape().getDrawingPoint().getLeftCornerX();
            int By = shape.getShape().getDrawingPoint().getLeftCornerY();
            int Bw = shape.getShape().getDrawingPoint().getWidth();
            int Bh = shape.getShape().getDrawingPoint().getHeight();
            if (Bx + Bw > Ax && By + Bh > Ay && Ax + Aw > Bx && Ay + Ah > By) {
                lastList.add(shape);
            }
        }
        shapeList.getSelectList().add(lastList);
    }
}
