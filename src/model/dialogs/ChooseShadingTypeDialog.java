package model.dialogs;

import model.ShapeShadingTypes;
import model.interfaces.InterfaceApplicationState;
import view.interfaces.IDialogChoice;

public class ChooseShadingTypeDialog implements IDialogChoice<ShapeShadingTypes> {
    private final InterfaceApplicationState applicationState;

    public ChooseShadingTypeDialog(InterfaceApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Shading Type";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public ShapeShadingTypes[] getDialogOptions() {
        return ShapeShadingTypes.values();
    }

    @Override
    public ShapeShadingTypes getCurrentSelection() {
        return applicationState.getActiveShapeShadingType();
    }
}
