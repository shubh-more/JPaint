package model.commands;

import model.FunctionsOfShapes;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;
import model.interfaces.InterfaceUndoRedo;


import java.util.ArrayList;

public class CommandUngroup implements InterfaceCommand, InterfaceUndoRedo {

    FunctionsOfShapes functionsOfShapes;


    public CommandUngroup(FunctionsOfShapes functionsOfShapes) {
        this.functionsOfShapes = functionsOfShapes;
    }

    @Override
    public void run() {
        ArrayList<InterfaceShape> theShapeList = functionsOfShapes.getlistofShape();
        ArrayList<InterfaceShape> theShapeListSelected = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> liatOfUndoRedo = functionsOfShapes.getlistOfUndoRedo();
        ArrayList<InterfaceShape> groupList = functionsOfShapes.getlistOfGroup();

        InterfaceShape outerShapeGroup = groupList.get(groupList.size() - 1);

        switch (groupList.size()) {
            case 0:
                System.out.println("there's nothing here!");
                break;
            case 1:
                for (InterfaceShape s : outerShapeGroup.getShapeGroup().ch) {
                    theShapeList.add(s);
                    theShapeListSelected.add(s);
                    s.getOneShape().SelectedShapes = true;
                }
                outerShapeGroup.getShapeGroup().groupSelected = false;
                break;
            default:
                for (InterfaceShape s : outerShapeGroup.getShapeGroup().ch) {
                    theShapeList.add(s);
                    theShapeListSelected.add(s);
                    if (s.isShapesGroup() == false) {
                        s.getOneShape().SelectedShapes = true;
                    } else {
                        s.getShapeGroup().groupSelected = true;
                    }
                }
                outerShapeGroup.getShapeGroup().groupSelected = false;
                break;
        }

        groupList.remove(outerShapeGroup);
        theShapeList.remove(outerShapeGroup);
        theShapeListSelected.remove(outerShapeGroup);
        liatOfUndoRedo.add(outerShapeGroup);
        functionsOfShapes.shapeListDrawer(theShapeList, theShapeListSelected);
        CommandStoreMemory.add(this);
    }

    @Override
    public void undo() {
        ArrayList<InterfaceShape> theShapeList = functionsOfShapes.getlistofShape();
        ArrayList<InterfaceShape> theShapeListSelected = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> groupList = functionsOfShapes.getlistOfGroup();

        CommandShapeGroup commandShapeGroup = new CommandShapeGroup();

        switch (theShapeListSelected.size()) {
            case 0:
                System.out.println("nothing to undo");
                break;
            case 1:
                InterfaceShape s = theShapeListSelected.get(0);
                theShapeList.remove(s);
                commandShapeGroup.addChild(s);
                if (s.isShapesGroup() == false) {
                    s.getOneShape().SelectedShapes = false;
                } else {
                    s.getShapeGroup().groupSelected = false;
                }
                theShapeList.add(commandShapeGroup);
                theShapeListSelected.clear();
                groupList.add(commandShapeGroup);
                commandShapeGroup.groupSelected = true;
                functionsOfShapes.shapeListDrawer(theShapeList, theShapeListSelected);
                break;
            default:
                for (InterfaceShape shape : theShapeListSelected) {
                    theShapeList.remove(shape);
                    commandShapeGroup.addChild(shape);
                    if (shape.isShapesGroup() == false) {
                        shape.getOneShape().SelectedShapes = false;
                    } else {
                        shape.getShapeGroup().groupSelected = false;
                    }
                }
                theShapeList.add(commandShapeGroup);
                theShapeListSelected.clear();
                theShapeListSelected.add(commandShapeGroup);
                groupList.add(commandShapeGroup);
                commandShapeGroup.groupSelected = true;
                functionsOfShapes.shapeListDrawer(theShapeList, theShapeListSelected);
                break;
        }
    }


    @Override
    public void redo() {
        System.out.println("Ungroup Command Pressed!");
        ArrayList<InterfaceShape> theShapeList = functionsOfShapes.getlistofShape();
        ArrayList<InterfaceShape> theShapeListSelected = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> liatOfUndoRedo = functionsOfShapes.getlistOfUndoRedo();
        ArrayList<InterfaceShape> groupList = functionsOfShapes.getlistOfGroup();

        InterfaceShape outerShapeGroup = groupList.get(groupList.size() - 1);

        switch (groupList.size()) {
            case 0:
                System.out.println("there's nothing here!");
                break;
            case 1:
                for (InterfaceShape s : outerShapeGroup.getShapeGroup().ch) {
                    theShapeList.add(s);
                    theShapeListSelected.add(s);
                    s.getOneShape().SelectedShapes = true;
                }
                outerShapeGroup.getShapeGroup().groupSelected = false;
                break;
            default:
                for (InterfaceShape s : outerShapeGroup.getShapeGroup().ch) {
                    theShapeList.add(s);
                    theShapeListSelected.add(s);
                    if (s.isShapesGroup() == false) {
                        s.getOneShape().SelectedShapes = true;
                    } else {
                        s.getShapeGroup().groupSelected = true;
                    }
                }
                outerShapeGroup.getShapeGroup().groupSelected = false;
                break;
        }

        groupList.remove(outerShapeGroup);
        theShapeList.remove(outerShapeGroup);
        theShapeListSelected.remove(outerShapeGroup);
        liatOfUndoRedo.add(outerShapeGroup);

        functionsOfShapes.shapeListDrawer(theShapeList, theShapeListSelected);
    }
}