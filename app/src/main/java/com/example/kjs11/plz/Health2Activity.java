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

import static com.example.kjs11.plz.R.id.title2;

public class Health2Activity extends Activity {
    EditText titleBox, snsBox, messageBox;
    String title;
    String message;
    String sns;
    String category;
    RadioGroup rg;
    RadioButton rd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_health2);
        init();

        RelativeLayout lin = (RelativeLayout) findViewById(R.id.activity_health2);
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
                title = titleBox.getText().toString();
                message = messageBox.getText().toString();
                sns = snsBox.getText().toString();
                category = rd.getText().toString();

                insertToDatabase(title, message, sns, category);

            }
        });

    }


    void init() {
        titleBox = (EditText)findViewById(title2);
        snsBox = (EditText)findViewById(R.id.sns2);
        messageBox = (EditText)findViewById(R.id.message2);
        rg = (RadioGroup) findViewById(R.id.radioGroup1);

    }



    private void insertToDatabase(String title, String message, String sns,String category){

        class InsertData extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                loading = ProgressDialog.show(Health2Activity.this,
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
                    String title = (String)params[0];
                    String message = (String)params[1];
                    String sns = (String)params[2];
                    String category = (String)params[3];

                    String link="http://172.20.10.5/insert.php";

                    String data  = URLEncoder.encode("title", "UTF-8") + "="
                            + URLEncoder.encode(title, "UTF-8");
                    data += "&" + URLEncoder.encode("message", "UTF-8") + "="
                            + URLEncoder.encode(message, "UTF-8");
                    data += "&" + URLEncoder.encode("sns", "UTF-8") + "="
                            + URLEncoder.encode(sns, "UTF-8");
                    data += "&" + URLEncoder.encode("category", "UTF-8") + "="
                            + URLEncoder.encode(category, "UTF-8");

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
        task.execute(title,message,sns,category);
    }

    public void btnCancelButtonClicked(View v){
        Intent intent = new Intent(getApplicationContext(),Health1Activity.class);
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
