package com.company;

import static java.lang.Math.sqrt;

public class Vector3DDecorator implements IVector{
    private final IVector srcVector;
    private double z;

    public Vector3DDecorator(IVector srcVector) {
        this.srcVector = srcVector;
        this.z = 0;
    }

    private Vector3DDecorator(IVector srcVector, double z){
        this.srcVector=srcVector;
        this.z=z;
    }

    @Override
    public String toString() {
        return "\nKartezjanskie: x = " + this.getComponents()[0] + " y = " + this.getComponents()[1] + " z = " + this.getComponents()[2];
    }

    @Override
    public double abs() {
        double[] tab = this.getComponents();
        return sqrt((tab[0] * tab[0]) + (tab[1] * tab[1]) + (tab[2] * tab[2]));
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
        double[] tab = new double[3];
        double[] tabtmp = this.getSrcV().getComponents();
        tab[0]  = tabtmp[0];
        tab[1]  = tabtmp[1];
        tab[2]  = z;

        return tab;
    }

    public Vector3DDecorator cross(IVector param){
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

        return new Vector3DDecorator(new Vector2D(newX,newY),newZ);
    }

    public IVector getSrcV(){
        return this.srcVector;
    }
}
