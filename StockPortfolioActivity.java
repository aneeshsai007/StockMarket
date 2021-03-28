package com.example.lahacks;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.round;

public class StockPortfolioActivity implements java.io.Serializable {
    HashMap<StockActivity, ArrayList<Integer>> a;
    String name;
    int currentReturn;
    public StockPortfolioActivity(String n){
        name = n;
        a = new HashMap<StockActivity, ArrayList<Integer>>();
    }
    public void add(String name, String abb, double price, int shares,StockActivity c){
        int success = 0;
        for(StockActivity s:a.keySet()){
            if(s.companyAbb.equals(abb)){
                // System.out.println("Adding last values" + a.get(s).get(a.get(s).size()-1));
                a.get(s).add(a.get(s).get(a.get(s).size()-1) + shares);
                success++;
            }
        }
        //if(!a.containsKey(c)){
        if(success==0){
            ArrayList<Integer> b = new ArrayList<Integer>();
            b.add(shares);
            a.put(c, b);
        }
        //}
     /*else{

         a.get(c).add(a.get(c).get(a.get(c).size()-1) + shares);
     }*/
    }
    public void subtract(String name, String abb, double price, int shares,StockActivity c){
        int success = 0;
        for(StockActivity s:a.keySet()){
            if(s.companyAbb.equals(abb)){
                a.get(s).add(a.get(s).get(a.get(s).size()-1) - shares);
                success++;
            }
        }
        //if(!a.containsKey(c)){
        if(success==0){
            ArrayList<Integer> b = new ArrayList<Integer>();
            b.add(shares);
            a.put(c, b);
        }
        //}
     /*else{

         a.get(c).add(a.get(c).get(a.get(c).size()-1) + shares);
     }*/
    }
    public String printDetails(HashMap<StockActivity, ArrayList<PriceActivity>> stockPrice){
        String output = "";
        for(StockActivity s : a.keySet()){
            output += s.companyName + "\tvalue: $" +round(s.price) + "\n" +  s.companyAbb + "\t Your shares:" + a.get(s).get(a.get(s).size()-1);
            output += "\n\t     Total:$" + round(a.get(s).get(a.get(s).size()-1) * s.price);
            output += "\n\n";
        }
        return output;
    }

}
