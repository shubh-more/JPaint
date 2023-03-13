package model.dialogs;

import model.MouseFunctions;
import model.ShapeColors;
import model.ShapeShadingTypes;
import model.ShapeTypes;
import model.interfaces.InterfaceApplicationState;
import model.interfaces.InterfaceDialogProvider;
import view.interfaces.IDialogChoice;

public class DialogProvider implements InterfaceDialogProvider {
    private final IDialogChoice<ShapeTypes> chooseShapeDialog;
    private final IDialogChoice<ShapeColors> choosePrimaryColorDialog;
    private final IDialogChoice<ShapeColors> chooseSecondaryColorDialog;
    private final IDialogChoice<ShapeShadingTypes> chooseShadingTypeDialog;
    private final IDialogChoice<MouseFunctions> chooseStartAndEndPointModeDialog;
    private final InterfaceApplicationState applicationState;

    public DialogProvider(InterfaceApplicationState applicationState) {
        this.applicationState = applicationState;
        chooseShapeDialog = new ChooseShapeDialog(this.applicationState);
        choosePrimaryColorDialog = new ChoosePrimaryColorDialog(this.applicationState);
        chooseSecondaryColorDialog = new ChooseSecondaryColorDialog(this.applicationState);
        chooseShadingTypeDialog = new ChooseShadingTypeDialog(this.applicationState);
        chooseStartAndEndPointModeDialog = new ChooseStartAndEndPointModeDialog(this.applicationState);
    }

    @Override
    public IDialogChoice<ShapeTypes> getChooseShapeDialog() {
        return chooseShapeDialog;
    }

    @Override
    public IDialogChoice<ShapeColors> getChoosePrimaryColorDialog() {
        return choosePrimaryColorDialog;
    }

    @Override
    public IDialogChoice<ShapeColors> getChooseSecondaryColorDialog() {
        return chooseSecondaryColorDialog;
    }

    @Override
    public IDialogChoice<ShapeShadingTypes> getChooseShadingTypeDialog() {
        return chooseShadingTypeDialog;
    }

    @Override
    public IDialogChoice<MouseFunctions> getChooseStartAndEndPointModeDialog() {
        return chooseStartAndEndPointModeDialog;
    }
}
