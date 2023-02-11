package model.interfaces;

import model.DrawingPoint;

public interface IMovementObserver {

    void update(DrawingPoint drawingPoint);
    void clear();

    void draw();

}
