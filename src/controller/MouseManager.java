package controller;

import model.*;
import model.Command.CommandCreate;
import model.Command.CommandMove;
import model.Command.CommandSelect;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import model.Shape;
import model.Coordinate;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Context;

public class MouseManager extends MouseAdapter {

    /*
    An abstract adapter class for receiving mouse events. The methods in this class are empty. This class exists as convenience for creating listener objects.
Mouse events let you track when a mouse is pressed, released, clicked, moved, dragged, when it enters a component, when it exits and when a mouse wheel is moved.
Extend this class to create a MouseEvent which create instance in MouseManager
    */

    private final ApplicationState appState;
    private final PaintCanvas paintCanvas;
    private final ShapeList shapeList;
    private Coordinate startPoint;



    public MouseManager(ApplicationState appState, PaintCanvas paintCanvas, ShapeList shapeList) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Mouse start point
        startPoint = new Coordinate(e.getX(), e.getY());

    }

    //Once the mouse is released, parameter will be passed to shape builder and result will be displayed
    @Override
    public void mouseReleased(MouseEvent e) {
        Context strategy = new Context();
        DrawingPoint drawingPoint = new DrawingPoint(startPoint,new Coordinate(e.getX(), e.getY()));
        Coordinate endPoint = new Coordinate(e.getX(), e.getY());
        Shape newShape = new Shape.ShapeBuilder()
                .setPaintCanvas(paintCanvas)
                .setTwoPoint(drawingPoint)
                .setPrimaryColor(appState.getActivePrimaryColor().getColor())
                .setSecondaryColor(appState.getActiveSecondaryColor().getColor())
                .setShapeType(appState.getActiveShapeType())
                .setShadingType(appState.getActiveShapeShadingType())
                .build();
        if (appState.getActiveMouseMode() == MouseMode.DRAW) {
            strategy.setMouseMode(new CommandCreate(newShape, shapeList));
            strategy.execute();
        } else if (appState.getActiveMouseMode() == MouseMode.SELECT) {
            strategy.setMouseMode(new CommandSelect(drawingPoint, shapeList));
            strategy.execute();
        } else {
            strategy.setMouseMode(new CommandMove(drawingPoint, shapeList));
            strategy.execute();
        }
    }
}


