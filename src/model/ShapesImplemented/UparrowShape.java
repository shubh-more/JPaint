package model.ShapesImplemented;

import model.Coordinates;
import model.ShapeShadingTypes;
import model.Shapes;
import model.commands.CommandShapeGroup;
import model.interfaces.InterfaceShape;
import model.persistence.ApplicationState;

import java.awt.*;

public class UparrowShape implements InterfaceShape {
    ApplicationState appState;
    Shapes shapes;
    boolean isSelected;

    public UparrowShape(Shapes shapes) {
        this.shapes = shapes;
    }

    @Override
    public void draw(Graphics2D g) {


        int x0 = (int) shapes.startCoordinates.getA();
        int y0 = (int)shapes.startCoordinates.getB();
        int x1= (int) shapes.endCoordinates.getA();
        int y1 = (int)shapes.endCoordinates.getB();

        int headLength=10;
        int headAngle=40;
        double offs = headAngle * Math.PI / 180.0;
        double angle = Math.atan2(y0 - y1, x0 - x1);
        int[] xs = { x1 + (int) (headLength * Math.cos(angle + offs)), x1,
                x1 + (int) (headLength * Math.cos(angle - offs)) };
        int[] ys = { y1 + (int) (headLength * Math.sin(angle + offs)), y1,
                y1 + (int) (headLength * Math.sin(angle - offs)) };

        g.setColor(shapes.primaryColor);
        if(shapes.typesOfShading == ShapeShadingTypes.FILLED_IN) {
            g.drawLine(x0, y0, x1, y1);
            g.fillPolygon(xs, ys, 3);


        }
        else if (shapes.typesOfShading == ShapeShadingTypes.OUTLINE){
            g.drawLine(x0, y0, x1, y1);
            g.drawPolygon(xs, ys, 3);

        }
        else{
            g.setColor(shapes.secondaryColor);
            g.drawLine(x0, y0, x1, y1);
            g.drawPolygon(xs, ys, 3);
            g.setColor(shapes.primaryColor);
            g.drawLine(x0, y0, x1, y1);
            g.fillPolygon(xs, ys, 3);
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


