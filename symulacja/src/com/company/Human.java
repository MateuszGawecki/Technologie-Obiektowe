package com.company;

import java.util.Random;
import static java.lang.Math.sqrt;

public class Human {
    private double coordX;
    private double coordY;
    private IVector vector;
    private IState state;
    private IState isResistant;
    private IState isNotResistant;
    private IState isHealthly;
    private IState iSSick;
    private IState hasSymptopms;
    private IState hasNoSymptoms;

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public Human(double coordX, double coordY, IVector vector) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.vector = vector;

        isResistant = new IsResistant(this);
        isNotResistant = new IsNotResistant(this);
        isHealthly = new IsHealthly(this);
        iSSick = new ISSick(this);
        hasSymptopms = new HasSymptoms(this);
        hasNoSymptoms = new HasNoSymptoms(this);

        state = isHealthly;

    }

    public void newPos(){
        this.coordX += vector.getComponents()[0];
        this.coordY += vector.getComponents()[1];
    }

    public void generateNewVector(){
        double maxDist = 0.1;
        double newX;
        double newY;
        Random r = new Random();

        for (;;){
            double route;

            newX = r.nextDouble()*(maxDist);
            newY = r.nextDouble()*(maxDist-newX);

            route = sqrt(newX * newX + newY * newY);
            if(route<=maxDist) break;
        }

        vector.setComponents(newX,newY);
    }

    public void setState(IState state){
        this.state=state;
    }

    public IState getState() {
        return state;
    }

    public IState getIsResistant(){
        return this.isResistant;
    }

    public IState getIsNotResistant(){
        return this.isNotResistant;
    }
    public IState getIsHealthly(){
        return this.isHealthly;
    }
    public IState getiSSick(){
        return this.iSSick;
    }
    public IState getHasSymptopms(){
        return this.hasSymptopms;
    }
    public IState getHasNoSymptoms(){
        return this.hasNoSymptoms;
    }
}
