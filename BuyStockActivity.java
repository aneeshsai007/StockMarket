package com.example.lahacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BuyStockActivity extends AppCompatActivity {
    String n;
    String stockName;
    int numShares;
    HashMap<StockActivity, ArrayList<PriceActivity>> t = new HashMap<StockActivity, ArrayList<PriceActivity>>();
    HashMap<String, String> conversion = new HashMap<String, String>(); // name to abbreviation
    HashMap<String, StockPortfolioActivity> z = new HashMap<String, StockPortfolioActivity>();
    StockPortfolioActivity current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_stock);
        getData();
        conversion.put("Amazon", "AMZN");
        conversion.put("Tesla", "TSLA");
        conversion.put("Apple", "AAPL");
        conversion.put("General Electric", "GE");
        conversion.put("AT&T", "T");
        conversion.put("Coca Cola", "KO");
        conversion.put("Starbucks", "SBUX");
        conversion.put("Nike", "NIKE");


      /*
      if (response == 1) {
          System.out.println("What company stock would you like to purchase? Enter the name: ");
          reader = new Scanner(System.in);
          String stockName = reader.next();

       */
        Button buy = (Button) findViewById(R.id.buy2Button);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText)findViewById(R.id.personNameText);
                EditText compName = (EditText)findViewById(R.id.companyNameText);
                EditText nuShares = (EditText)findViewById(R.id.numSharesText);
                n = name.getText().toString();
                stockName = compName.getText().toString();
                numShares = Integer.parseInt(nuShares.getText().toString());
                if(z.containsKey(n)){
                    current = z.get(n);

                }
                else  {
                    z.put(n, new StockPortfolioActivity(n));

                }
                String stockAbb = conversion.get(stockName);
                current = z.get(n);
      /*
      System.out.println("How many shares would you like to purchase?");
          reader = new Scanner(System.in);
          int numShares = reader.nextInt();

       */
                //StockActivity a = new StockActivity(stockName, stockAbb, 3000.00);
          /*
          System.out.println(a.companyName);
          System.out.println(a.companyAbb);
          System.out.println(a.equals(new StockActivity(stockName, stockAbb, 2000.00)));
          System.out.println(stockPrice.get(a));
           */
                for (StockActivity s : t.keySet()) {
                    //System.out.println(s.companyAbb);
                    //System.out.println("comp gjgjgjgjgjg");
                    if (s.companyAbb.equals(stockAbb)) {
                        //System.out.println("comp abbbbbbbbbb");
                        current.add(s.companyName, s.companyAbb, t.get(s).get(t.get(s).size() - 1).price, numShares, s);
                    }
                }
                //System.out.println(current + "   current");
                //System.out.println(current.printDetails(t));

            }
        });
        Button home = (Button) findViewById(R.id.stockh);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(t,z);
            }
        });
       /*
       current = z.get(n);

      System.out.println("How many shares would you like to purchase?");
          reader = new Scanner(System.in);
          int numShares = reader.nextInt();


       StockActivity a = new StockActivity(stockName, stockAbb, 3000.00);
          /*
          System.out.println(a.companyName);
          System.out.println(a.companyAbb);
          System.out.println(a.equals(new StockActivity(stockName, stockAbb, 2000.00)));
          System.out.println(stockPrice.get(a));

       for (StockActivity s : t.keySet()) {
           if (s.companyAbb.equals(stockAbb)) {
               current.add(s.companyName, s.companyAbb, t.get(s).get(t.get(s).size() - 1).price, numShares, s);
           }
       }*/
        //current.add(a.companyName, a.companyAbb, stockPrice.get(a).get(stockPrice.get(a).size() - 1).price, numShares);
    }//stockPrice.get(a).size() - 1

    private void sendData(HashMap<StockActivity, ArrayList<PriceActivity>>a,HashMap<String,StockPortfolioActivity>b){
        //System.out.println("BUYYYYYYSTOCKKKKKKK");
       /*for(String s:z.keySet()){
           current = z.get(s);
           System.out.println(s + "    " + current.printDetails(t));
       }
       System.out.println(z);*/
        Intent intent = new Intent(this, MainStockActivity.class);
        intent.putExtra("map", a);
        intent.putExtra("names", b);
        startActivity(intent);
    }
    private void getData(){
        Intent intent = getIntent();
        t = (HashMap<StockActivity, ArrayList<PriceActivity>>) intent.getSerializableExtra("map");
        z = (HashMap<String, StockPortfolioActivity>) intent.getSerializableExtra("names");
       /*for(StockActivity s:t.keySet()){
           System.out.println(t.get(s).get(0));
       }*/
    }
}
