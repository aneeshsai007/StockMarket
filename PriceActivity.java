package com.example.lahacks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.ChronoUnit;

public class PriceActivity extends AppCompatActivity implements java.io.Serializable {
    LocalDateTime currentTime;
    static LocalDateTime lastTime;
    //int day; //fix date later
    double price;
    //static int d;
    static double p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
    }
    public PriceActivity(int pCount){
        if(pCount == 0){
            price = (double)Math.random()*500 + 20;
            p = price;
            currentTime = LocalDateTime.now();
            lastTime = currentTime;
        }
        else{
            currentTime = LocalDateTime.now();
            long diff = ChronoUnit.MINUTES.between(currentTime, lastTime);
            price = this.update(diff,pCount);
            lastTime = currentTime;
        }
    }
    public double update(long minuteCount, int pCount){
        double pAdd = (double)Math.random() * 0.01;
        int rand = (int)Math.random()*10+1;
        if(pCount % rand == 0){
            p -= (double)Math.random()* (minuteCount * pAdd);
        }
        else {
            p += (double)Math.random()* (minuteCount * pAdd);
        }
        return p;
    }
}
