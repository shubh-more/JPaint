package model;

import model.interfaces.IShape;

<<<<<<< HEAD
import java.awt.*;

public class OutlineDecorator {

    private OutlineDrawer outlineDrawer;

    void draw(IShape shape) {
        outlineDrawer = new OutlineDrawer();
        outlineDrawer.draw(shape);
    }

=======
public class OutlineDecorator {
    private OutlineDecorator outlineDrawer;

    void draw(IShape shape) {
        outlineDrawer = new OutlineDecorator();
        outlineDrawer.draw(shape);
    }
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
}
