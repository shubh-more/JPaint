package model.commands;

import model.Coordinates;
import model.FunctionsOfShapes;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;
import model.interfaces.InterfaceUndoRedo;
import model.persistence.ApplicationState;

//import java.awt.Coordinates;
import java.util.ArrayList;

import view.interfaces.PaintCanvasBase;

public class CommandSelect implements InterfaceCommand, InterfaceUndoRedo {

    PaintCanvasBase paintCanvas;
    private Coordinates startCoordinates;
    private Coordinates endCoordinates;
    private FunctionsOfShapes functionsOfShapes;
    ApplicationState appliState;

    public CommandSelect(ApplicationState appliState, Coordinates startCoordinates, Coordinates endCoordinates, FunctionsOfShapes functionsOfShapes, PaintCanvasBase paintCanvas){
        this.startCoordinates = startCoordinates;
        this.endCoordinates = endCoordinates;
        this.functionsOfShapes = functionsOfShapes;
        this.appliState = appliState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
   ArrayList<InterfaceShape> theShapesList = functionsOfShapes.getlistofShape();
        ArrayList<InterfaceShape> theSelectedShapeList = functionsOfShapes.getlistofSelectedShape();

        for (InterfaceShape shape : theSelectedShapeList) {
            if(shape.isShapesGroup()==true){
                shape.getShapeGroup().groupSelected = false;
            } else {
                shape.getOneShape().SelectedShapes = false;
            }
        }
        theSelectedShapeList.clear();
        int mouseStartX = Math.min(this.startCoordinates.getA(), this.endCoordinates.getA());
        int mouseEndX = Math.max(this.startCoordinates.getA(), this.endCoordinates.getA());
        int mouseStartY = Math.min(this.startCoordinates.getB(), this.endCoordinates.getB());
        int mouseEndY = Math.max(this.startCoordinates.getB(), this.endCoordinates.getB());
        int width = mouseEndX -   mouseStartX;
        int height = mouseEndY -   mouseStartY;
        for (InterfaceShape shape : theShapesList) {
            if (shape.isShapesGroup()==true) {
                int groupWidth = shape.getShapeGroup().getMaximumXY().x -   shape.getShapeGroup().MinimumXY().x;
                int groupHeight = shape.getShapeGroup().getMaximumXY().x -   shape.getShapeGroup().MinimumXY().x;
                if (shape.getShapeGroup().MinimumXY().x + groupWidth > mouseStartX
                        && shape.getShapeGroup().MinimumXY().y + groupHeight > mouseStartY
                        && mouseStartX + width > shape.getShapeGroup().MinimumXY().x
                        && mouseStartY + height > shape.getShapeGroup().MinimumXY().y) {
                    shape.getShapeGroup().groupSelected=true;
                    theSelectedShapeList.add(shape);
            }
            }
            else{
                int shapeStartX = Math.min(shape.getOneShape().getStartPoint().getA(), shape.getOneShape().getEndPoint().getA());
                int shapeEndX = Math.max(shape.getOneShape().getStartPoint().getA(), shape.getOneShape().getEndPoint().getA());
                int shapeStartY = Math.min(shape.getOneShape().getStartPoint().getB(), shape.getOneShape().getEndPoint().getB());
                int shapeEndY =  Math.max(shape.getOneShape().getStartPoint().getB(), shape.getOneShape().getEndPoint().getB());
                int shapeWidth = shapeEndX - shapeStartX;
                int shapeHeight = shapeEndY - shapeStartY;
                if (shapeStartX + shapeWidth > mouseStartX
                        && shapeStartY + shapeHeight > mouseStartY
                        && mouseStartX + width > shapeStartX
                        && mouseStartY + height > shapeStartY) {
                shape.getOneShape().shapeSelected();
                    theSelectedShapeList.add(shape);
                }
            }
            functionsOfShapes.shapeListDrawer(theShapesList, theSelectedShapeList);
            CommandStoreMemory.add(this);
        }
    }
    @Override
    public void undo() {
        ArrayList<InterfaceShape> theselectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> thedeselectedShapeList = functionsOfShapes.listofShapedeselected;
        for(InterfaceShape d: theselectedShapeList){
            thedeselectedShapeList.add(d);
            d.getOneShape().SelectedShapes =false;
        }
        theselectedShapeList.clear();
        System.out.println("Select undo!");
        functionsOfShapes.shapeListDrawer(functionsOfShapes.getlistofShape(),theselectedShapeList);
    }
    @Override
    public void redo() {
        ArrayList<InterfaceShape> theSelectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> theDeselectedShapeList = functionsOfShapes.listofShapedeselected;
        for(InterfaceShape d: theDeselectedShapeList){
            theSelectedShapeList.add(d);
            d.getOneShape().SelectedShapes =true;
        }
        theDeselectedShapeList.clear();
        System.out.println("Select redo is done");
        functionsOfShapes.shapeListDrawer(functionsOfShapes.getlistofShape(),theSelectedShapeList);
    }
}
