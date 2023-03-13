package model;

import java.awt.*;
import java.util.ArrayList;

import model.interfaces.InterfaceShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

public class FunctionsOfShapes {

    public static ArrayList<InterfaceShape> listOfShape = new ArrayList<>();
    public static ArrayList<InterfaceShape> listofShapeDelete = new ArrayList<>();
    public static ArrayList<InterfaceShape> listOfShapeSelected = new ArrayList<>();
    public static ArrayList<InterfaceShape> listofShapeSelected = new ArrayList<>();
    public static ArrayList<InterfaceShape> listOfShapePaste = new ArrayList<>();
    public static ArrayList<InterfaceShape> listofShapedeselected = new ArrayList<>();
    public static ArrayList<InterfaceShape> listofundoRedo = new ArrayList<>();
    public static ArrayList<InterfaceShape> listofGroup = new ArrayList<>();

    

    private static PaintCanvas paintCanvas;
    public ApplicationState appState;


    public FunctionsOfShapes(PaintCanvasBase paintCanvas, ApplicationState appState) {
        this.paintCanvas = (PaintCanvas) paintCanvas;
        this.appState = appState;
    }

    public void addShape(InterfaceShape shape){
        listOfShape.add(shape);
        listofShapeDelete.clear();
        shapeListDrawer(listOfShape, listOfShapeSelected);
    }


    public void shapeListDrawer(ArrayList<InterfaceShape> shapeList, ArrayList<InterfaceShape> selectedShapeList){

        Graphics2D g = paintCanvas.getGraphics2D();
        g.setColor(Color.white);
        g.fillRect(0,0,9999,9999);
        for (InterfaceShape s: shapeList){
            s.draw(g);
            if(s.getShapeSize()>0){

                s.Childdrawn(g);
            }
        }
        if(selectedShapeList.size()>0){
            for (InterfaceShape z: selectedShapeList){
                DesigningShape designingShape = new DesigningShape(paintCanvas);
                if(z.isShapesGroup()){
                    designingShape.borderingGroup(z);
                }
                else {
                    designingShape.borderingShape(z);
                }
            }
        }

//        CommandStoreMemory.add(this);
    }

    public void removeShape(){
        if(listOfShape.size() == 0) {
            System.out.println("bucket is empty nothing to delete");
            return;
        }
        //get last shape in Shapes List
        InterfaceShape lastShape = listOfShape.get(listOfShape.size()-1);
        lastShape.getOneShape().SelectedShapes =false;
        listOfShape.remove(lastShape);
        listofShapeDelete.add(lastShape);
        shapeListDrawer(listOfShape, listOfShapeSelected);
    }

    public void removeSpecificShape(InterfaceShape s){
        if(listOfShape.size() == 0) {
            System.out.println("List bucket is empty");
            return;
        }
        else{
        listOfShape.remove(s);
        listofShapeDelete.add(s);
        }
        shapeListDrawer(listOfShape, listOfShapeSelected);
    }

    public void redoShape(){
        if(listofShapeDelete.size() == 0 && listOfShape.size()== 0) {
            System.out.println("Redo bucket is emplty!");
            return;
        }
        else if(listofShapeDelete.size() == 0 && listOfShape.size() != 0){
            InterfaceShape lastShape = listOfShape.get(listOfShape.size()-1);
            if(lastShape.getOneShape().undoPerformed ==true){
                lastShape.getOneShape().redoMove();
                lastShape.getOneShape().undoPerformed =false;
                lastShape.getOneShape().shapeSelected();
                shapeListDrawer(listOfShape, listOfShapeSelected);
            }
        }
        else{
            addDeletedShapes();
        }
    }

    public void addDeletedShapes(){
        InterfaceShape dShape = listofShapeDelete.get(listofShapeDelete.size()-1);
        InterfaceShape d = listofShapeDelete.remove(listofShapeDelete.size()-1);
        listOfShape.add(d);
        d.getOneShape().SelectedShapes =true;

        shapeListDrawer(listOfShape, listOfShapeSelected);
    }


    public ArrayList<InterfaceShape> getlistofShape() {
        return listOfShape;
    }

    public ArrayList<InterfaceShape> getlistofSelectedShape(){
        return listOfShapeSelected;
    }

    public ArrayList<InterfaceShape> getlistofDeletedShape(){
        return listofShapeDelete;
    }

    public ArrayList<InterfaceShape> getlistofCopiedShape() { return listofShapeSelected;}

    public ArrayList<InterfaceShape> getlistofPasteShape() { return listOfShapePaste;}

    public ArrayList<InterfaceShape> getlistOfUndoRedo() { return listofundoRedo;}

    public ArrayList<InterfaceShape> getlistOfGroup() { return listofGroup;}



}

