package model.interfaces;

import model.MouseFunctions;
import model.ShapeColors;
import model.ShapeShadingTypes;
import model.ShapeTypes;
import view.interfaces.IDialogChoice;

public interface InterfaceDialogProvider {

    IDialogChoice<ShapeTypes> getChooseShapeDialog();

    IDialogChoice<ShapeColors> getChoosePrimaryColorDialog();

    IDialogChoice<ShapeColors> getChooseSecondaryColorDialog();

    IDialogChoice<ShapeShadingTypes> getChooseShadingTypeDialog();

    IDialogChoice<MouseFunctions> getChooseStartAndEndPointModeDialog();
}
