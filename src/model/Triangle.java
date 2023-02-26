package model;


import model.interfaces.IShape;

import java.awt.*;
/**
 * It implement IShape so it has functions of drawing shape and erasing shape, also it implement IMovementObserver,
 * so this shape can keep updating its coordinate through movement change
 */
public class  Triangle implements IShape {
    Shape shape;
    private Graphics2D g;
    private Coordinate thirdPoint;
    private int[] xPoints;
    private int[] yPoints;

    public Triangle(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        g = shape.getPaintCanvas().getGraphics2D();
        thirdPoint = new Coordinate(shape.getDrawingPoint().getStartPoint().getX(),
                shape.getDrawingPoint().getEndPoint().getY());
        xPoints = new int[]{shape.getDrawingPoint().getStartPoint().getX(),
                shape.getDrawingPoint().getEndPoint().getX(), thirdPoint.getX()};
        yPoints = new int[]{shape.getDrawingPoint().getStartPoint().getY(),
                shape.getDrawingPoint().getEndPoint().getY(), thirdPoint.getY()};
        g.setColor(shape.getPrimaryColor());
        if (shape.getShadingType() == ShapeShadingType.FILLED_IN) {
            g.fillPolygon(xPoints, yPoints, 3);
        } else if (shape.getShadingType() == ShapeShadingType.OUTLINE) {
            g.drawPolygon(xPoints, yPoints, 3);
        } else {
            g.fillPolygon(xPoints, yPoints, 3);
            g.setColor(shape.getSecondaryColor());
            g.drawPolygon(xPoints, yPoints, 3);
        }
    }

    @Override
    public void clear() {
        g.setColor(Color.WHITE);
        g.fillPolygon(xPoints, yPoints,3);
        g.drawPolygon(xPoints, yPoints,3);
    }

    public void repaint(Graphics g) {
        thirdPoint = new Coordinate(shape.getDrawingPoint().getStartPoint().getX(),
                shape.getDrawingPoint().getEndPoint().getY());
        xPoints = new int[]{shape.getDrawingPoint().getStartPoint().getX(),
                shape.getDrawingPoint().getEndPoint().getX(), thirdPoint.getX()};
        yPoints = new int[]{shape.getDrawingPoint().getStartPoint().getY(),
                shape.getDrawingPoint().getEndPoint().getY(), thirdPoint.getY()};
        g.setColor(shape.getPrimaryColor());
        if (shape.getShadingType() == ShapeShadingType.FILLED_IN) {
            g.fillPolygon(xPoints, yPoints, 3);
        } else if (shape.getShadingType() == ShapeShadingType.OUTLINE) {
            g.drawPolygon(xPoints, yPoints, 3);
        } else {
            g.fillPolygon(xPoints, yPoints, 3);
            g.setColor(shape.getSecondaryColor());
            g.drawPolygon(xPoints, yPoints, 3);
        }
    }

    @Override
    public Shape getShape() {
        return shape;
    }


    public void update(DrawingPoint DrawingPoint) {
        shape.getDrawingPoint().getStartPoint().setX(
                shape.getDrawingPoint().getStartPoint().getX() - DrawingPoint.getStartPoint().getX()
                        + DrawingPoint.getEndPoint().getX());
        shape.getDrawingPoint().getStartPoint().setY(
                shape.getDrawingPoint().getStartPoint().getY() - DrawingPoint.getStartPoint().getY()
                        + DrawingPoint.getEndPoint().getY());
        shape.getDrawingPoint().getEndPoint().setX(
                shape.getDrawingPoint().getEndPoint().getX() - DrawingPoint.getStartPoint().getX()
                        + DrawingPoint.getEndPoint().getX());
        shape.getDrawingPoint().getEndPoint().setY(
                shape.getDrawingPoint().getEndPoint().getY() - DrawingPoint.getStartPoint().getY()
                        + DrawingPoint.getEndPoint().getY());
    }
}
