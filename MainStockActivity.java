package com.example.lahacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

public class MainStockActivity extends AppCompatActivity {

    HashMap<StockActivity, ArrayList<PriceActivity>> stockPrice = new HashMap<StockActivity, ArrayList<PriceActivity>>();
    HashMap<String, StockPortfolioActivity> z = new HashMap<String, StockPortfolioActivity>();
    HashMap<String, String> conversion = new HashMap<String, String>(); // name to abbreviation
    StockPortfolioActivity current;
    static int count = 0;
    String y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stock);
        System.out.println(stockPrice);

        try{
            getData();
        }
        catch(Exception e){
            //System.out.println("Hi");
            stockPrice = new HashMap<StockActivity, ArrayList<PriceActivity>>();
            //System.out.println(stockPrice);

        }

        conversion.put("Amazon", "AMZN");
        conversion.put("Tesla", "TSLA");
        conversion.put("Apple", "AAPL");
        conversion.put("General Electric", "GE");
        conversion.put("AT&T", "T");
        conversion.put("Coca Cola", "KO");
        conversion.put("Starbucks", "SBUX");
        conversion.put("Nike", "NIKE");
      /*
      System.out.println("What is your name?");
      Scanner reader = new Scanner(System.in);
      String name = reader.next();
      System.out.println("How many days? Say 0 if this is your first time.");
      reader = new Scanner(System.in);
      int days = reader.nextInt();
      */
      /*
      EditText x = (EditText)findViewById(R.id.nameText);
      String name = (x.getText().toString());
       */

        for (StockActivity s : stockPrice.keySet()) {
            stockPrice.get(s).add(new PriceActivity(s.pCount));
            s.price = stockPrice.get(s).get(stockPrice.get(s).size() - 1).price;
            if (s.pCount == 0) {
                s.initialPrice = s.price;
            }
            s.pCount++;

        }
      /*
      if(z.containsKey(name)){
          current = z.get(name);
          y = current.printDetails();
      }
      else  {
          z.put(name, new StockPortfolioActivity(name));
          current = z.get(name);
      }
      Button seeInfo = (Button)findViewById(R.id.infoButton);

      seeInfo.setOnClickListener(new View.OnClickListener(){

          @Override
          public void onClick(View v) {
              TextView a = (TextView)findViewById(R.id.stockInfoText);
              a.setText(y);
          }
      });
      System.out.println(current.name);
      System.out.println("Enter 1 to buy. Enter 2 to sell.");
      reader = new Scanner(System.in);
      int response = reader.nextInt();
      */
        Button switchBuyStock = (Button) findViewById(R.id.buyMainButton);
        switchBuyStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataB(stockPrice,z);
            }
        });
        Button switchSellStock = (Button) findViewById(R.id.sellMainButton);
        switchSellStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivitiesSellStock();
            }
        });
        Button switchPrintInfo = (Button) findViewById(R.id.infoMainButton);
        switchPrintInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataP(stockPrice);
            }
        });
        Button switchHome = (Button) findViewById(R.id.homeMainButton);
        switchHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchActivitiesHome();
            }
        });
      /*
      for (ArrayList<PriceActivity> p : stockPrice.values()) {
          System.out.println(p.get(0).price);
      }
      while (response != 0) {

          if (response == 1) {
              System.out.println("What company stock would you like to purchase? Enter the name: ");
              reader = new Scanner(System.in);
              String stockName = reader.next();
              String stockAbb = conversion.get(stockName);
              System.out.println("How many shares would you like to purchase?");
              reader = new Scanner(System.in);
              int numShares = reader.nextInt();
              StockActivity a = new StockActivity(stockName, stockAbb, 3000.00);
              System.out.println(a.companyName);
              System.out.println(a.companyAbb);
              System.out.println(a.equals(new StockActivity(stockName, stockAbb, 2000.00)));
              System.out.println(stockPrice.get(a));
              for (StockActivity s : stockPrice.keySet()) {
                  if (s.companyAbb.equals(stockAbb)) {
                      current.add(s.companyName, s.companyAbb, stockPrice.get(s).get(stockPrice.get(s).size() - 1).price, numShares, s);
                  }
              }
              //current.add(a.companyName, a.companyAbb, stockPrice.get(a).get(stockPrice.get(a).size() - 1).price, numShares);
          }//stockPrice.get(a).size() - 1

           */
          /*
          if (response == 2) {
              System.out.println("What company stock would you like to sell? Enter the name: ");
              reader = new Scanner(System.in);
              String sellStockName = reader.next();
              String sellStockAbb = conversion.get(sellStockName);
              System.out.println("How many shares would you like to sell");
              reader = new Scanner(System.in);
              int sellNumShares = reader.nextInt();
              StockActivity b = new StockActivity(sellStockName, sellStockAbb, 3000.00);
              for (StockActivity s : stockPrice.keySet()) {
                  if (s.companyAbb.equals(sellStockAbb)) {
                      current.add(b.companyName, b.companyAbb, stockPrice.get(b).get(stockPrice.get(b).size() - 1).price, -sellNumShares, b);
                  }
              }
              //current.add(sellStockName, sellStockAbb, stockPrice.get(b).get(stockPrice.get(b).size() - 1).price, -sellNumShares, b);

          }


          if (response == 3) {
              current.printDetails();
          }
          System.out.println("Enter 1 to buy. Enter 2 to sell.");
          reader = new Scanner(System.in);
          response = reader.nextInt();

      }
           */
        count++;
    }
    private void switchActivitiesBuyStock() {
        Intent switchActivityIntent = new Intent(this, BuyStockActivity.class);
        //switchActivityIntent.putExtra("map", stockPrice);
        //switchActivityIntent.putExtra("names", z);
        startActivity(switchActivityIntent);

        //sendDataB(stockPrice);
    }
    private void switchActivitiesSellStock() {
        Intent switchActivityIntent = new Intent(this, SellStockActivity.class);
        startActivity(switchActivityIntent);
        sendDataS(stockPrice);
    }
    private void switchActivitiesPrintInfo() {
        Intent switchActivityIntent = new Intent(this, PrintInfoActivity.class);

        startActivity(switchActivityIntent);
        sendDataP(stockPrice);
    }
    private void switchActivitiesHome() {
        Intent switchActivityIntent = new Intent(this, PrintInfoActivity.class);
        startActivity(switchActivityIntent);
        sendDataH(stockPrice);
    }
    private void sendDataB(HashMap<StockActivity,ArrayList<PriceActivity>>a,HashMap<String, StockPortfolioActivity> b){
       /*for(StockActivity s:a.keySet()){
           System.out.println(a.get(s).get(0));
       }*/
        Intent intent = new Intent(this, BuyStockActivity.class);
        intent.putExtra("map", a);
        intent.putExtra("names", b);
        startActivity(intent);
    }
    private void sendDataS(HashMap<StockActivity,ArrayList<PriceActivity>>a){
        Intent intent = new Intent(this, SellStockActivity.class);
        intent.putExtra("map", stockPrice);
        intent.putExtra("names", z);
        startActivity(intent);
    }
    private void sendDataP(HashMap<StockActivity,ArrayList<PriceActivity>>a){
      /* System.out.println("Main to printTTTTTTT");
       for(String s:z.keySet()){
           current = z.get(s);
           System.out.println(s + "    " + current.printDetails(stockPrice));
       }*/
        Intent intent = new Intent(this, PrintInfoActivity.class);
        intent.putExtra("map", stockPrice);
        intent.putExtra("names", z);
        startActivity(intent);
    }
    private void sendDataH(HashMap<StockActivity,ArrayList<PriceActivity>>a){

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("map", stockPrice);
        intent.putExtra("names", z);
        startActivity(intent);
    }
    /*
    private void sendPerson(StockPortfolioActivity c){
        Intent intent = new Intent(this, BuyStockActivity.class);
        intent.putExtra("investor", current);
        startActivity(intent);
    }

     */
    private void getData(){
        Intent intent = getIntent();
        stockPrice = (HashMap<StockActivity, ArrayList<PriceActivity>>) intent.getSerializableExtra("map");
        z = (HashMap<String, StockPortfolioActivity>) intent.getSerializableExtra("names");
    }

}
