package model.ShapesImplemented;

import model.Coordinates;
import model.ShapeShadingTypes;
import model.Shapes;
import model.commands.CommandShapeGroup;
import model.interfaces.InterfaceShape;
import model.persistence.ApplicationState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class DiamondShape implements InterfaceShape {
    ApplicationState appState;
    Shapes shapes;
    boolean isSelected;

    public DiamondShape(Shapes shapes) {
        this.shapes = shapes;
    }

    @Override
    public void draw(Graphics2D g) {

        int startX = Math.min(shapes.startCoordinates.getA(), shapes.endCoordinates.getA());
        int endX = Math.max(shapes.startCoordinates.getA(), shapes.endCoordinates.getA());
        int startY = Math.min(shapes.startCoordinates.getB(), shapes.endCoordinates.getB());
        int endY = Math.max(shapes.startCoordinates.getB(), shapes.endCoordinates.getB());

        int width = endX - startX;
        int height = endY - startY;

        AffineTransform at = AffineTransform.getTranslateInstance(startX, startY);
        Shape shape = at.createTransformedShape(new Diamond(width,height));



        g.setColor(shapes.primaryColor);
        if(shapes.typesOfShading == ShapeShadingTypes.FILLED_IN) {
         g.fill(shape);
        }
        else if (shapes.typesOfShading == ShapeShadingTypes.OUTLINE){
         g.draw(shape);
        }
        else{
            g.setColor(shapes.secondaryColor);
            g.draw(shape);
            g.setColor(shapes.primaryColor);
             g.fill(shape);
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


    public class Diamond extends Path2D.Double {

        public Diamond(double width, double height) {
            moveTo(0, height / 2);
            lineTo(width / 2, 0);
            lineTo(width, height / 2);
            lineTo(width / 2, height);
            closePath();
        }

    }

}


