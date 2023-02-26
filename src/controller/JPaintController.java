package controller;
import model.Command.*;
import model.ShapeList;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {

    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final ShapeList shapeList;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState,
                            ShapeList shapeList) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeList = shapeList;
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

        uiModule.addEvent(EventName.UNDO, () -> new CommandUndo().undo());
        uiModule.addEvent(EventName.REDO, () -> new CommandRedo().redo());
        uiModule.addEvent(EventName.COPY, () -> new CommandCopy(shapeList).run());
        uiModule.addEvent(EventName.PASTE, () -> new CommandPaste(shapeList).run());
        uiModule.addEvent(EventName.DELETE, () -> new CommandDelete(shapeList).run());

    }
}
