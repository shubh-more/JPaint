package model.ShapesImplemented;

import model.Coordinates;
import model.ShapeShadingTypes;
import model.Shapes;
import model.commands.CommandShapeGroup;
import model.interfaces.InterfaceShape;
import model.persistence.ApplicationState;

import java.awt.*;
//import java.awt.Coordinates;


public  class TriangleShape implements InterfaceShape {


    ApplicationState appState;
    Shapes shapes;
    boolean isSelected;

    public TriangleShape(Shapes shapes) {
        this.shapes = shapes;
    }

    @Override
    public void draw(Graphics2D g) {

        Coordinates newCoordinates = new Coordinates(shapes.startCoordinates.x, shapes.endCoordinates.y);

//        System.out.println("startCoordinates.x = " + startCoordinates.x);
        int startArray[] = new int[3];
        int endArray[] = new int[3];

        startArray[0] = (int) shapes.startCoordinates.getA();
        startArray[1] = (int) shapes.endCoordinates.getA();
        startArray[2] = (int) newCoordinates.getA();

        endArray[0] = (int) shapes.startCoordinates.getB();
        endArray[1] = (int) shapes.endCoordinates.getB();
        endArray[2] = (int) newCoordinates.getB();

        g.setColor(shapes.primaryColor);
        if(shapes.typesOfShading == ShapeShadingTypes.FILLED_IN) {
            g.fillPolygon(startArray,endArray,3);
        }
        else if (shapes.typesOfShading == ShapeShadingTypes.OUTLINE){
            g.drawPolygon(startArray,endArray,3);
        }
        else{
            g.setColor(shapes.secondaryColor);
            g.drawPolygon(startArray,endArray,3);
            g.setColor(shapes.primaryColor);
            g.fillPolygon(startArray,endArray,3);
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
