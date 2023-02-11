package model.interfaces;

import java.awt.*;

public interface IShape {

    void draw();

    void clear();
    int  getLeftCornerX();

    int getLeftCornerY();

    int getWidth();

    int getHeight();

    void draw(Graphics2D g);

    void clear(Graphics2D g);
}
