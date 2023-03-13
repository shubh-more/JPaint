package model.commands;

import model.Coordinates;
import model.Shapes;
import model.interfaces.InterfaceShape;

import java.awt.*;
import java.util.ArrayList;

public class CommandShapeGroup implements InterfaceShape {

    public ArrayList<InterfaceShape> ch;
    Graphics2D graphics;
    public boolean groupSelected;
    int alphaX;
    int alphaY;

    public CommandShapeGroup(){
        ch = new ArrayList();
    }

    public ArrayList<InterfaceShape> getChildren(){
        return ch;
    }

    public void addChild(InterfaceShape shape){
        ch.add(shape);
    }

    public InterfaceShape removeChild(int i){
        InterfaceShape z;
        z = this.ch.remove(i);
        return z;
    }

    public void moveChildren(int alphaX, int alphaY){
        this.alphaX = alphaX;
        this.alphaY = alphaY;
        for(InterfaceShape c : ch){
            c.getOneShape().setStartPoint((c.getOneShape().getStartPoint().x)+alphaX, (c.getOneShape().getStartPoint().y)+alphaY);
            c.getOneShape().setEndPoint((c.getOneShape().getEndPoint().x)+alphaX, (c.getOneShape().getEndPoint().y)+alphaY);
        }
    }

    public void undoMoveChildren(){
        for(InterfaceShape c : ch){
            c.getOneShape().setStartPoint((c.getOneShape().getStartPoint().x)-alphaX, (c.getOneShape().getStartPoint().y)-alphaY);
            c.getOneShape().setEndPoint((c.getOneShape().getEndPoint().x)-alphaX, (c.getOneShape().getEndPoint().y)-alphaY);
        }
    }

    public void redoMoveChildren(){
        for(InterfaceShape c : ch){
            c.getOneShape().setStartPoint((c.getOneShape().getStartPoint().x)+alphaX, (c.getOneShape().getStartPoint().y)+alphaY);
            c.getOneShape().setEndPoint((c.getOneShape().getEndPoint().x)+alphaX, (c.getOneShape().getEndPoint().y)+alphaY);
        }
    }

    public int getShapeSize(){
        int size = 0;
        for(InterfaceShape child : ch){
            size++;
        }
        return size;
    }



    public Coordinates MinimumXY(){
        int shapeStartX = 9999;
        int shapeStartY = 9999;
        for(InterfaceShape child : ch){
            if(child.isShapesGroup()==false){
                if(child.getOneShape().getMinXY().x<shapeStartX){
                    shapeStartX = child.getOneShape().getMinXY().x;
                }
                if(child.getOneShape().getMinXY().y<shapeStartY){
                    shapeStartY = child.getOneShape().getMinXY().y;

                }
            }
            else{
                if(child.getShapeGroup().MinimumXY().x<shapeStartX){
                    shapeStartX = child.getShapeGroup().MinimumXY().x;
                }
                if(child.getShapeGroup().MinimumXY().y<shapeStartY){
                    shapeStartY = child.getShapeGroup().MinimumXY().y;
                }
            }
        }
        Coordinates minXY = new Coordinates(shapeStartX,shapeStartY);
        return minXY;
    }

    public Coordinates getMaximumXY(){
        int shapeEndX = 0;
        int shapeEndY = 0;
        for(InterfaceShape child: ch){
            if(child.isShapesGroup()==false){
                if(child.getOneShape().getMaxXY().x>shapeEndX){
                    shapeEndX = child.getOneShape().getMaxXY().x;
                }
                if(child.getOneShape().getMaxXY().y>shapeEndY){
                    shapeEndY = child.getOneShape().getMaxXY().y;
                }
            }
            else{
                if(child.getShapeGroup().getMaximumXY().x>shapeEndX){
                    shapeEndX = child.getShapeGroup().getMaximumXY().x;
                }
                if(child.getShapeGroup().getMaximumXY().y>shapeEndY){
                    shapeEndY = child.getShapeGroup().getMaximumXY().y;
                }
            }

        }
        Coordinates maxXY = new Coordinates(shapeEndX,shapeEndY);
        return maxXY;
    }

    @Override
    public void Childdrawn(Graphics2D g) {
        this.graphics = g;
        for(InterfaceShape s:ch){
            if(s.getShapeSize()>0){
                s.Childdrawn(g);
            }
            else{
                s.draw(g);
            }
        }
    }

    @Override
    public boolean isShapesGroup() {
        return true;
    }

    @Override
    public void draw(Graphics2D g) {
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
        return null;
    }

    @Override
    public CommandShapeGroup getShapeGroup() {
        return this;
    }


}
