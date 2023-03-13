package model.ShapesImplemented;

import model.Coordinates;
import model.ShapeShadingTypes;
import model.Shapes;
import model.commands.CommandShapeGroup;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;

import java.awt.*;


public  class LineShape implements InterfaceShape, InterfaceCommand {

    Shapes shapes;

    public LineShape(Shapes shapes) {
        this.shapes = shapes;
    }

    @Override
    public void draw(Graphics2D g) {

        int startX = shapes.startCoordinates.getA();
        int endX = shapes.endCoordinates.getA();
        int startY = shapes.startCoordinates.getB();
        int endY = shapes.endCoordinates.getB();




        g.setColor(shapes.primaryColor);
        if(shapes.typesOfShading == ShapeShadingTypes.FILLED_IN){
//            System.out.println("ShapeShadingTypes is FILLED_IN");
            g.drawLine(startX,startY,endX,endY);
        }
        else if (shapes.typesOfShading == ShapeShadingTypes.OUTLINE){
//            System.out.println("ShapeShadingTypes is OUTLINE");
            g.drawLine(startX,startY,endX,endY);
        }
        else{
//            System.out.println("ShapeShadingTypes is OUTLINE AND FILLED IN");
            g.setColor(shapes.secondaryColor);
            g.drawLine(startX,startY,endX,endY);
            g.setColor(shapes.primaryColor);
            g.drawLine(startX,startY,endX,endY);

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
