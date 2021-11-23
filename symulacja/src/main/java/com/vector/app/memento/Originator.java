package com.vector.app.memento;

import com.vector.app.simulation.population.Population;

public class Originator {
    private Population population;

    public void set(Population newPopulation){ population = newPopulation;}

    public Memento storeInMemento(){ return new Memento(population);}

    public Population restoreFromMemento(Memento memento){
        population = memento.getSavedPopulation();
        return population;
    }

}
