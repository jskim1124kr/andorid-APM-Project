package com.example.kjs11.plz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tsengvn.typekit.TypekitContextWrapper;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class ReportInsert extends Activity {

    TextView tv_name, tv_age, tv_email, tv_password;
    Button bt_joinOK, bt_joinCancel, bt_Select;
    Realm realm;
    ImageView ivPreView;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_report);

        LinearLayout lin = (LinearLayout) findViewById(R.id.activity_join);
        lin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;
            }
        });

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_age = (TextView) findViewById(R.id.tv_age);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_password = (TextView) findViewById(R.id.tv_password);
        bt_joinOK = (Button) findViewById(R.id.bt_join_ok);
        bt_joinCancel = (Button) findViewById(R.id.bt_join_cancel);
        bt_Select = (Button) findViewById(R.id.bt_photo);


        realm = Realm.getDefaultInstance();

        bt_joinOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tv_name.getText().toString().equals("")|| tv_email.getText().toString().equals("")||tv_password.getText().toString().equals("")) {
                    Toast.makeText(ReportInsert.this, "필수입력 항목이 비어 있음", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    insertDatabase();
                    Intent intent = new Intent();
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });

        bt_joinCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        bt_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }
        });

    }


    private void insertDatabase() {
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm) {
                Number num = realm.where(Member.class).max("id");
                int nextID;
                if (num == null) {
                    nextID = 1;
                } else {
                    nextID = num.intValue() + 1;
                }
                Member member = realm.createObject(Member.class);
                member.setName(tv_name.getText().toString());
                Integer i = Integer.parseInt("" + tv_age.getText());
                member.setAge(i);
                member.setEmail(tv_email.getText().toString());
                member.setPassword(tv_password.getText().toString());
            }
        });
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        realm.close();
    }

    private void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(
                this.getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0) {
            if(resultCode == Activity.RESULT_OK){
                uri = data.getData();
                Glide.with(this)
                        .load(uri)
                        .centerCrop()
                        .into(ivPreView);
            }
        }
    }
    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}






