package model.interfaces;

import model.MouseFunctions;
import model.ShapeColors;
import model.ShapeShadingTypes;
import model.ShapeTypes;

public interface InterfaceApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeTypes getActiveShapeType();

    ShapeColors getActivePrimaryColor();

    ShapeColors getActiveSecondaryColor();

    ShapeShadingTypes getActiveShapeShadingType();

    MouseFunctions getActiveMouseMode();
}
