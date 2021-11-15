package com.company;

public class IsHealthly implements IState{
    private final Human human;

    public IsHealthly(Human human) {
        this.human = human;
    }

    @Override
    public void handle() {
        System.out.println("jest zdrowy");
        human.setState(human.getIsHealthly());
    }

    @Override
    public String toString()
    {
        return "jest zdrowy";
    }
}
