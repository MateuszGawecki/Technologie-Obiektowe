package com.company;

public class HasNoSymptoms implements IState{
    private final Human human;

    public HasNoSymptoms(Human human) {
        this.human = human;
    }

    @Override
    public void handle() {
        System.out.println("nie ma symptomy");
        human.setState(human.getHasNoSymptoms());
    }

    @Override
    public String toString()
    {
        return "nie ma symptomow";
    }
}
