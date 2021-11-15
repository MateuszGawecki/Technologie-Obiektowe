package com.company;

public class IsResistant implements IState{
    private final Human human;

    public IsResistant(Human human) {
        this.human = human;
    }

    @Override
    public void handle() {
        System.out.println("jest odporny");
        human.setState(human.getIsResistant());
    }
}
