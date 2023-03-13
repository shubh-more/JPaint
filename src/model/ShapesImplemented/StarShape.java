package model.ShapesImplemented;

import model.Coordinates;
import model.ShapeShadingTypes;
import model.Shapes;
import model.commands.CommandShapeGroup;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;

import java.awt.*;


public  class StarShape implements InterfaceShape, InterfaceCommand {

    Shapes shapes;

    public StarShape(Shapes shapes) {
        this.shapes = shapes;
    }

    @Override
    public void draw(Graphics2D g) {

        int midX = shapes.startCoordinates.getA();
        int midY = shapes.startCoordinates.getB();
        int diff=shapes.startCoordinates.getA()-shapes.endCoordinates.getA();
        if(diff<0)
        {
            diff=diff*(-1);
        }
        int radius[] = {diff,diff/3,diff/2,diff/3};
        int nPoints = 16;
        int[] X = new int[nPoints];
        int[] Y = new int[nPoints];

        for (double current=0.0; current<nPoints; current++)
        {
            int i = (int) current;
            double x = Math.cos(current*((2*Math.PI)/16))*radius[i % 4];
            double y = Math.sin(current*((2*Math.PI)/16))*radius[i % 4];

            X[i] = (int) x+midX;
            Y[i] = (int) y+midY;
        }


        g.setColor(shapes.primaryColor);
        if(shapes.typesOfShading == ShapeShadingTypes.FILLED_IN){
            g.fillPolygon(X, Y, nPoints);

        }
        else if (shapes.typesOfShading == ShapeShadingTypes.OUTLINE){
            g.drawPolygon(X, Y, nPoints);

        }
        else{
//            System.out.println("ShapeShadingTypes is OUTLINE AND FILLED IN");
            g.setColor(shapes.secondaryColor);
            g.drawPolygon(X, Y, nPoints);

            g.setColor(shapes.primaryColor);
            g.fillPolygon(X, Y, nPoints);

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

    @Override
    public void run() {

    }
}
