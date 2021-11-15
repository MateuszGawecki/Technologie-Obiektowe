package com.company;

public class ISSick implements IState{
    private final Human human;

    public ISSick(Human human) {
        this.human = human;
    }

    @Override
    public void handle() {
        System.out.println("jest chory");
        human.setState(human.getiSSick());
    }
}
