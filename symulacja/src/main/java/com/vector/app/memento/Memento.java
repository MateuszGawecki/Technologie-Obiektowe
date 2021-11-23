package com.vector.app.memento;

import com.vector.app.simulation.population.Population;

public class Memento {
    private Population population;

    public Memento(Population newPopulation){ population=newPopulation;}

    public Population getSavedPopulation(){return population;}
}
