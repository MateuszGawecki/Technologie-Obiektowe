package com.company;

import static java.lang.Math.sqrt;

public class Vector2D implements IVector {
    private final double x;
    private final double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double[] getComponents() {
        double[] comp = new double[2];
        comp[0] = x;
        comp[1] = y;

        return comp;
    }

    @Override
    public double cdots(IVector param) {
        double[] tab = param.getComponents();
        return this.x * tab[0] + this.y * tab[1];
    }

    @Override
    public double abs() {
        return sqrt((this.x*this.x) + (this.y*this.y));
    }
}
