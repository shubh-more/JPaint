package model;

import model.ShapesImplemented.*;
import model.persistence.ApplicationState;

import java.awt.*;

public class Shapes {
    public Coordinates startCoordinates;
    public Coordinates endCoordinates;
    public Color primaryColor;
    public Color secondaryColor;
    public ShapeShadingTypes typesOfShading;
    public ShapeTypes typesOfShape;
    public ApplicationState appliState;
    public boolean SelectedShapes = false;
    public boolean undoPerformed = false;

    public boolean pastedShape = false;

    int deltaX;
    int deltaY;

    public Shapes(Coordinates startCoordinates, Coordinates endCoordinates, ApplicationState appliState, Color primaryColor, Color secondaryColor, ShapeShadingTypes typesOfShading, ShapeTypes typesOfShape) {
        this.startCoordinates = startCoordinates;
        this.endCoordinates = endCoordinates;
        this.appliState = appliState;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.typesOfShading = typesOfShading;
        this.typesOfShape = typesOfShape;
    }

    public void draw(Graphics2D g) {

        if (typesOfShape == ShapeTypes.RECTANGLE){
            RectangleShape rect = new RectangleShape(this);
            rect.draw(g);
        }
        else if (typesOfShape == ShapeTypes.ELLIPSE){
            EllipseShape ellip = new EllipseShape(this);
            ellip.draw(g);
        }
        else if (typesOfShape == ShapeTypes.TRIANGLE){
             TriangleShape tri = new TriangleShape(this);
            tri.draw(g);
        }
        else if (typesOfShape == ShapeTypes.PENTAGON){
            PentagonShape pen = new PentagonShape(this);
            pen.draw(g);
        }

        else if (typesOfShape == ShapeTypes.STAR){

            StarShape star = new StarShape(this);
            star.draw(g);
        }

        else if (typesOfShape == ShapeTypes.ARROW){

            UparrowShape uparrow = new UparrowShape(this);
            uparrow.draw(g);
        }
        else if (typesOfShape == ShapeTypes.Diamond ){

            DiamondShape smiley = new DiamondShape(this);
            smiley.draw(g);
        }
        else if (typesOfShape == ShapeTypes.ARC){

            ArcShape arc = new ArcShape(this);
            arc.draw(g);
        }else if (typesOfShape == ShapeTypes.LINE){

            LineShape line = new LineShape(this);
            line.draw(g);
        }
        else if (typesOfShape == ShapeTypes.ROUNDEDRECTANGLE){

            RoundedRectangleShape rr = new RoundedRectangleShape(this);
            rr.draw(g);
        }
        else if (typesOfShape == ShapeTypes.DECAGON){

            DecagonShape dc = new DecagonShape(this);
            dc.draw(g);
        }
        else if (typesOfShape == ShapeTypes.OCTAGON){

            OctagonShape ot = new OctagonShape(this);
            ot.draw(g);
        }
    }


    public void move(int deltaX, int deltaY){
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.setStartPoint((this.getStartPoint().x)+deltaX, ((int)this.getStartPoint().y)+deltaY);
        this.setEndPoint(((int)this.getEndPoint().x)+deltaX, ((int)this.getEndPoint().y)+deltaY);
    }

    public void undoMove(){
        this.setStartPoint(((int)this.getStartPoint().x)-deltaX, ((int)this.getStartPoint().y)-deltaY);
        this.setEndPoint(((int)this.getEndPoint().x)-deltaX, ((int)this.getEndPoint().y)-deltaY);
    }
    public void redoMove(){
        this.setStartPoint(((int)this.getStartPoint().x)+deltaX, ((int)this.getStartPoint().y)+deltaY);
        this.setEndPoint(((int)this.getEndPoint().x)+deltaX, ((int)this.getEndPoint().y)+deltaY);
    }

    public Coordinates getMinXY(){
        int mouseStartX = Math.min(this.startCoordinates.getA(), this.endCoordinates.getA());
        int mouseStartY = Math.min(this.startCoordinates.getB(), this.endCoordinates.getB());

        Coordinates coordinates = new Coordinates(mouseStartX,mouseStartY);
        return coordinates;
    }

    public Coordinates getMaxXY(){
        int mouseEndX = Math.max(this.startCoordinates.getA(), this.endCoordinates.getA());
        int mouseEndY = Math.max(this.startCoordinates.getB(), this.endCoordinates.getB());

        Coordinates coordinates = new Coordinates(mouseEndX,mouseEndY);
        return coordinates;
    }


    public Coordinates getStartPoint() {
        return startCoordinates;
    }

    public Coordinates getEndPoint() {
        return endCoordinates;
    }

    public Color getPrimaryColor(){
        return primaryColor;
    }

    public Color getSecondaryColor(){
        return secondaryColor;
    }

    public ShapeShadingTypes getTypesOfShading() {
        return typesOfShading;
    }

    public ShapeTypes getShapeType() {
        return typesOfShape;
    }

    public int getWidth(){
        int startX = Math.min(this.startCoordinates.getA(), this.endCoordinates.getA());
        int endX = Math.max(this.startCoordinates.getA(), this.endCoordinates.getA());
        int width = endX - startX;
        return width;
    }

    public int getHeight(){
        int startY = Math.min(this.startCoordinates.getB(), this.endCoordinates.getB());
        int endY = Math.max(this.startCoordinates.getB(), this.endCoordinates.getB());
        int height = endY - startY;
        return height;
    }

    public void setStartPoint(int x, int y) {
        this.startCoordinates.x = x;
        this.startCoordinates.y = y;
    }

    public void setEndPoint(int x, int y) {
        this.endCoordinates.x = x;
        this.endCoordinates.y = y;
    }

    public void shapeSelected(){
        SelectedShapes = !SelectedShapes;
//        System.out.println("shapeSelected Boolean: " + shapeSelected);
    }
}
