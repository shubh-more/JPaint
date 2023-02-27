
package model;

import java.awt.*;

/**
 * This class is to store two start point and end point coordinate and calculate their
 * left corner coordinate width and height
 */
public class DrawingPoint {
    private Coordinate startPoint;
    private Coordinate endPoint;
    private int leftCornerX;
    private int leftCornerY;
    private int width;
    private int height;

    public DrawingPoint(Coordinate startPoint, Coordinate endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Coordinate getStartPoint() {
        return startPoint;
    }

    public Coordinate getEndPoint() {
        return endPoint;
    }

    public int getLeftCornerX() {
        leftCornerX = Math.min(startPoint.getX(), endPoint.getX());
        return leftCornerX;
    }

    public int getLeftCornerY() {
        leftCornerY = Math.min(startPoint.getY(), endPoint.getY());
        return leftCornerY;
    }

    public int getWidth() {
        width = Math.abs(startPoint.getX() - endPoint.getX());
        return width;
    }

    public int getHeight() {
        height = Math.abs(startPoint.getY() - endPoint.getY());
        return height;
    }

    public DrawingPoint switchPoint() {
        return new DrawingPoint(endPoint, startPoint);
    }

    public Coordinate getMinXY() {
        int mouseStartX = Math.min(this.startPoint.getX(), this.endPoint.getX());
        int mouseStartY = Math.min(this.startPoint.getY(), this.endPoint.getY());

        Coordinate coordinate = new Coordinate(mouseStartX, mouseStartY);
        return coordinate;
    }

    public Coordinate getMaxXY() {
        int mouseEndX = Math.max(this.startPoint.getX(), this.endPoint.getX());
        int mouseEndY = Math.max(this.startPoint.getY(), this.endPoint.getY());

        Coordinate coordinate = new Coordinate(mouseEndX, mouseEndY);
        return coordinate;
    }
}
