package com.company;

import java.util.Scanner;

public class menu {
    public menu(){
        Scanner scan = new Scanner(System.in);
        XMLParser par = new XMLParser();
        par.createRepository();
        Convert con = new Convert();
        UserDataProvider udp = new UserDataProvider();


        while (true){
            System.out.println("Nacisnij 1 aby przeliczyc waluty lub inny klawisz aby przerwac");

            if(scan.nextLine().equals("1")){
                con.getResult(udp);
                con.printAmountEnd();
            }
            else {
                break;
            }
        }
    }
}
