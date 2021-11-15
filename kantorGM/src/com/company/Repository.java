package com.company;

import java.util.HashMap;
import java.util.Map;


public class Repository{

    private final Map<String , Currency> mapOfCurrencies;
    private static Repository instance = null;

    public  static Repository getInstance(){
        if(instance == null){
            instance = new Repository();
        }

        return instance;
    }

    public void printCurrencies(){

        for (Currency curr: mapOfCurrencies.values()) {
            System.out.println(curr);
        }
    }

    public Currency getByCode(String code){
        return mapOfCurrencies.get(code);
    }

    public void addToMap(Currency curr){
        mapOfCurrencies.put(curr.getCode(),curr);
    }

    public boolean existInMap(String code){
        return mapOfCurrencies.containsKey(code);
    }

    private Repository(){
        this.mapOfCurrencies = new HashMap<>();
        this.mapOfCurrencies.put("PLN", new Currency("zloty","PLN",1,1));
    }
}
