package model;

import model.interfaces.InterfaceShape;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class DesigningShape {


    PaintCanvasBase paintCanvas;


    public DesigningShape(PaintCanvasBase paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    public void borderingGroup(InterfaceShape s){
        int groupWidth = s.getShapeGroup().getMaximumXY().x - s.getShapeGroup().MinimumXY().x;
        int groupHeight = s.getShapeGroup().getMaximumXY().y - s.getShapeGroup().MinimumXY().y;

        Graphics2D graphics = paintCanvas.getGraphics2D();
        Stroke st = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics.setStroke(st);
        graphics.setColor(Color.BLACK);
        graphics.drawRect(s.getShapeGroup().MinimumXY().x -5, s.getShapeGroup().MinimumXY().y-5, groupWidth+10,groupHeight+10);
    }

    public void borderingShape(InterfaceShape s){
        Graphics2D graphics = paintCanvas.getGraphics2D();
        Stroke st = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics.setStroke(st);
        graphics.setColor(Color.BLACK);
        if(s.getOneShape().getShapeType()== ShapeTypes.RECTANGLE && (s.getOneShape().SelectedShapes == true)){
            graphics.drawRect(s.getOneShape().getMinXY().x-5, s.getOneShape().getMinXY().y-5, s.getOneShape().getWidth()+10, s.getOneShape().getHeight()+10);
        }
       else if(s.getOneShape().getShapeType()== ShapeTypes.ROUNDEDRECTANGLE && (s.getOneShape().SelectedShapes == true)){
            graphics.drawRoundRect(s.getOneShape().getMinXY().x-5, s.getOneShape().getMinXY().y-5, s.getOneShape().getWidth()+10, s.getOneShape().getHeight()+10,18,18);
        }
        else if(s.getOneShape().getShapeType()== ShapeTypes.ARC && (s.getOneShape().SelectedShapes == true)){
            graphics.drawArc(s.getOneShape().getMinXY().x-5, s.getOneShape().getMinXY().y-5, s.getOneShape().getWidth()+10, s.getOneShape().getHeight()+10,0,180);
        }

        else if(s.getOneShape().getShapeType()== ShapeTypes.ELLIPSE && (s.getOneShape().SelectedShapes == true)){
            graphics.drawOval(s.getOneShape().getMinXY().x-5, s.getOneShape().getMinXY().y-5, s.getOneShape().getWidth()+10, s.getOneShape().getHeight()+10);
//            System.out.println("ShapeTypes: " + s.getShapeType());
        }
        else if(s.getOneShape().getShapeType()== ShapeTypes.HEXAGON && (s.getOneShape().SelectedShapes == true)){


            int startArray[] = new int[6];
            int endArray[] = new int[6];

            int x = (int) s.getOneShape().startCoordinates.getA();
            int y = (int)s.getOneShape().startCoordinates.getB();
            int R = s.getOneShape().startCoordinates.getA()-s.getOneShape().endCoordinates.getA();

            int[][] xy = getPolygonArrays(x, y, R,6);
            Polygon polygon= new Polygon(xy[0], xy[1], 6);
            graphics.drawPolygon(polygon);

           }

        else if(s.getOneShape().getShapeType()== ShapeTypes.PENTAGON && (s.getOneShape().SelectedShapes == true)){


            int startArray[] = new int[5];
            int endArray[] = new int[5];

            int x = (int) s.getOneShape().endCoordinates.getA();
            int y = (int)s.getOneShape().startCoordinates.getB();
            int R = s.getOneShape().startCoordinates.getA()-s.getOneShape().endCoordinates.getA();

            int[][] xy = getPolygonArrays(x, y, R,5);
            Polygon polygon= new Polygon(xy[0], xy[1], 5);
            graphics.drawPolygon(polygon);
        }
        else if(s.getOneShape().getShapeType()== ShapeTypes.OCTAGON && (s.getOneShape().SelectedShapes == true)){


            int startArray[] = new int[8];
            int endArray[] = new int[8];

            int x = (int) s.getOneShape().startCoordinates.getA();
            int y = (int)s.getOneShape().startCoordinates.getB();
            int R = s.getOneShape().startCoordinates.getA()-s.getOneShape().endCoordinates.getA();

            int[][] xy = getPolygonArrays(x, y, R,8);
            Polygon polygon= new Polygon(xy[0], xy[1], 8);
            graphics.drawPolygon(polygon);

        }
        else if(s.getOneShape().getShapeType()== ShapeTypes.DECAGON && (s.getOneShape().SelectedShapes == true)){


            int startArray[] = new int[10];
            int endArray[] = new int[10];

            int x = (int) s.getOneShape().startCoordinates.getA();
            int y = (int)s.getOneShape().startCoordinates.getB();
            int R = s.getOneShape().startCoordinates.getA()-s.getOneShape().endCoordinates.getA();

            int[][] xy = getPolygonArrays(x, y, R,10);
            Polygon polygon= new Polygon(xy[0], xy[1], 10);
            graphics.drawPolygon(polygon);

        }

        else if(s.getOneShape().getShapeType()== ShapeTypes.TRIANGLE && (s.getOneShape().SelectedShapes == true)){
            //UPDATE LATER
            Point newPoint = new Point(s.getOneShape().getStartPoint().x, s.getOneShape().getEndPoint().y);

            int startArray[] = new int[3];
            int endArray[] = new int[3];

            startArray[0] = s.getOneShape().getStartPoint().getA();
            startArray[1] = s.getOneShape().getEndPoint().getA();
            startArray[2] = (int)newPoint.getX();

            endArray[0] = s.getOneShape().getStartPoint().getB();
            endArray[1] = s.getOneShape().getEndPoint().getB();
            endArray[2] = (int)newPoint.getY();

            graphics.drawPolygon(startArray,endArray,3);
        }
        else if(s.getOneShape().getShapeType()== ShapeTypes.STAR && (s.getOneShape().SelectedShapes == true)) {

            int midX = s.getOneShape().startCoordinates.getA();
            int midY = s.getOneShape().startCoordinates.getB();
            int diff=s.getOneShape().startCoordinates.getA()-s.getOneShape().endCoordinates.getA();
            if(diff<0)
            {
                diff=diff*(-1);
            }
            int radius[] = {diff,diff/3,diff/2,diff/3};
            int nPoints = 16;
            int[] X = new int[nPoints];
            int[] Y = new int[nPoints];

            for (double current=0.0; current<nPoints; current++)
            {
                int i = (int) current;
                double x = Math.cos(current*((2*Math.PI)/16))*radius[i % 4];
                double y = Math.sin(current*((2*Math.PI)/16))*radius[i % 4];

                X[i] = (int) x+midX;
                Y[i] = (int) y+midY;
            }
            graphics.drawPolygon(X, Y, nPoints);

        }
        else if(s.getOneShape().getShapeType()== ShapeTypes.ARROW && (s.getOneShape().SelectedShapes == true)) {

            int x0 = (int) s.getOneShape().startCoordinates.getA();
            int y0 = (int)s.getOneShape().startCoordinates.getB();
            int x1= (int) s.getOneShape().endCoordinates.getA();
            int y1 = (int)s.getOneShape().endCoordinates.getB();

            int headLength=10;
            int headAngle=40;
            double offs = headAngle * Math.PI / 180.0;
            double angle = Math.atan2(y0 - y1, x0 - x1);
            int[] xs = { x1 + (int) (headLength * Math.cos(angle + offs)), x1,
                    x1 + (int) (headLength * Math.cos(angle - offs)) };
            int[] ys = { y1 + (int) (headLength * Math.sin(angle + offs)), y1,
                    y1 + (int) (headLength * Math.sin(angle - offs)) };

            graphics.drawLine(x0, y0, x1, y1);
            graphics.drawPolygon(xs, ys, 3);

        }
        else if(s.getOneShape().getShapeType()== ShapeTypes.Diamond && (s.getOneShape().SelectedShapes == true)) {


            int startX = Math.min(s.getOneShape().startCoordinates.getA(), s.getOneShape().endCoordinates.getA());
            int endX = Math.max(s.getOneShape().startCoordinates.getA(), s.getOneShape().endCoordinates.getA());
            int startY = Math.min(s.getOneShape().startCoordinates.getB(), s.getOneShape().endCoordinates.getB());
            int endY = Math.max(s.getOneShape().startCoordinates.getB(), s.getOneShape().endCoordinates.getB());

            int width = endX - startX;
            int height = endY - startY;

            AffineTransform at = AffineTransform.getTranslateInstance(startX, startY);
            Shape shape = at.createTransformedShape(new Diamond(width,height));
            graphics.draw(shape);


        }
        else if(s.getOneShape().getShapeType()== ShapeTypes.LINE && (s.getOneShape().SelectedShapes == true)) {
            int startX = s.getOneShape().startCoordinates.getA();
            int endX = s.getOneShape().endCoordinates.getA();
            int startY = s.getOneShape().startCoordinates.getB();
            int endY = s.getOneShape().endCoordinates.getB();

            graphics.drawLine(startX,startY,endX,endY);
        }
        else if (s.getOneShape().SelectedShapes == false){
            System.out.println("this shape ain't selected!");
        }
    }


    int[][] getPolygonArrays(int cx, int cy, int R,int n) {
        int[] x = new int[n];
        int[] y = new int[n];
        double thetaInc = 2*Math.PI/n;
        double theta = (n % 2 == 0) ? thetaInc : -Math.PI/2;
        for(int j = 0; j < n; j++) {
            x[j] = (int)(cx + R*Math.cos(theta));
            y[j] = (int)(cy + R*Math.sin(theta));
            theta += thetaInc;
        }
        return new int[][]{ x, y };
    }



    public class Diamond extends Path2D.Double {

        public Diamond(double width, double height) {
            moveTo(0, height / 2);
            lineTo(width / 2, 0);
            lineTo(width, height / 2);
            lineTo(width / 2, height);
            closePath();
        }

    }


}
