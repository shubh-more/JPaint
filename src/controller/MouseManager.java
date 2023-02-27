package controller;

import model.*;
import model.Command.CommandCreate;
import model.Command.CommandMove;
import model.Command.CommandSelect;
import model.Shape;
import model.interfaces.IStrategy;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This is MVC pattern, it is controller to communicate between the data (ShapeList) and the UI
 * (PaintCanvasBase). MouseAdapter (by default) has own way to detect the condition of mouse
 * (function of clicked, pressed, released, etc.) Coordinate, CreateShape and Shape instances are
 * created in MouseController.
 */
public class MouseManager extends MouseAdapter {

    private final ApplicationState appState;
    private final PaintCanvasBase paintCanvas;
    private final ShapeList shapeList;
    private Coordinate startPoint;

    public MouseManager(ApplicationState appState, PaintCanvasBase paintCanvas,
                        ShapeList shapeList) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList;
    }


    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Coordinate(e.getX(), e.getY());
    }

    /*
    Once user release the mouse, all parameters will pass to shape builder
    and it will show the result on canvas
    correspond to mouse mode
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        DrawingPoint drawingPoint = new DrawingPoint(startPoint, new Coordinate(e.getX(), e.getY()));
        // builder pattern initiate
        Shape newShape = new ShapeBuilder()
                .setPaintCanvas(paintCanvas)
                .setTwoPoint(drawingPoint)
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
