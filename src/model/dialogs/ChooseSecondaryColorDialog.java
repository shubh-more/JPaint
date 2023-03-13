package model.dialogs;

import model.ShapeColors;
import model.interfaces.InterfaceApplicationState;
import view.interfaces.IDialogChoice;

public class ChooseSecondaryColorDialog implements IDialogChoice<ShapeColors> {

    private final InterfaceApplicationState applicationState;

    public ChooseSecondaryColorDialog(InterfaceApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Secondary Color";
    }

    @Override
    public String getDialogText() {
        return "Select a secondary color from the menu below:";
    }

    @Override
    public ShapeColors[] getDialogOptions() {
        return ShapeColors.values();
    }

    @Override
    public ShapeColors getCurrentSelection() {
        return applicationState.getActiveSecondaryColor();
    }
}
