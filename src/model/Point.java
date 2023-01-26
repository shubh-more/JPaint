package model;

public class Point {
/*This class is for storing the coordinate all other class will able to use it with getter and
use it for creating shape
 */
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

