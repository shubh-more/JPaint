package model.commands;

import model.Coordinates;
import model.FunctionsOfShapes;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;
import model.interfaces.InterfaceUndoRedo;

import java.util.ArrayList;

public class CommandPaste implements InterfaceCommand, InterfaceUndoRedo {

    private FunctionsOfShapes functionsOfShapes;
    public int pasteN;
    public CommandPaste(FunctionsOfShapes functionsOfShapes){
        this.functionsOfShapes = functionsOfShapes;
    }

    @Override
    public void run() {
     //PasteCommand
        pasteN=0;

        ArrayList<InterfaceShape> theCopiedShapeList = functionsOfShapes.getlistofCopiedShape();
        ArrayList<InterfaceShape> thePasteShapeList = functionsOfShapes.getlistofPasteShape();

        for(InterfaceShape shape: thePasteShapeList){
            shape.getOneShape().pastedShape=false;
        }

        for(InterfaceShape shape: theCopiedShapeList){
            if(shape.isShapesGroup()==false){
                int x1 = shape.getOneShape().getStartPoint().x - 100;
                int y1 = shape.getOneShape().getStartPoint().y - 100;
                int x2 = shape.getOneShape().getEndPoint().x -100;
                int y2 = shape.getOneShape().getEndPoint().y - 100;
                Coordinates s2SCoordinates = new Coordinates(x1,y1);
                Coordinates s2ECoordinates = new Coordinates(x2,y2);
                InterfaceCommand createShapeCommand = new CommandCreateShape(shape.getOneShape().appliState, s2SCoordinates, s2ECoordinates, functionsOfShapes, shape.getOneShape().getPrimaryColor(), shape.getOneShape().getSecondaryColor(), shape.getOneShape().getTypesOfShading(), shape.getOneShape().getShapeType());
                createShapeCommand.run();
                pasteN++;
            }
            else{
                for(InterfaceShape z: shape.getShapeGroup().ch){
                    int x1 = z.getOneShape().getStartPoint().x - 100;
                    int y1 = z.getOneShape().getStartPoint().y - 100;
                    int x2 = z.getOneShape().getEndPoint().x -100;
                    int y2 = z.getOneShape().getEndPoint().y - 100;
                    Coordinates s2SCoordinates = new Coordinates(x1,y1);
                    Coordinates s2ECoordinates = new Coordinates(x2,y2);
                    InterfaceCommand createShapeCommand = new CommandCreateShape(z.getOneShape().appliState, s2SCoordinates, s2ECoordinates, functionsOfShapes, z.getOneShape().getPrimaryColor(), z.getOneShape().getSecondaryColor(), z.getOneShape().getTypesOfShading(), z.getOneShape().getShapeType());
                    createShapeCommand.run();
                    pasteN++;
                }
            }
        }
        CommandStoreMemory.add(this);
    }

    @Override
    public void undo() {
//Undo
        ArrayList<InterfaceShape> theMainShapeList = functionsOfShapes.getlistofShape();
        ArrayList<InterfaceShape> theUndoRedoList = functionsOfShapes.getlistOfUndoRedo();


        if(theMainShapeList.size() == 0) { return; }

        while(pasteN!=0){
            InterfaceShape lS = theMainShapeList.get(theMainShapeList.size()-1);
            theMainShapeList.remove(lS);
            theUndoRedoList.add(lS);
            functionsOfShapes.shapeListDrawer(theMainShapeList, functionsOfShapes.getlistofSelectedShape());
            pasteN--;
        }
    }

    @Override
    public void redo() {
//redo
        ArrayList<InterfaceShape> theMainShapeList = functionsOfShapes.getlistofShape();
        ArrayList<InterfaceShape> theUndoRedoList = functionsOfShapes.getlistOfUndoRedo();
        if(theMainShapeList.size() == 0) { return ; }
        else{
        while(theUndoRedoList.size()!=0) {
            InterfaceShape lS = theUndoRedoList.get(theUndoRedoList.size() - 1);
            theUndoRedoList.remove(lS);
            theMainShapeList.add(lS);
            functionsOfShapes.shapeListDrawer(theMainShapeList, functionsOfShapes.getlistofSelectedShape());
            pasteN++;
        }
        }
    }
}
