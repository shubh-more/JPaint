package controller;


import model.*;
import model.commands.*;
import model.interfaces.InterfaceApplicationState;
import view.EventName;
import view.interfaces.IUiModule;
import view.interfaces.PaintCanvasBase;

//JpaintController is used to set up the events like what kind
// of task is needed to performed

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final InterfaceApplicationState applicationState;
    private FunctionsOfShapes functionsOfShapes;
    private PaintCanvasBase pC;

    public JPaintController(IUiModule uiModule, InterfaceApplicationState applicationState, FunctionsOfShapes functionsOfShapes, PaintCanvasBase paintCanvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.functionsOfShapes = functionsOfShapes;
        this.pC=paintCanvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> new CommandUndo().run());
        uiModule.addEvent(EventName.REDO, () -> new CommandRedo().run());
        uiModule.addEvent(EventName.COPY, () -> new CommandCopy(functionsOfShapes).run());
        uiModule.addEvent(EventName.PASTE, () -> new CommandPaste(functionsOfShapes).run());
        uiModule.addEvent(EventName.DELETE, () -> new CommandDelete(functionsOfShapes).run());
        uiModule.addEvent(EventName.GROUP, () -> new CommandGroup(functionsOfShapes).run());
        uiModule.addEvent(EventName.UNGROUP, () -> new CommandUngroup(functionsOfShapes).run());
        uiModule.addEvent(EventName.SAVE, () -> new CommandSave(pC, functionsOfShapes).run());

    }
}
