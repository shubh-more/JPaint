package model.dialogs;

import model.ShapeTypes;
import model.interfaces.InterfaceApplicationState;
import view.interfaces.IDialogChoice;

public class ChooseShapeDialog implements IDialogChoice<ShapeTypes> {
    private final InterfaceApplicationState applicationState;

    public ChooseShapeDialog(InterfaceApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Shapes";
    }

    @Override
    public String getDialogText() {
        return "Select a shape from the menu below:";
    }

    @Override
    public ShapeTypes[] getDialogOptions() {
        return ShapeTypes.values();
    }

    @Override
    public ShapeTypes getCurrentSelection() {
        return applicationState.getActiveShapeType();
    }
}
