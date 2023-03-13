package model.ShapesImplemented;

import model.Coordinates;
import model.ShapeShadingTypes;
import model.Shapes;
import model.commands.CommandShapeGroup;
import model.interfaces.InterfaceShape;
import model.persistence.ApplicationState;

import java.awt.*;

public class HexagonShape implements InterfaceShape {
    ApplicationState appState;
    Shapes shapes;
    boolean isSelected;

    public HexagonShape(Shapes shapes) {
        this.shapes = shapes;
    }

    @Override
    public void draw(Graphics2D g) {


        int startArray[] = new int[6];
        int endArray[] = new int[6];

        int x = (int) shapes.startCoordinates.getA();
        int y = (int)shapes.startCoordinates.getB();
        int R = shapes.startCoordinates.getA()-shapes.endCoordinates.getA();

       int[][] xy = getPolygonArrays(x, y, R);
        Polygon polygon= new Polygon(xy[0], xy[1], 6);

        g.setColor(shapes.primaryColor);
        if(shapes.typesOfShading == ShapeShadingTypes.FILLED_IN) {
            g.fillPolygon(polygon);
        }
        else if (shapes.typesOfShading == ShapeShadingTypes.OUTLINE){
            g.drawPolygon(polygon);
        }
        else{
            g.setColor(shapes.secondaryColor);
            g.drawPolygon(polygon);
            g.setColor(shapes.primaryColor);
             g.fillPolygon(polygon);
        }

    }

    int[][] getPolygonArrays(int cx, int cy, int R) {
        int[] x = new int[6];
        int[] y = new int[6];
        double thetaInc = 2*Math.PI/6;
        double theta = (6 % 2 == 0) ? thetaInc : -Math.PI/2;
        for(int j = 0; j < 6; j++) {
            x[j] = (int)(cx + R*Math.cos(theta));
            y[j] = (int)(cy + R*Math.sin(theta));
            theta += thetaInc;
        }
        return new int[][]{ x, y };
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


