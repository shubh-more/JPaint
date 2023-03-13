package model.commands;

import model.*;
import model.Shapes;
import model.interfaces.InterfaceCommand;
import model.interfaces.InterfaceShape;
import model.interfaces.InterfaceUndoRedo;
import model.persistence.ApplicationState;
import java.awt.*;


public class CommandCreateShape implements InterfaceCommand, InterfaceUndoRedo {

    private ShapeTypes shapeTypes;
    ApplicationState appliState;
    private Coordinates startCoordinates;
    private Coordinates endCoordinates;
    private FunctionsOfShapes functionsOfShapes;
    Color aColor;
    Color bColor;
    private ShapeShadingTypes shapeShadingTypes;
    public InterfaceShape interfaceShape;


    public CommandCreateShape(ApplicationState appliState, Coordinates startCoordinates, Coordinates endCoordinates, FunctionsOfShapes functionsOfShapes, Color aColor, Color bColor, ShapeShadingTypes shapeShadingTypes, ShapeTypes shapeTypes){
        this.startCoordinates = startCoordinates;
        this.endCoordinates = endCoordinates;
        this.functionsOfShapes = functionsOfShapes;
        this.appliState = appliState;
        this.aColor = aColor;
        this.bColor = bColor;
        this.shapeShadingTypes = shapeShadingTypes;
        this.shapeTypes = shapeTypes;
    }

    public void run() {
        Shapes shapes = new Shapes(startCoordinates, endCoordinates,appliState,aColor,bColor, shapeShadingTypes, shapeTypes);
        ShapeOptions shapeOptions = new ShapeOptions();
        interfaceShape = shapeOptions.makeShape(shapes);
        functionsOfShapes.addShape(interfaceShape);
        CommandStoreMemory.add(this);
    }


    @Override
    public void undo() { functionsOfShapes.removeShape(); }

    @Override
    public void redo() {
        functionsOfShapes.redoShape();
    }
}