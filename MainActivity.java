package com.example.lahacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
    HashMap<StockActivity, ArrayList<PriceActivity>> stockPrice = new HashMap<StockActivity, ArrayList<PriceActivity>>();
    HashMap<String, StockPortfolioActivity> z = new HashMap<String, StockPortfolioActivity>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stockPrice.put(new StockActivity("Amazon", "AMZN", 3052.03), new ArrayList<PriceActivity>());
        stockPrice.put(new StockActivity("Tesla", "TSLA", 3052.03), new ArrayList<PriceActivity>());
        stockPrice.put(new StockActivity("Apple", "AAPL", 3052.03), new ArrayList<PriceActivity>());
        stockPrice.put(new StockActivity("General Electric", "GE", 3052.03), new ArrayList<PriceActivity>());
        stockPrice.put(new StockActivity("AT&T", "T", 3052.03), new ArrayList<PriceActivity>());
        stockPrice.put(new StockActivity("Coca Cola", "KO", 3052.03), new ArrayList<PriceActivity>());
        stockPrice.put(new StockActivity("Starbucks", "SBUX", 3052.03), new ArrayList<PriceActivity>());
        stockPrice.put(new StockActivity("Nike", "NIKE", 3052.03), new ArrayList<PriceActivity>());
        Button switchToRealActivity = (Button) findViewById(R.id.realButton);
        switchToRealActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchActivitiesR();
            }
        });
        Button switchToBTCActivity = (Button) findViewById(R.id.bitButton);
        switchToBTCActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switchActivitiesB();
            }
        });
        Button switchMainStock = (Button) findViewById(R.id.stockButton);
        switchMainStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataS(stockPrice);
            }
        });
    }

    private void switchActivitiesS() {
        Intent switchActivityIntent = new Intent(this, MainStockActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchActivitiesR() {
        Intent switchActivityIntent1 = new Intent(this, MainRealActivity.class);
        startActivity(switchActivityIntent1);
    }
    private void switchActivitiesB() {
        Intent switchActivityIntent2 = new Intent(this, MainBTCActivity.class);
        startActivity(switchActivityIntent2);
    }
    private void sendDataS(HashMap<StockActivity, ArrayList<PriceActivity>> a){
        Intent intent = new Intent(this, MainStockActivity.class);
        intent.putExtra("map", stockPrice);
        intent.putExtra("names", z);
        startActivity(intent);
    }
}
