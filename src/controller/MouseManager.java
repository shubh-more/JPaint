package controller;

import model.*;
import model.Command.CommandCreate;
import model.Command.CommandMove;
import model.Command.CommandSelect;
import model.interfaces.IStrategy;
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

    private Coordinate endPoint;



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

    //Once the mouse is released, parameter will be passed to shape builder
    // and result will be displayed
    @Override
    public void mouseReleased(MouseEvent e) {
<<<<<<< HEAD
        DrawingPoint drawingPoint = new DrawingPoint(startPoint, new Coordinate(e.getX(), e.getY()));
        // builder pattern initiate
=======
        Context strategy = new Context();
        DrawingPoint drawingPoint = new DrawingPoint(startPoint,new Coordinate(e.getX(), e.getY()));
       this.endPoint = new Coordinate(e.getX(), e.getY());
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
        Shape newShape = new ShapeBuilder()
                .setPaintCanvas(paintCanvas)
                .setDrawingPoint(drawingPoint)
                .setPrimaryColor(appState.getActivePrimaryColor().getColor())
                .setSecondaryColor(appState.getActiveSecondaryColor().getColor())
                .setShapeType(appState.getActiveShapeType())
                .setShadingType(appState.getActiveShapeShadingType())
                .build();
        // strategy pattern initiate
        IStrategy mouseMode;
        Context strategy = new Context();
        if (appState.getActiveMouseMode() == MouseMode.DRAW) {
            mouseMode = new CommandCreate(newShape, shapeList);
        } else if (appState.getActiveMouseMode() == MouseMode.SELECT) {
            mouseMode = new CommandSelect(drawingPoint, shapeList);
        } else {
            mouseMode = new CommandMove(drawingPoint, shapeList);
        }
        strategy.setMouseMode(mouseMode);
        strategy.execute();
    }
}


