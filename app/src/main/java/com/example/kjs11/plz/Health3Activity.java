package com.example.kjs11.plz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

public class Health3Activity extends Activity {
    TextView title, tvMessage, tvURL, cateText;
    String title2, message, category, sns;
    ImageButton homepage, advertise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_health3);

        init();

        title2 = getIntent().getStringExtra("title");
        message = getIntent().getStringExtra("message");
        sns = getIntent().getStringExtra("sns");
        category = getIntent().getStringExtra("category");

        title.setText(title2);
        tvMessage.setText(message);
        tvURL.setText(sns);
        cateText.setText(category);
    }


    void init() {
        title = (TextView) findViewById(R.id.txtTitle);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        tvURL = (TextView) findViewById(R.id.tvURL);
        cateText = (TextView) findViewById(R.id.cateTxt);
        homepage = (ImageButton) findViewById(R.id.homepageImage);
        advertise = (ImageButton)findViewById(R.id.advertise);
        advertise.setImageResource(R.drawable.spomax);
    }


    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    public void advertiseButton(View v){
        String url ="http://www.spomax.kr";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void connectSns2(View v) {
        try {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tvURL.getText().toString()));
        startActivity(intent);
        } catch(Exception e) { }
    }
}

