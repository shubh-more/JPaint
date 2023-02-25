package model;

import model.interfaces.IShape;

public class OutlineDecorator {
    private OutlineDecorator outlineDrawer;

    void draw(IShape shape) {
        outlineDrawer = new OutlineDecorator();
        outlineDrawer.draw(shape);
    }
}
