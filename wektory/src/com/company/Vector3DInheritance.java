package com.company;

import static java.lang.Math.sqrt;

public class Vector3DInheritance extends Vector2D{
    private double z;

    public Vector3DInheritance(double x, double y, double z){
        super(x,y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "\nKartezjanskie: x = " + this.getComponents()[0] + " y = " + this.getComponents()[1] + " z = " + this.getComponents()[2];
    }

    @Override
    public double abs() {
        double[] tab = super.getComponents();

        return sqrt((tab[0] * tab[0]) + (tab[1] * tab[1]) + (z * z) );
    }

    @Override
    public double cdots(IVector param) {
        double cdot = 0;
        double[] tab1 = this.getSrcV().getComponents();
        double[] tab = param.getComponents();

        for (int i = 0; i<this.getComponents().length ; i++) {
            cdot += tab1[i] * tab[i];
        }
        return cdot;
    }

    @Override
    public double[] getComponents() {
        double[] tab = super.getComponents();
        double[] tab2 = new double[3];

        tab2[0] = tab[0];
        tab2[1] = tab[1];
        tab2[2] = z;

        return tab2;
    }

    public Vector3DInheritance cross(IVector param){
        double newX, newY, newZ;
        double[] tab1, tab2;
        tab1 = this.getComponents();
        tab2 = param.getComponents();

        if(tab1.length!=tab2.length){
            System.out.println("Operacja niemozliwa");
            return null;
        }

        newX = (tab1[1] * tab2[2]) - (tab1[2] * tab2[1]);
        newY = (tab1[2] * tab2[0]) - (tab1[0] * tab2[2]);
        newZ = (tab1[0] * tab2[1]) - (tab1[1] * tab2[0]);

        return new Vector3DInheritance(newX,newY,newZ);
    }

    public IVector getSrcV(){
        return  new Vector2D(super.getComponents()[0],super.getComponents()[1]);
    }
}
