package com.company;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Vector2D w1 = new Vector2D(3,8);
        Vector2D w2 = new Vector2D(-20,-4);

        Polar2DAdapter wektor1 = new Polar2DAdapter(w1);
        Polar2DAdapter wektor2 = new Polar2DAdapter(w2);

        _2DPolarInheritance wektor3 = new _2DPolarInheritance(2,-5);

        System.out.println("\nWspolrzedne kartezjanskie i biegunowe");

        System.out.println("\nWektor 1" + wektor1);
        System.out.println("\nWektor 2" + wektor2);
        System.out.println("\nWektor 3" + wektor3);

        //iloczyny skalarne
        System.out.println("\nIloczyny skalarne");
        System.out.println("wektor1 razy wektor2 " + wektor1.cdots(wektor2));
        System.out.println("wektor1 razy wektor3 " + wektor1.cdots(wektor3));
        System.out.println("wektor2 razy wektor3 " + wektor2.cdots(wektor3));

        //iloczyny wektorowe
        Vector3DDecorator wektor3d1 = new Vector3DDecorator(w1);
        Vector3DDecorator wektor3d2 = new Vector3DDecorator(w2);
        Vector3DInheritance wektor3d3 = new Vector3DInheritance(2, -5, 0);
        System.out.println("\nIloczyny wektorowe");

        System.out.println("wektor1 x wektor1 " + wektor3d1.cross(wektor3d1));

        System.out.println("wektor1 x wektor2 " + wektor3d1.cross(wektor3d2));
        System.out.println("wektor1 x wektor3 " + wektor3d1.cross(wektor3d3));
        System.out.println("wektor2 x wektor3 " + wektor3d2.cross(wektor3d3));

        System.out.println("wektor2 x wektor1 " + wektor3d2.cross(wektor3d1));
        System.out.println("wektor3 x wektor1 " + wektor3d3.cross(wektor3d1));
        System.out.println("wektor3 x wektor2 " + wektor3d3.cross(wektor3d2));
    }
}
