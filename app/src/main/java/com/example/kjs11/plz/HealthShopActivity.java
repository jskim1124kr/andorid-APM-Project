package com.example.kjs11.plz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.tsengvn.typekit.TypekitContextWrapper;

public class HealthShopActivity extends Activity {
    ImageButton bt1;
    ImageButton bt2;
    ImageButton bt3;
    ImageButton bt4;
    ImageButton bt5;
    ImageButton bt6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shop);
        init();

        RelativeLayout lin = (RelativeLayout) findViewById(R.id.shop_xml);
        lin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;
            }
        });

    }

    void init() {
        bt1 = (ImageButton)findViewById(R.id.kingkong);
        bt2 = (ImageButton)findViewById(R.id.bodyx);
        bt3 = (ImageButton)findViewById(R.id.healthmart);
        bt4 = (ImageButton)findViewById(R.id.cocobil);
        bt5 = (ImageButton)findViewById(R.id.monster);
        bt6 = (ImageButton)findViewById(R.id.herdak);
    }


    public void bodyxButton(View v){
        String url ="http://www.bodyx.co.kr";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    public void kingkongButton(View v){
        String url ="http://kingkong-factory.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    public void healthMartButton(View v){
        String url ="http://www.bodyx.co.kr";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    public void monsterButton(View v){
        String url ="http://www.monsterzym.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
    public void cocobilButton(View v){
        String url ="http://www.cocovill.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void herdakButton(View v){
        String url ="http://www.heodak.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(
                this.getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }
    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
