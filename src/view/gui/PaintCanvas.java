package view.gui;

import model.ShapeList;
import view.interfaces.PaintCanvasBase;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends PaintCanvasBase {

    ShapeList shapeList;

    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }

    public PaintCanvas(ShapeList shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    /**
     * This is an event handler.  If this function gets called, its time to
     * draw the entire picture.
     * It you want to force a paint event, call aPaintCanvas.repaint()
     */
    public void paint(Graphics g) {
        super.paint(g);

        shapeList.getShapeList().forEach(shape -> shape.repaint(g));
    }
}
