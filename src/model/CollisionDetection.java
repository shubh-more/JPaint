package model;


import model.interfaces.IShape;

import java.util.Stack;

/**
 * This is not precise detection because I tried to treat all shapes as single type (rectangle in
 * this case), probably will replace it with better algorithm later.
 * <p>
 * Algorithm to detect two rectangle collision from stackoverflow below
 * https://stackoverflow.com/questions/31022269/collision-detection-between-two-rectangles-in-java
 * bool isIntersect( int Ax, int Ay, int Aw, int Ah, int Bx, int By, int Bw, int Bh) { return Bx +
 * Bw > Ax && By + Bh > Ay && Ax + Aw > Bx && Ay + Ah > By; }
 */
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
        for (IShape shape : shapeList.getShapeList()) {
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
