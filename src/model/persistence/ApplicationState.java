package model.persistence;

import model.MouseFunctions;
import model.ShapeColors;
import model.ShapeShadingTypes;
import model.ShapeTypes;
import model.dialogs.DialogProvider;
import model.interfaces.InterfaceApplicationState;
import model.interfaces.InterfaceDialogProvider;
import view.interfaces.IUiModule;

public class ApplicationState implements InterfaceApplicationState {
    private final IUiModule uiModule;
    private final InterfaceDialogProvider dialogProvider;

    private ShapeTypes activeShapeTypes;
    private ShapeColors activePrimaryColor;
    private ShapeColors activeSecondaryColor;
    private ShapeShadingTypes activeShapeShadingTypes;
    private MouseFunctions activeMouseFunctions;

    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    @Override
    public void setActiveShape() {
        activeShapeTypes = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingTypes = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeMouseFunctions = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public ShapeTypes getActiveShapeType() {
        return activeShapeTypes;
    }

    @Override
    public ShapeColors getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColors getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingTypes getActiveShapeShadingType() {
        return activeShapeShadingTypes;
    }

    @Override
    public MouseFunctions getActiveMouseMode() {
        return activeMouseFunctions;
    }

    private void setDefaults() {
        activeShapeTypes = ShapeTypes.RECTANGLE;
        activePrimaryColor = ShapeColors.BLUE;
        activeSecondaryColor = ShapeColors.GREEN;
        activeShapeShadingTypes = ShapeShadingTypes.FILLED_IN;
        activeMouseFunctions = MouseFunctions.DRAW;
    }
}
