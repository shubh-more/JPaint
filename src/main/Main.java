package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.MouseManager;
import model.FunctionsOfShapes;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {

    public static void main(String[] args){
        PaintCanvasBase pC = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(pC);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appliState = new ApplicationState(uiModule);
        FunctionsOfShapes functionsOfShapes = new FunctionsOfShapes(pC,appliState);
        IJPaintController controller = new JPaintController(uiModule, appliState, functionsOfShapes,pC);
        controller.setup();

        pC.addMouseListener(new MouseManager(appliState,pC, functionsOfShapes));


    }

}



