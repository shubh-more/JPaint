package model;

import model.interfaces.IShape;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b
import java.awt.*;

public class OutlineDecorator {

    private OutlineDrawer outlineDrawer;

    void draw(IShape shape) {
        outlineDrawer = new OutlineDrawer();
        outlineDrawer.draw(shape);
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
public class OutlineDecorator {
    private OutlineDecorator outlineDrawer;

    void draw(IShape shape) {
        outlineDrawer = new OutlineDecorator();
        outlineDrawer.draw(shape);
    }
>>>>>>> e9b97843ebf7b107a65bd1254acc6976c68d15ae
>>>>>>> 348ef257c98d2c10390d80ac8e8d5f6110a45db9
>>>>>>> d33abee21f4ad1003b6b53981de6f758cba492ba
>>>>>>> 68eae46d93519d927b4dd63f9a174fe79b98e91b
}
