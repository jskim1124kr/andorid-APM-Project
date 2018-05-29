package com.example.kjs11.plz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

public class Pt3Activity extends Activity {
    TextView teacherName, lectureName, lectureCate, messageTxt, lectureCost, lectureArea, teacherPR, teacherPhone, teacherSNS;
    String tname, lname, lcate, ptMessage, lcost, larea, tpr, tphone, tsns;
    ImageView homepage, phoneImage,advertise2;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pt3);

        homepage = (ImageView) findViewById(R.id.homepageImage);
        homepage.setImageResource(R.drawable.smallhomepage);
        phoneImage = (ImageView) findViewById(R.id.phoneImage);
        phoneImage.setImageResource(R.drawable.smallphones);
        init();

        tname = getIntent().getStringExtra("name");
        lname = getIntent().getStringExtra("title");
        lcate = getIntent().getStringExtra("category");
        ptMessage = getIntent().getStringExtra("message");
        lcost = getIntent().getStringExtra("money");
        larea = getIntent().getStringExtra("area");
        tpr = getIntent().getStringExtra("pr");
        tphone = getIntent().getStringExtra("phone");
        tsns = getIntent().getStringExtra("sns");


        teacherName.setText(tname);
        lectureName.setText(lname);
        lectureCate.setText(lcate);
        messageTxt.setText(ptMessage);
        lectureCost.setText(lcost);
        lectureArea.setText(larea);
        teacherPR.setText(tpr);
        teacherPhone.setText(tphone);
        teacherSNS.setText(tsns);
    }


    void init() {
        teacherName = (TextView) findViewById(R.id.teacherName);
        lectureName = (TextView) findViewById(R.id.lectureName);
        lectureCate = (TextView) findViewById(R.id.lectureCate);
        messageTxt = (TextView) findViewById(R.id.messageTxt);
        lectureCost = (TextView) findViewById(R.id.lectureCost);
        lectureArea = (TextView) findViewById(R.id.lectureArea);
        teacherPR = (TextView) findViewById(R.id.teacherPR);
        teacherPhone = (TextView) findViewById(R.id.teacherPhone);
        teacherSNS = (TextView) findViewById(R.id.teacherSNS);

        advertise2 = (ImageView) findViewById(R.id.advertise2);
        advertise2.setImageResource(R.drawable.spomax);
    }


    public void onClick(View v) {
        if (v.getId() == R.id.btnback) {
            finish();

        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    public void advertiseButton2(View v) {
        String url = "http://www.spomax.kr";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void connectSns(View v) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(teacherSNS.getText().toString()));
            startActivity(intent);
        } catch(Exception e) { }

    }

    public void connectPhone(View v) {
        try {
            phone = "tel:" + teacherPhone.getText();
            startActivity(new Intent("andorid.intent.action.CALL", Uri.parse(phone)));
        } catch (Exception e) {
        }
    }

}