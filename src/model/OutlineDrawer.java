package model;

import model.interfaces.IShape;

import java.awt.*;

public class OutlineDrawer {

    public void draw(IShape s) {
        Graphics2D g = s.getShape().getPaintCanvas().getGraphics2D();
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1,
                new float[]{9}, 0);
        g.setStroke(stroke);
        g.setColor(Color.BLACK);
        if (s.getShape().getShapeType() == ShapeType.RECTANGLE) {
            g.drawRect(s.getShape().getDrawingPoint().getMinXY().getX() - 5,
                    s.getShape().getDrawingPoint().getMinXY().getY() - 5,
                    s.getShape().getDrawingPoint().getWidth() + 10, s.getShape().getDrawingPoint().getHeight() + 10);
        } else if (s.getShape().getShapeType() == ShapeType.ELLIPSE) {
            g.drawOval(s.getShape().getDrawingPoint().getMinXY().getX() - 5,
                    s.getShape().getDrawingPoint().getMinXY().getY() - 5,
                    s.getShape().getDrawingPoint().getWidth() + 10, s.getShape().getDrawingPoint().getHeight() + 10);
        } else if (s.getShape().getShapeType() == ShapeType.TRIANGLE) {

            Point newPoint = new Point(s.getShape().getDrawingPoint().getStartPoint().getX(),
                    s.getShape().getDrawingPoint().getEndPoint().getY());

            int startArray[] = new int[3];
            int endArray[] = new int[3];

            startArray[0] = s.getShape().getDrawingPoint().getStartPoint().getX();
            startArray[1] = s.getShape().getDrawingPoint().getEndPoint().getX();
            startArray[2] = (int) newPoint.getX();

            endArray[0] = s.getShape().getDrawingPoint().getStartPoint().getY();
            endArray[1] = s.getShape().getDrawingPoint().getEndPoint().getY();
            endArray[2] = (int) newPoint.getY();

            g.drawPolygon(startArray, endArray, 3);
        }
    }
}
