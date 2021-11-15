package com.company;

import java.util.Scanner;

public class UserDataProvider {
    private String code1;
    private String code2;
    private float amount;
    private final Scanner input;

    public UserDataProvider(){
        input = new Scanner(System.in);
    }

    public void getDataFromUser(){
        //wyswietlenie możliwych kodow
        Repository rep = Repository.getInstance();

        rep.printCurrencies();

        String line;

        System.out.println("Podaj kod waluty poczatkowej");
        line = input.nextLine();
        while(!rep.existInMap(line.toUpperCase()))
        {
            System.out.println("Nie ma takiej waluty. Sprobuj ponownie ");
            line = input.nextLine();
        }
        code1 = line.toUpperCase();

        System.out.println("Podaj ilosc waluty poczatkowej");
        line = input.nextLine();
        float val;
        while(true){
            val = Float.parseFloat(line.replace(",","."));
            if(val > 0) break;
            else System.out.println("Nieobsługiwana wartosc");
            line = input.nextLine();
        }
        amount =  val;

        System.out.println("Podaj kod waluty koncowej");
        line = input.nextLine();
        while(!rep.existInMap(line.toUpperCase()))
        {
            System.out.println("Nie ma takiej waluty. Sprobuj ponownie ");
            line = input.nextLine();
        }
        code2 = line.toUpperCase();
    }

    public String getCode1() {
        return code1;
    }

    public String getCode2() {
        return code2;
    }

    public float getAmount() {
        return amount;
    }
}
