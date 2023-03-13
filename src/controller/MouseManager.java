package controller;

import model.*;
import model.commands.CommandCreateShape;
import model.commands.CommandSelect;
import model.interfaces.InterfaceCommand;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Coordinates;

public class MouseManager extends MouseAdapter {

    ApplicationState appliState;
    private FunctionsOfShapes functionsOfShapes;
    public Coordinates startCoordinates;
    public Coordinates endCoordinates;
    public PaintCanvasBase pC;

    public MouseManager(ApplicationState appliState, PaintCanvasBase pC, FunctionsOfShapes functionsOfShapes) {
        this.pC = pC;
        this.functionsOfShapes = functionsOfShapes;
        this.appliState = appliState;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        startCoordinates = new Coordinates(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.endCoordinates = new Coordinates(e.getX(), e.getY());

        //ChoosePrimaryColor
        ColorSwitch primaryColorSwitch = new ColorSwitch(appliState.getActivePrimaryColor());
        Color pColor = primaryColorSwitch.getColor();
        //ChooseSecondaryColor
        ColorSwitch secondaryColorSwitch = new ColorSwitch(appliState.getActiveSecondaryColor());
        Color sColor = secondaryColorSwitch.getColor();
        //ChooseShading Type
        ShapeShadingTypes shadingType = appliState.getActiveShapeShadingType();
        //ChooseShapeTypes
        ShapeTypes shapeTypes = appliState.getActiveShapeType();


        switch (appliState.getActiveMouseMode()) {
            //Draw mode
            case DRAW:
                InterfaceCommand createShapeCommand = new CommandCreateShape(appliState, startCoordinates, endCoordinates, functionsOfShapes, pColor, sColor, shadingType, shapeTypes);
                createShapeCommand.run();
                break;
            //select mode
            case SELECT:
                InterfaceCommand selectShapeCommand = new CommandSelect(appliState, startCoordinates, endCoordinates, functionsOfShapes, pC);
                selectShapeCommand.run();
                break;
            default:
                //move mode
                InterfaceCommand moveShapeCommand = new ShapeMovement(appliState, startCoordinates, endCoordinates, functionsOfShapes);
                moveShapeCommand.run();
                break;
        }
    }
}


