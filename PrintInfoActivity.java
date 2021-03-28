package com.example.lahacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintInfoActivity extends AppCompatActivity {
    HashMap<StockActivity, ArrayList<PriceActivity>> stockPrice = new HashMap<StockActivity, ArrayList<PriceActivity>>();
    HashMap<String, StockPortfolioActivity> z = new HashMap<String, StockPortfolioActivity>();
    HashMap<String, StockPortfolioActivity> zl = new HashMap<String, StockPortfolioActivity>();
    StockPortfolioActivity current;
    String y = "";
    int count;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_info);
        getData();
       /*System.out.println("TGSGSHSHSGSJSGHDGDDJD");
       for(String s:z.keySet()){
           current = z.get(s);
           System.out.println(s + "    " + current.printDetails(stockPrice));
       }
       System.out.println("DGDGDSGSENNDDDDDDNDNDNDNDN");*/
        //EditText x = (EditText)findViewById(R.id.nameText);
        //name = (x.getText().toString());
       /*for(String s:z.keySet()){
           System.out.println(s);
       }
       System.out.println("PPP"+name);
       count = 0;
       for(String s:z.keySet()){

           System.out.println("awesome" + s);
           if(s.equals(name)) {
               System.out.println(" khhlhkg");
               current = z.get(s);
               y += current.printDetails();
               count++;
               break;
           }
       }
       if(count==0){
           z.put(name, new StockPortfolioActivity(name));
           current = z.get(name);
       }*/
        Button seeInfo = (Button)findViewById(R.id.infoMainButton);

        seeInfo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //System.out.println(z);
                EditText x = (EditText)findViewById(R.id.nameText);
                name = (x.getText().toString());
                for(String s:z.keySet()){


                    if(s.equals(name)) {
                        current = z.get(s);
                        y += (current.printDetails(stockPrice));
                        count++;
                        break;
                    }
                }
                if(count==0){
                    z.put(name, new StockPortfolioActivity(name));
                    current = z.get(name);
                }
                //System.out.println(y);
                TextView a = (TextView)findViewById(R.id.stockInfoText);
                a.setText(y);
            }
        });
    }
    private void sendData(HashMap<StockActivity, ArrayList<PriceActivity>>a){
        Intent intent = new Intent(this, BuyStockActivity.class);
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
       /*System.out.println("printTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
       for(String s:z.keySet()){
           current = z.get(s);
           System.out.println(s + "    " + current.printDetails(stockPrice));
       }
       System.out.println("enddddddd");*/
    }
}
