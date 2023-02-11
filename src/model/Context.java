package model;

import model.interfaces.IStrategy;

public class Context {
    private IStrategy iStrategy;

    public void setMouseMode(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public void execute(){
        iStrategy.run();
    }
}


