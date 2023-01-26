package controller;

import model.*;
import model.Shape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseManager extends MouseAdapter {

    /*
    An abstract adapter class for receiving mouse events. The methods in this class are empty. This class exists as convenience for creating listener objects.
Mouse events let you track when a mouse is pressed, released, clicked, moved, dragged, when it enters a component, when it exits and when a mouse wheel is moved.
Extend this class to create a MouseEvent which create instance in MouseManager
    */

    private final ApplicationState appState;
    private final PaintCanvas paintCanvas;
    private final ShapeList shapeList;
    private Shape.Coordinate mousestartPoint;
    private Color primaryColor;
    private Color secondaryColor;
    private ShapeType shapeType;
    private ShapeShadingType shapeShadingType;


    public MouseManager(ApplicationState appState, PaintCanvas paintCanvas, ShapeList shapeList) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Mouse start point
        mousestartPoint = new Shape.Coordinate(e.getX(), e.getY());
        //Shape type
        shapeType = appState.getActiveShapeType();
        //Shading type
        shapeShadingType = appState.getActiveShapeShadingType();
        //ShapeColor
        ShapeColor getPrimaryColor = appState.getActivePrimaryColor();
        //primary color
        primaryColor = getPrimaryColor.getColor();
        //Shape Color
        ShapeColor getSecondaryColor = appState.getActiveSecondaryColor();
        //SecondaryColor
        secondaryColor = getSecondaryColor.getColor();
    }
//Once the mouse is released, parameter will be passed to shape builder and result will be displayed
    @Override
    public void mouseReleased(MouseEvent e) {
        Shape.Coordinate endPoint = new Shape.Coordinate(e.getX(), e.getY());
        Shape newShape = new Shape.ShapeBuilder()
                .setStartPoint(mousestartPoint)
                .setEndPoint(endPoint)
                .setPrimaryColor(primaryColor)
                .setSecondaryColor(secondaryColor)
                .setShapeType(shapeType)
                .setShadingType(shapeShadingType).build();
        // System.out.println("end point at " + endPoint.getX() + ", " + endPoint.getY());
        if(appState.getActiveMouseMode() == MouseMode.DRAW) {
            CreateShape createShape = new CreateShape(paintCanvas, newShape, shapeList);
            createShape.run();
        }
    }
}