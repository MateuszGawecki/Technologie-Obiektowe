package com.company;


import java.util.Random;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Random r = new Random();
        double newX, newY=0;
        double maxDist = 0.1;
        double minDist = 0;

        //----------------------------
        IVector vector = new Vector2D(9, 2);
        Human chuj = new Human(1, 2, vector);

//        chuj.setState(new IsHealthly(chuj));


        System.out.println(chuj.getState());



        //------------------------------


//        for(int i=0 ; i<200; i++){
//            newX = r.nextDouble()*(maxDist);
//            newY = r.nextDouble()*(maxDist-newX);
//
//            double abs=sqrt(newX*newX + newY * newY);
//            System.out.println(abs);
//        }
    }
}
