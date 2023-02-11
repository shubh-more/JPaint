package model;

/**
 * Class will store the coordinate and other class will derive it from getter and setter
 *
 *  Sprint 2: Setter implemented for observer pattern, it will update the new
 *  coordinate once shape get notified
 */
public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
