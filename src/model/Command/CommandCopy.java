package model.Command;

import model.ShapeList;
import model.interfaces.ICommand;
import model.interfaces.IShape;

import java.util.Stack;

public class CommandCopy implements ICommand {

    ShapeList shapeList;
    Stack<IShape> myClipBoard;

    public CommandCopy(ShapeList shapeList) {this.shapeList=shapeList;
    }

    @Override
    public void run() {
        if (shapeList.getSelectList().isEmpty()) {
            return;
        }
        myClipBoard = shapeList.getClipboard();
        for (IShape shape : shapeList.getSelectList().lastElement()) {
            myClipBoard.add(shape);
        }
        CommandMemory.add(this);
    }

    @Override
    public void undo() {
        myClipBoard.clear();

    }

    @Override
    public void redo() {
        for (IShape shape : shapeList.getSelectList().lastElement()) {
            myClipBoard.add(shape);
        }
    }
}
