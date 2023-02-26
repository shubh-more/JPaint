package controller;
<<<<<<< HEAD
import model.Command.*;
=======
<<<<<<< HEAD
import model.Command.*;
=======
<<<<<<< HEAD
import model.Command.*;
=======
<<<<<<< HEAD
import model.Command.*;
=======

import model.Command.CommandCopy;
<<<<<<< HEAD
import model.Command.CommandPaste;
=======
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
import model.Command.CommandRedo;
import model.Command.CommandUndo;
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b
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
<<<<<<< HEAD
        uiModule.addEvent(EventName.COPY, () -> new CommandCopy(shapeList).run());
        uiModule.addEvent(EventName.PASTE, () -> new CommandPaste(shapeList).run());
        uiModule.addEvent(EventName.DELETE, () -> new CommandDelete(shapeList).run());
=======
<<<<<<< HEAD
        uiModule.addEvent(EventName.COPY, () -> new CommandCopy(shapeList).run());
        uiModule.addEvent(EventName.PASTE, () -> new CommandPaste(shapeList).run());
        uiModule.addEvent(EventName.DELETE, () -> new CommandDelete(shapeList).run());
=======
<<<<<<< HEAD
        uiModule.addEvent(EventName.COPY, () -> new CommandCopy(shapeList).run());
        uiModule.addEvent(EventName.PASTE, () -> new CommandPaste(shapeList).run());
        uiModule.addEvent(EventName.DELETE, () -> new CommandDelete(shapeList).run());
=======
<<<<<<< HEAD
        uiModule.addEvent(EventName.COPY, () -> new CommandCopy(shapeList).run());
        uiModule.addEvent(EventName.PASTE, () -> new CommandPaste(shapeList).run());
        uiModule.addEvent(EventName.DELETE, () -> new CommandDelete(shapeList).run());
=======
        uiModule.addEvent(EventName.REDO, () -> new CommandCopy(shapeList).run());
<<<<<<< HEAD
        uiModule.addEvent(EventName.PASTE, () -> new CommandPaste(shapeList).run());
=======
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde

>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b

    }
}
