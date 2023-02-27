package model;

import model.interfaces.IShape;

import java.awt.*;

/**
 * It implement IShape so it has functions of drawing shape and erasing shape, also it implement
 * IMovementObserver, so this shape can keep updating its coordinate through movement change
 */
public class Ellipse implements IShape {

    Shape shape;
    private Graphics2D g;

    public Ellipse(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        g = shape.getPaintCanvas().getGraphics2D();
        g.setColor(shape.getPrimaryColor());
        if (shape.getShadingType() == ShapeShadingType.FILLED_IN) {
            g.fillOval(shape.getDrawingPoint().getLeftCornerX(), shape.getDrawingPoint().getLeftCornerY(),
                    shape.getDrawingPoint().getWidth(), shape.getDrawingPoint().getHeight());
        } else if (shape.getShadingType() == ShapeShadingType.OUTLINE) {
            g.drawOval(shape.getDrawingPoint().getLeftCornerX(), shape.getDrawingPoint().getLeftCornerY(),
                    shape.getDrawingPoint().getWidth(), shape.getDrawingPoint().getHeight());
        } else {
            g.fillOval(shape.getDrawingPoint().getLeftCornerX(), shape.getDrawingPoint().getLeftCornerY(),
                    shape.getDrawingPoint().getWidth(), shape.getDrawingPoint().getHeight());
            g.setColor(shape.getSecondaryColor());
            g.drawOval(shape.getDrawingPoint().getLeftCornerX(), shape.getDrawingPoint().getLeftCornerY(),
                    shape.getDrawingPoint().getWidth(), shape.getDrawingPoint().getHeight());
        }
    }

    @Override
    public void clear() {
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1,
                new float[]{9}, 0);
        g.setStroke(stroke);
        g.setColor(Color.WHITE);
        g.fillOval(shape.getDrawingPoint().getMinXY().getX() - 5, shape.getDrawingPoint().getMinXY().getY() - 5,
                shape.getDrawingPoint().getWidth() + 10, shape.getDrawingPoint().getHeight() + 10);
        g.drawOval(shape.getDrawingPoint().getMinXY().getX() - 5, shape.getDrawingPoint().getMinXY().getY() - 5,
                shape.getDrawingPoint().getWidth() + 10, shape.getDrawingPoint().getHeight() + 10);
    }

    @Override
    public void repaint(Graphics g) {
        g.setColor(shape.getPrimaryColor());
        if (shape.getShadingType() == ShapeShadingType.FILLED_IN) {
            g.fillOval(shape.getDrawingPoint().getLeftCornerX(), shape.getDrawingPoint().getLeftCornerY(),
                    shape.getDrawingPoint().getWidth(), shape.getDrawingPoint().getHeight());
        } else if (shape.getShadingType() == ShapeShadingType.OUTLINE) {
            g.drawOval(shape.getDrawingPoint().getLeftCornerX(), shape.getDrawingPoint().getLeftCornerY(),
                    shape.getDrawingPoint().getWidth(), shape.getDrawingPoint().getHeight());
        } else {
            g.fillOval(shape.getDrawingPoint().getLeftCornerX(), shape.getDrawingPoint().getLeftCornerY(),
                    shape.getDrawingPoint().getWidth(), shape.getDrawingPoint().getHeight());
            g.setColor(shape.getSecondaryColor());
            g.drawOval(shape.getDrawingPoint().getLeftCornerX(), shape.getDrawingPoint().getLeftCornerY(),
                    shape.getDrawingPoint().getWidth(), shape.getDrawingPoint().getHeight());
        }
    }

    @Override
    public Shape getShape() {
        return shape;
    }


    @Override
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
