package model;

import model.ShapesImplemented.*;
import model.interfaces.InterfaceShape;

public class ShapeOptions {
    public InterfaceShape makeShape(Shapes shapes) {

            InterfaceShape interfaceShape;
            switch (shapes.typesOfShape) {
                case RECTANGLE:
                    // System.out.println("RECTANGLE!");
                    interfaceShape = new RectangleShape(shapes);
                    break;
                case ELLIPSE:
                    // System.out.println("ELLIPSE!");
                    interfaceShape = new EllipseShape(shapes);
                    break;
                case HEXAGON:
                    // System.out.println("Hexagon!");
                    interfaceShape = new HexagonShape(shapes);
                    break;
                case STAR:
                    // System.out.println("Star!");
                    interfaceShape = new StarShape(shapes);
                    break;
                case PENTAGON:
                    // System.out.println("Pentagon!");
                    interfaceShape = new PentagonShape(shapes);
                    break;
                case ARROW:
                    // System.out.println("Arrow!");
                    interfaceShape = new UparrowShape(shapes);
                    break;
                case Diamond:
                    // System.out.println("Diamond!");
                    interfaceShape = new DiamondShape(shapes);
                    break;
                case ARC:
                    // System.out.println("Arc!");
                    interfaceShape = new ArcShape(shapes);
                    break;
                case LINE:
                    // System.out.println("Line!");
                    interfaceShape = new LineShape(shapes);
                    break;
                case ROUNDEDRECTANGLE:
                    // System.out.println("Rounded Rectangle!");
                    interfaceShape = new RoundedRectangleShape(shapes);
                    break;
                case DECAGON:
                    // System.out.println("Decagon!");
                    interfaceShape = new DecagonShape(shapes);
                    break;
                case OCTAGON:
                    // System.out.println("Octagon!");
                    interfaceShape = new OctagonShape(shapes);
                    break;
                default:
                    // System.out.println("Triangle!");
                    interfaceShape = new TriangleShape(shapes);
                    break;
            }

            return interfaceShape;
        }
    }