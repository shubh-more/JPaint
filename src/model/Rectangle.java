package model;

import model.interfaces.IMovementObserver;
import model.interfaces.IShape;

import java.awt.*;

public class Rectangle implements IShape, IMovementObserver {
    Shape shape;
    private Graphics2D g;
    private int leftCornerX;
    private int leftCornerY;
    private int width;
    private int height;

    public Rectangle(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        g = shape.getPaintCanvas().getGraphics2D();
        leftCornerX = shape.getTwoPoint().getLeftCornerX();
        leftCornerY = shape.getTwoPoint().getLeftCornerY();
        width = shape.getTwoPoint().getWidth();
        height = shape.getTwoPoint().getHeight();
        g.setColor(shape.getPrimaryColor());
        if (shape.getShadingType() == ShapeShadingType.FILLED_IN) {
            g.fillRect(leftCornerX, leftCornerY, width, height);
        } else if (shape.getShadingType() == ShapeShadingType.OUTLINE) {
            g.drawRect(leftCornerX, leftCornerY, width, height);
        } else {
            g.fillRect(leftCornerX, leftCornerY, width, height);
            g.setColor(shape.getSecondaryColor());
            g.drawRect(leftCornerX, leftCornerY, width, height);
        }
    }

    @Override
    public void clear() {
        g.setColor(Color.WHITE);
        g.fillRect(leftCornerX, leftCornerY, width, height);
        g.drawRect(leftCornerX, leftCornerY, width, height);
    }

    public int getLeftCornerX() {
        return leftCornerX;
    }

    public int getLeftCornerY() {
        return leftCornerY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public void clear(Graphics2D g) {

    }

    @Override
    public void update(DrawingPoint drawingPoint) {
        shape.getTwoPoint().getStartPoint().setX(shape.getTwoPoint().getStartPoint().getX() - drawingPoint.getStartPoint().getX() + drawingPoint.getEndPoint().getX());
        shape.getTwoPoint().getStartPoint().setY(shape.getTwoPoint().getStartPoint().getY() - drawingPoint.getStartPoint().getY() + drawingPoint.getEndPoint().getY());
        shape.getTwoPoint().getEndPoint().setX(shape.getTwoPoint().getEndPoint().getX() - drawingPoint.getStartPoint().getX() + drawingPoint.getEndPoint().getX());
        shape.getTwoPoint().getEndPoint().setY(shape.getTwoPoint().getEndPoint().getY() - drawingPoint.getStartPoint().getY() + drawingPoint.getEndPoint().getY());
    }
}
