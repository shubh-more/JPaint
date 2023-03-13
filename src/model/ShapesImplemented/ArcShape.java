package model.ShapesImplemented;

import model.Coordinates;
import model.ShapeShadingTypes;
import model.Shapes;
import model.commands.CommandShapeGroup;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;

import java.awt.*;


public  class ArcShape implements InterfaceShape, InterfaceCommand {

    Shapes shapes;

    public ArcShape(Shapes shapes) {
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

        g.setColor(shapes.primaryColor);
        if(shapes.typesOfShading == ShapeShadingTypes.FILLED_IN){
//            System.out.println("ShapeShadingTypes is FILLED_IN");
            g.fillArc(startX,startY,width, height,0,180);
        }
        else if (shapes.typesOfShading == ShapeShadingTypes.OUTLINE){
//            System.out.println("ShapeShadingTypes is OUTLINE");
            g.drawArc(startX,startY,width, height,0,180);
        }
        else{
//            System.out.println("ShapeShadingTypes is OUTLINE AND FILLED IN");
            g.setColor(shapes.secondaryColor);
            g.drawArc(startX,startY,width, height,0,180);
            g.setColor(shapes.primaryColor);
            g.fillArc(startX,startY,width, height,0,180);

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
