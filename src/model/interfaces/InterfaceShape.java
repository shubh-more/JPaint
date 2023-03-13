package model.interfaces;

import model.Coordinates;

import java.awt.*;
import model.Shapes;
import model.commands.CommandShapeGroup;

public interface InterfaceShape {

    void draw(Graphics2D g);
    Coordinates getStartingCoordinates();
    Coordinates getEndingCoordinate();
    Shapes getOneShape();
    CommandShapeGroup getShapeGroup();
    int getShapeSize();
    void Childdrawn(Graphics2D g);
    boolean isShapesGroup();
}
