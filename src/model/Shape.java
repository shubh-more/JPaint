package model;

import view.interfaces.PaintCanvasBase;

import java.awt.*;

/**
 *     This is builder pattern for shape builder, and this is a class for storing parameters so other class are
 *     able to access it through getter.
 */
public class Shape {

    private PaintCanvasBase paintCanvas;
    private DrawingPoint drawingPoint;
    private Color primaryColor;
    private Color secondaryColor;
    private ShapeType shapeType;
    private ShapeShadingType shadingType;

    public Shape(PaintCanvasBase paintCanvas, DrawingPoint drawingPoint, Color primaryColor,
                 Color secondaryColor, ShapeType shapeType, ShapeShadingType shadingType) {
        this.paintCanvas = paintCanvas;
        this.drawingPoint = drawingPoint;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shapeType = shapeType;
        this.shadingType = shadingType;
    }






        public PaintCanvasBase getPaintCanvas() {
            return paintCanvas;
        }

        public DrawingPoint getDrawingPoint() {
            return drawingPoint;
        }

        public Color getPrimaryColor() {
            return primaryColor;
        }

        public Color getSecondaryColor() {
            return secondaryColor;
        }

        public ShapeType getShapeType() {
            return shapeType;
        }

        public ShapeShadingType getShadingType() {
            return shadingType;
        }
    }
