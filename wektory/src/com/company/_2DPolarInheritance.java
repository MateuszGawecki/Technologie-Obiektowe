package com.company;

import static java.lang.Math.atan;

public class _2DPolarInheritance extends Vector2D{

    public _2DPolarInheritance(double x, double y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "\nKartezjanskie: x = " + this.getComponents()[0] + " y = " + this.getComponents()[1] + "\nBieguowe: r =  " + this.abs() + "alfa = " + this.getAngle();
    }

    public double getAngle(){
        //TODO Z użyciem funkcji cyklometrycznych zwrócić kąt między osią OX, a wektorem IVector
        double[] tab = this.getComponents();
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

    private double radToAngle(double rad){
        return (rad * 360) / (2 * Math.PI);
    }
}
