package model.ShapesImplemented;

import model.Coordinates;
import model.ShapeShadingTypes;
import model.Shapes;
import model.commands.CommandShapeGroup;
import model.interfaces.InterfaceShape;
import model.persistence.ApplicationState;

import java.awt.*;
//import java.awt.Coordinates;


public  class RoundedRectangleShape implements InterfaceShape {

    Shapes shapes;
    ApplicationState appState;
    public RoundedRectangleShape(Shapes shapes){
        this.shapes = shapes;
    }

    @Override
    public void draw(Graphics2D g) {

        int firstX = Math.min(shapes.startCoordinates.getA(), shapes.endCoordinates.getA());
        int lastX = Math.max(shapes.startCoordinates.getA(), shapes.endCoordinates.getA());
        int firstY = Math.min(shapes.startCoordinates.getB(), shapes.endCoordinates.getB());
        int lastY = Math.max(shapes.startCoordinates.getB(), shapes.endCoordinates.getB());

        int width = lastX - firstX;
        int height = lastY - firstY;

        g.setColor(shapes.primaryColor);

        if(shapes.typesOfShading == ShapeShadingTypes.FILLED_IN){
//            System.out.println("ShapeShadingTypes is FILLED_IN");
            g.fillRoundRect(firstX,firstY,width, height,18,18);
        }
        else if (shapes.typesOfShading == ShapeShadingTypes.OUTLINE){
//            System.out.println("ShapeShadingTypes is OUTLINE");
            g.drawRoundRect(firstX,firstY,width, height,18,18);
        }
        else if (shapes.typesOfShading == ShapeShadingTypes.OUTLINE){
//            System.out.println("ShapeShadingTypes is OUTLINE");
            g.drawRoundRect(firstX,firstY,width, height,18,18);
        }
        else {
//            System.out.println("ShapeShadingTypes is OUTLINE AND FILLED IN");
            g.setColor(shapes.secondaryColor);
            g.drawRoundRect(firstX, firstY, width, height,18,18);
            g.setColor(shapes.primaryColor);
            g.fillRoundRect(firstX, firstY, width, height,18,18);
        }
    }

    @Override
    public Coordinates getStartingCoordinates() {
        return null;
    }

    @Override
    public Coordinates getEndingCoordinate() {
        return null;
    }

    @Override
    public Shapes getOneShape() {
        return shapes;
    }

    @Override
    public CommandShapeGroup getShapeGroup() {
        return null;
    }

    @Override
    public int getShapeSize() {
        return 0;
    }

    @Override
    public void Childdrawn(Graphics2D g) {

    }

    @Override
    public boolean isShapesGroup() {
        return false;
    }


}
