package model.interfaces;

import model.DrawingPoint;
import model.Shape;

import java.awt.*;

public interface IShape {

    void draw();

    void clear();
    void update(DrawingPoint drawingPoint);

    void repaint(Graphics g);

    Shape getShape();
}
