package com.company;

public class Convert implements Kantor{
    private float amountEnd;

    public void getResult(UserDataProvider udp){
        udp.getDataFromUser();

        Repository rep = Repository.getInstance();
        Currency currency1 = rep.getByCode(udp.getCode1());
        Currency currency2 = rep.getByCode(udp.getCode2());

        amountEnd = udp.getAmount() * currency1.getRate() / (currency1.getConversionRatio()
                * currency2.getRate() ) * currency2.getConversionRatio();
    }

    public void printAmountEnd() {
        System.out.println("Ilosc waluty koncowej " + getAmountEnd());
    }

    public float getAmountEnd() {
        return amountEnd;
    }
}
