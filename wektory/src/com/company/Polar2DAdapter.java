package com.company;

import static java.lang.Math.atan;

public class Polar2DAdapter implements IPolar2D,IVector{
    private final Vector2D srcVector;

    public Polar2DAdapter(Vector2D srcVector) {
        this.srcVector = srcVector;
    }

    @Override
    public String toString() {
        return "\nKartezjanskie: x = " + this.getComponents()[0] + " y = " + this.getComponents()[1] + "\nBieguowe: r =  " + this.abs() + "alfa = " + this.getAngle();
    }

    @Override
    public double abs() {
        return this.srcVector.abs();
    }

    @Override
    public double getAngle() {
        //TODO Z użyciem funkcji cyklometrycznych zwrócić kąt między osią OX, a wektorem IVector
        double[] tab = this.srcVector.getComponents();
        double tga = tab[1]/tab[0];

        if(tab[0] == 0){
            if(tab[1] > 0) return radToAngle(Math.PI/2);
            else return radToAngle(Math.PI*3/2);
        }

        if(tab[0] > 0 && tab[1] >= 0) return radToAngle(atan(tga));
        else if(tab[0] < 0 && tab[1] >= 0) return radToAngle(Math.PI + atan(tga));
        else if(tab[0] < 0 && tab[1] < 0) return radToAngle(Math.PI + atan(tga));
        //else if(tab[0] > 0 && tab[1] < 0) return radToAngle(2 * Math.PI + atan(tga));
        return radToAngle(2 * Math.PI + atan(tga));
    }

    @Override
    public double cdots(IVector param) {
        return this.srcVector.cdots(param);
    }

    @Override
    public double[] getComponents() {
        return this.srcVector.getComponents();
    }

    private double radToAngle(double rad){
        return (rad * 360) / (2 * Math.PI);
    }
}
