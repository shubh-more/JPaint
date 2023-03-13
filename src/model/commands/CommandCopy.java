package model.commands;

import model.FunctionsOfShapes;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;
import model.interfaces.InterfaceUndoRedo;

import java.util.ArrayList;
import java.util.Iterator;

public class CommandCopy implements InterfaceCommand, InterfaceUndoRedo {

    public FunctionsOfShapes functionsOfShapes;

    public CommandCopy(FunctionsOfShapes functionsOfShapes){
        this.functionsOfShapes = functionsOfShapes;
    }
    @Override
    public void run() {

        ArrayList<InterfaceShape> selectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> copiedlist = functionsOfShapes.getlistofCopiedShape();
        copiedlist.clear();
        functionsOfShapes.getlistofPasteShape().clear();

        Iterator<InterfaceShape> iterator = selectedShapeList.iterator();
        while (( iterator).hasNext()) {
            InterfaceShape s = iterator.next();
            copiedlist.add(s);
        }
        CommandStoreMemory.add(this);
    }
    @Override
    public void undo() {
        //Undo
        ArrayList<InterfaceShape> selectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> copiedlist = functionsOfShapes.getlistofCopiedShape();
        Iterator<InterfaceShape> iterator = copiedlist.iterator();
        while (iterator.hasNext()) {
            InterfaceShape s = iterator.next();
            selectedShapeList.add(s);
        }
        copiedlist.clear();
    }

    @Override
    public void redo() {
        //Redo
        ArrayList<InterfaceShape> selectedShapeList = functionsOfShapes.getlistofSelectedShape();
        ArrayList<InterfaceShape> copiedlist = functionsOfShapes.getlistofCopiedShape();

        Iterator<InterfaceShape> iterator = selectedShapeList.iterator();
        while (iterator.hasNext()) {
            InterfaceShape s = iterator.next();
            copiedlist.add(s);
        }
    }
}
