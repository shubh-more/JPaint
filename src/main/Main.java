package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseManager;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;



public class Main {

    public static void main(String[] args) {
        ShapeList shapeList = new ShapeList();
        PaintCanvasBase paintCanvas = new PaintCanvas(shapeList);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController jpaintController = new JPaintController(uiModule, appState, shapeList);
        MouseManager mouseManager = new MouseManager(appState, paintCanvas, shapeList);
        paintCanvas.addMouseListener(mouseManager);
        jpaintController.setup();

    }
}
