package com.company;

public class Currency {
    private String name;
    private String code;
    private int conversionRatio;
    private float rate;

    public Currency(String name, String code, int conversionRatio, float rate){
        this.name = name;
        this.code = code;
        this.conversionRatio = conversionRatio;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getConversionRatio() {
        return conversionRatio;
    }

    public float getRate() {
        return rate;
    }

    public String toString(){
        return getCode() + " " + getName() + " Przelicznik " + getConversionRatio() + " Kurs " + getRate();
    }
}
