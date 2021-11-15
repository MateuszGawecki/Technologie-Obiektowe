package com.company;

public class IsNotResistant implements IState{
    private final Human human;

    public IsNotResistant(Human human) {
        this.human = human;
    }

    @Override
    public void handle() {
        System.out.println("nie jest odporny");
        human.setState(human.getIsNotResistant());
    }
}
