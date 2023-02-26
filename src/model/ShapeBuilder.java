package model;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class ShapeBuilder {

    private PaintCanvasBase paintCanvas;
    private DrawingPoint drawingPoint;
    private Color primaryColor;
    private Color secondaryColor;
    private ShapeType shapeType;
    private ShapeShadingType shadingType;

    public ShapeBuilder setPaintCanvas(PaintCanvasBase paintCanvas) {
        this.paintCanvas = paintCanvas;
        return this;
    }

    public ShapeBuilder setTwoPoint(DrawingPoint drawingPoint) {
        this.drawingPoint = drawingPoint;
        return this;
    }

    public ShapeBuilder setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
        return this;
    }

    public ShapeBuilder setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
        return this;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
    public ShapeBuilder setDrawingPoint(DrawingPoint drawingPoint) {
        this.drawingPoint = drawingPoint;
        return this;
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
    public ShapeBuilder setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
        return this;
    }

    public ShapeBuilder setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
        return this;
    }

    public Shape build() {
        return new Shape(paintCanvas, drawingPoint, primaryColor, secondaryColor, shapeType, shadingType);
    }
<<<<<<< HEAD


=======
<<<<<<< HEAD


=======
<<<<<<< HEAD


=======
<<<<<<< HEAD


=======
>>>>>>> 43e7d5abda30d3a04a7d48972fd97ac45e870dde
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
}
