package model;

import model.commands.CommandStoreMemory;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;
import model.interfaces.InterfaceUndoRedo;
import model.persistence.ApplicationState;

public class ShapeMovement implements InterfaceCommand, InterfaceUndoRedo {

    private Coordinates startCoordinates;
    private Coordinates endCoordinates;
    private FunctionsOfShapes functionsOfShapes;
    ApplicationState appliState;

    private int alphaX;
    private int alphaY;

    public ShapeMovement(ApplicationState appState, Coordinates startCoordinates, Coordinates endCoordinates, FunctionsOfShapes functionsOfShapes){
        this.startCoordinates = startCoordinates;
        this.endCoordinates = endCoordinates;
        this.functionsOfShapes = functionsOfShapes;
        this.appliState = appState;

        //determine delta
        alphaX = endCoordinates.getA()- startCoordinates.getA();
        alphaY = endCoordinates.getB()- startCoordinates.getB();
    }

    @Override
    public void run() {
        //if FunctionsOfShapes == NULL, throw an error!
        if(functionsOfShapes.getlistofSelectedShape().size()<=0) {
            System.out.println("The SelectShapeList is empty!");
        }
        else if (functionsOfShapes.getlistofSelectedShape().size()>0){
            for(InterfaceShape s : functionsOfShapes.getlistofSelectedShape()){
                if(s.getShapeSize()>0){
                    s.getShapeGroup().moveChildren(alphaX,alphaY);
                }
                else{
                    s.getOneShape().move(alphaX,alphaY);
                }
            }
            functionsOfShapes.shapeListDrawer(functionsOfShapes.getlistofShape(), functionsOfShapes.getlistofSelectedShape());
            CommandStoreMemory.add(this);
        }
    }


    @Override
    public void undo() {
        functionsOfShapes.getlistofSelectedShape();
        for(InterfaceShape shape: functionsOfShapes.getlistofSelectedShape()){
            if(shape.getShapeSize()>0){

                shape.getShapeGroup().undoMoveChildren();
            }
            else{
                shape.getOneShape().undoMove();
            }
        }
        functionsOfShapes.shapeListDrawer(functionsOfShapes.getlistofShape(), functionsOfShapes.getlistofSelectedShape());
//        CommandStoreMemory.add(this);
    }

    @Override
    public void redo() {
        functionsOfShapes.getlistofSelectedShape();
        for(InterfaceShape shape: functionsOfShapes.getlistofSelectedShape()){
            if(shape.getShapeSize()>0){
                shape.getShapeGroup().redoMoveChildren();
            }
            else{
                shape.getOneShape().redoMove();
            }
        }
        functionsOfShapes.shapeListDrawer(functionsOfShapes.getlistofShape(), functionsOfShapes.getlistofSelectedShape());

    }
}
