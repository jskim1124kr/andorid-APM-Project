package com.example.kjs11.plz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;

import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by kjs11 on 2017-05-08.
 */

public class Main extends Activity {
    ImageView food,pt,sche,shop,health,report,handy;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        health = (ImageView)findViewById(R.id.health);
        health.setImageResource(R.drawable.health);

        pt = (ImageView)findViewById(R.id.pt);
        pt.setImageResource(R.drawable.pt);

        report = (ImageView)findViewById(R.id.report);
        report.setImageResource(R.drawable.report);

        shop = (ImageView)findViewById(R.id.shop);
        shop.setImageResource(R.drawable.shop);

        sche = (ImageView)findViewById(R.id.sche);
        sche.setImageResource(R.drawable.sche);

        food = (ImageView)findViewById(R.id.food);
        food.setImageResource(R.drawable.food);

        handy = (ImageView)findViewById(R.id.handy);
        handy.setImageResource(R.drawable.handy);

    }


    public void healthButton(View v){
        Intent intent = new Intent(getApplicationContext(),Health1Activity.class);
        startActivity(intent);
    }
    public void ptButton(View v) {
        Intent intent = new Intent(getApplicationContext(),Pt1Activity.class);
        startActivity(intent);
    }
    public void shopButton(View v) {
        Intent intent = new Intent(getApplicationContext(),HealthShopActivity.class);
        startActivity(intent);
    }
    public void foodButton(View v) {
        Intent intent = new Intent(getApplicationContext(),FoodActivity.class);
        startActivity(intent);
    }
    public void calButton(View v) {
        Intent intent = new Intent(getApplicationContext(),CalendarMain.class);
        startActivity(intent);
    }

    public void reportButton(View v){
        Intent intent = new Intent(getApplicationContext(),ReportMain.class);
        startActivity(intent);
    }

    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

}

