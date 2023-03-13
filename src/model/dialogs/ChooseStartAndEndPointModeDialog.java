package model.dialogs;

import model.MouseFunctions;
import model.interfaces.InterfaceApplicationState;
import view.interfaces.IDialogChoice;

public class ChooseStartAndEndPointModeDialog implements IDialogChoice<MouseFunctions> {
    private final InterfaceApplicationState applicationState;

    public ChooseStartAndEndPointModeDialog(InterfaceApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Start and End Coordinates Mode";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public MouseFunctions[] getDialogOptions() {
        return MouseFunctions.values();
    }

    @Override
    public MouseFunctions getCurrentSelection() {
        return applicationState.getActiveMouseMode();
    }
}
