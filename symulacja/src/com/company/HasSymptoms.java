package com.company;

public class HasSymptoms implements IState{
    private final Human human;

    public HasSymptoms(Human human) {
        this.human = human;
    }

    @Override
    public void handle() {
        System.out.println("ma symptomy");
        human.setState(human.getHasSymptopms());
    }
}
