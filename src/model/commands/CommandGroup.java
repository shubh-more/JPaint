package model.commands;


import model.FunctionsOfShapes;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;
import model.interfaces.InterfaceUndoRedo;

import java.util.ArrayList;

public class CommandGroup implements InterfaceCommand, InterfaceUndoRedo {

    FunctionsOfShapes functionsOfShapes;
    CommandShapeGroup commandShapeGroup;
    int numberChildren;


    public CommandGroup(FunctionsOfShapes functionsOfShapes){
        this.functionsOfShapes = functionsOfShapes;
    }

    @Override
    public void run() {
        ArrayList<InterfaceShape> theShapesList = functionsOfShapes.getlistofShape();
        ArrayList<InterfaceShape> theSelectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> theGroupList = functionsOfShapes.getlistOfGroup();

        if(theSelectedShapeList.size() <= 0) { System.out.println("Selected shape bucket is empty"); }

        else if(theSelectedShapeList.size()>= 1){
            commandShapeGroup = new CommandShapeGroup();
            theGroupList.add(commandShapeGroup);
            for(InterfaceShape shape : theSelectedShapeList){

                theShapesList.remove(shape);
                if(shape.isShapesGroup()==false){
                    commandShapeGroup.addChild(shape);
                    shape.getOneShape().SelectedShapes =false;
                    numberChildren++;
                }
                else if(shape.isShapesGroup()==true){
                    shape.getShapeGroup().groupSelected=false;
                    commandShapeGroup.addChild(shape);
                    numberChildren++;
                }
            }
            theShapesList.add(commandShapeGroup);
            theSelectedShapeList.clear();
            theSelectedShapeList.add(commandShapeGroup);
        }
        functionsOfShapes.shapeListDrawer(theShapesList,theSelectedShapeList);
        CommandStoreMemory.add(this);
    }
    @Override
    public void undo() {
        ArrayList<InterfaceShape> theSelectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> theMainShapesList = functionsOfShapes.getlistofShape();
        theSelectedShapeList.remove(commandShapeGroup);
        theMainShapesList.remove(commandShapeGroup);
        while(commandShapeGroup.getShapeSize()!=0){
            InterfaceShape s = commandShapeGroup.removeChild(commandShapeGroup.getShapeSize()-1);
            theMainShapesList.add(s);
            theSelectedShapeList.add(s);
            s.getOneShape().SelectedShapes =true;
        }
        functionsOfShapes.shapeListDrawer(functionsOfShapes.getlistofShape(), functionsOfShapes.getlistofSelectedShape());
    }

    @Override
    public void redo() {
        ArrayList<InterfaceShape> theSelectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> theMainShapesList = functionsOfShapes.getlistofShape();
        for(InterfaceShape s : theSelectedShapeList){
            theMainShapesList.remove(s);
            if(s.isShapesGroup()==false){
                commandShapeGroup.addChild(s);
                s.getOneShape().SelectedShapes =false;
            }
            else if(s.isShapesGroup()==true){
                s.getShapeGroup().groupSelected=false;
                for(InterfaceShape z: s.getShapeGroup().getChildren()){
                    commandShapeGroup.addChild(z);
                }
            }
        }
        theMainShapesList.add(commandShapeGroup);
        theSelectedShapeList.clear();
        theSelectedShapeList.add(commandShapeGroup);
        functionsOfShapes.shapeListDrawer(functionsOfShapes.getlistofShape(), functionsOfShapes.getlistofSelectedShape());
    }
}
