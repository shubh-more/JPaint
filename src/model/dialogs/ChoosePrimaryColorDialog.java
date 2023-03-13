package model.dialogs;

import model.ShapeColors;
import model.interfaces.InterfaceApplicationState;
import view.interfaces.IDialogChoice;

public class ChoosePrimaryColorDialog implements IDialogChoice<ShapeColors> {

    private final InterfaceApplicationState applicationState;

    public ChoosePrimaryColorDialog(InterfaceApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Primary Color";
    }

    @Override
    public String getDialogText() {
        return "Select a primary color from the menu below:";
    }

    @Override
    public ShapeColors[] getDialogOptions() {
        return ShapeColors.values();
    }

    @Override
    public ShapeColors getCurrentSelection() {
        return applicationState.getActivePrimaryColor();
    }
}
