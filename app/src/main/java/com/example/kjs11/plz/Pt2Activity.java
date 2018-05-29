package com.example.kjs11.plz;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.tsengvn.typekit.TypekitContextWrapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Pt2Activity extends Activity {
    EditText titleBox, nameBox, snsBox ,areaBox,moneyBox, prBox, phoneBox, cateBox, messageBox2;
    String title, name, phone, money, area, pr, sns, category,message2;
    RadioGroup rg;
    RadioButton rd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);

        setContentView(R.layout.activity_pt2);

        init();

        RelativeLayout lin = (RelativeLayout) findViewById(R.id.activty_pt2);
        lin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;
            }
        });

        Button add = (Button) findViewById(R.id.btnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rd = (RadioButton)findViewById(rg.getCheckedRadioButtonId());

                name = nameBox.getText().toString();
                title = titleBox.getText().toString();
                category = rd.getText().toString();
                message2 = messageBox2.getText().toString();
                money = moneyBox.getText().toString();
                area = areaBox.getText().toString();
                pr = prBox.getText().toString();
                phone = phoneBox.getText().toString();
                sns = snsBox.getText().toString();

                insertToDatabase(name, title, category, message2, money,area,pr,phone,sns);

            }
        });
    }

    void init() {
        titleBox = (EditText)findViewById(R.id.titleBox);
        snsBox = (EditText)findViewById(R.id.snsBox);
        nameBox = (EditText)findViewById(R.id.nameBox);
        phoneBox = (EditText)findViewById(R.id.phoneBox);
        moneyBox = (EditText)findViewById(R.id.moneyBox);
        areaBox = (EditText)findViewById(R.id.areaBox);
        prBox = (EditText)findViewById(R.id.prBox);
        messageBox2 = (EditText)findViewById(R.id.messageBox2);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);

    }
    private void insertToDatabase(String name, String title, String category, String message,
                                  String money, String area, String pr, String phone,
                                  String sns){

        class InsertData extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                loading = ProgressDialog.show(Pt2Activity.this,
                        "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            protected String doInBackground(String... params) {

                try{
                    String name = (String)params[0];
                    String title = (String)params[1];
                    String category = (String)params[2];
                    String message = (String)params[3];
                    String money = (String)params[4];
                    String area = (String)params[5];
                    String pr = (String)params[6];
                    String phone = (String)params[7];
                    String sns = (String)params[8];

                    String link="http://172.20.10.5/insert2.php";

                    String data  = URLEncoder.encode("name", "UTF-8") + "="
                            + URLEncoder.encode(name, "UTF-8");

                    data += "&" + URLEncoder.encode("title", "UTF-8") + "="
                            + URLEncoder.encode(title, "UTF-8");

                    data += "&" + URLEncoder.encode("category", "UTF-8") + "="
                            + URLEncoder.encode(category, "UTF-8");

                    data += "&" + URLEncoder.encode("message", "UTF-8") + "="
                            + URLEncoder.encode(message, "UTF-8");

                    data += "&" + URLEncoder.encode("money", "UTF-8") + "="
                            + URLEncoder.encode(money, "UTF-8");

                    data += "&" + URLEncoder.encode("area", "UTF-8") + "="
                            + URLEncoder.encode(area, "UTF-8");

                    data += "&" + URLEncoder.encode("pr", "UTF-8") + "="
                            + URLEncoder.encode(pr, "UTF-8");

                    data += "&" + URLEncoder.encode("phone", "UTF-8") + "="
                            + URLEncoder.encode(phone, "UTF-8");

                    data += "&" + URLEncoder.encode("sns", "UTF-8") + "="
                            + URLEncoder.encode(sns, "UTF-8");


                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr =
                            new OutputStreamWriter(conn.getOutputStream());

                    wr.write( data );
                    wr.flush();

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    while((line = reader.readLine()) != null)
                    {
                        sb.append(line);
                        break;
                    }
                    return sb.toString();
                }
                catch(Exception e){

                    return new String("Exception: " + e.getMessage());
                }

            }
        }

        InsertData task = new InsertData();
        task.execute(name,title,category,message,money,area,pr,phone,sns);
    }

    public void btnCancelButtonClicked(View v){
        Intent intent = new Intent(getApplicationContext(),Pt1Activity.class);
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
