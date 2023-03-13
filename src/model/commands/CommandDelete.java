package model.commands;

import model.FunctionsOfShapes;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;
import model.interfaces.InterfaceUndoRedo;

import java.util.ArrayList;

public class CommandDelete implements InterfaceCommand, InterfaceUndoRedo {

    private FunctionsOfShapes functionsOfShapes;
    int Numberofdeletes;


    public CommandDelete(FunctionsOfShapes functionsOfShapes) {
        this.functionsOfShapes = functionsOfShapes;
    }

    @Override
    public void run() {
//Delete Command called
        ArrayList<InterfaceShape> theShapesList = functionsOfShapes.getlistofShape();
        ArrayList<InterfaceShape> theSelectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> thedeletedShapeList = functionsOfShapes.getlistofDeletedShape();

        int selectListSize = theSelectedShapeList.size();

        switch (selectListSize) {
            case 0:
                System.out.println("The select bucket is empty nothing to delete");
                break;
            default:
                int i = 0;
                while (i < theSelectedShapeList.size()) {
                    InterfaceShape s = theSelectedShapeList.get(i);
                    if (s.getShapeSize() == 0) {
                        theShapesList.remove(s);
                        thedeletedShapeList.add(s);
                        s.getOneShape().SelectedShapes = false;
                        Numberofdeletes++;
                    } else {
                        theShapesList.remove(s);
                        thedeletedShapeList.add(s);
                        Numberofdeletes++;
                    }
                    i++;
                }
                theSelectedShapeList.clear();
                functionsOfShapes.shapeListDrawer(theShapesList, theSelectedShapeList);
                CommandStoreMemory.add(this);
                break;
        }
    }

    @Override
    public void undo() {
//Undo Delete
        ArrayList<InterfaceShape> themainShapesList = functionsOfShapes.getlistofShape();
        ArrayList<InterfaceShape> theSelectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> thedeletedShapeList = functionsOfShapes.getlistofDeletedShape();

        switch (Numberofdeletes) {
            case 0:
                Numberofdeletes = thedeletedShapeList.size();
                break;
            default:
                for (int i = thedeletedShapeList.size() - 1; i >= 0; i--) {
                    InterfaceShape lastShape = thedeletedShapeList.get(i);
                    thedeletedShapeList.remove(lastShape);
                    themainShapesList.add(lastShape);
                    theSelectedShapeList.add(lastShape);
                    if (lastShape.isShapesGroup() == true) {
                        lastShape.getShapeGroup().groupSelected = true;
                    } else {
                        lastShape.getOneShape().SelectedShapes = true;
                    }
                    functionsOfShapes.shapeListDrawer(themainShapesList, functionsOfShapes.getlistofSelectedShape());
                }
                break;
        }
    }

    @Override
    public void redo() {
//RedoCalled
        ArrayList<InterfaceShape> themainShapesList = functionsOfShapes.getlistofShape();
        ArrayList<InterfaceShape> theSelectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> thedeletedShapeList = functionsOfShapes.getlistofDeletedShape();


        for (int i = 0; i < Numberofdeletes; i++) {
            InterfaceShape lastShape = themainShapesList.get(themainShapesList.size() - 1);
            themainShapesList.remove(lastShape);
            thedeletedShapeList.add(lastShape);
            theSelectedShapeList.clear();
            switch (lastShape.isShapesGroup() ? 1 : 0) {
                case 1:
                    lastShape.getShapeGroup().groupSelected = false;
                    break;
                case 0:
                    lastShape.getOneShape().SelectedShapes = false;
                    break;
            }
            functionsOfShapes.shapeListDrawer(themainShapesList, functionsOfShapes.getlistofSelectedShape());
        }
    }
}