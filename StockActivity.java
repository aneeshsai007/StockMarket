package com.example.lahacks;

public class StockActivity implements java.io.Serializable  {
    String companyName;
    String companyAbb;
    double price;
    int pCount;
    double initialPrice;
    public StockActivity(String name, String ab, double p){
        companyName = name;
        companyAbb = ab;
        price =p;
        pCount = 0;
    }
    public boolean equals(StockActivity s){
        return companyAbb.equalsIgnoreCase(s.companyAbb);
    }
}
