package Main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseManager;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        //Created instance of shape list and calling it from main for creating shape
        ShapeList shapeList = new ShapeList();
        //Created instance of mouse manager and calling it from main for controlling of mouse
        MouseManager mouseManager = new MouseManager(appState, paintCanvas, shapeList);
        paintCanvas.addMouseListener(mouseManager);
        controller.setup();

    }
}


