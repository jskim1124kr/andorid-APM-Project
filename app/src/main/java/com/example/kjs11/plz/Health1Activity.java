package com.example.kjs11.plz;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.tsengvn.typekit.TypekitContextWrapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class Health1Activity extends Activity {

    String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_TITLE = "title";
    private static final String TAG_MESSAGE = "message";
    private static final String TAG_SNS = "sns";
    private static final String TAG_CATEGORY = "category";

    private ListAdapter adapter;
    JSONArray healths = null;

    ArrayList<HashMap<String, String>> healthList;

    ImageView healthMain;
    ImageView  write;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        list = (ListView) findViewById(R.id.healthList2);
        healthMain = (ImageView) findViewById(R.id.health);

        write = (ImageView) findViewById(R.id.writeButton3);
        write.setImageResource(R.drawable.swrite);

        healthList = new ArrayList<HashMap<String, String>>();
        getData("http://172.20.10.5/getdata.php");
    }


    protected void showList() {

        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            healths = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < healths.length(); i++) {
                JSONObject c = healths.getJSONObject(i);
                String title = c.getString(TAG_TITLE);
                String message = c.getString(TAG_MESSAGE);
                String sns = c.getString(TAG_SNS);
                String category = c.getString(TAG_CATEGORY);

                HashMap<String, String> persons = new HashMap<String, String>();

                persons.put(TAG_TITLE, title);
                persons.put(TAG_MESSAGE, message);
                persons.put(TAG_SNS, sns);
                persons.put(TAG_CATEGORY, category);

                healthList.add(persons);
            }

           adapter = new SimpleAdapter(
                    Health1Activity.this, healthList, R.layout.list_item,
                    new String[]{TAG_TITLE, TAG_CATEGORY,TAG_SNS},
                    new int[]{R.id.title3, R.id.category2,R.id.sns2}
            );

            list.setAdapter(adapter);
            list.setOnItemClickListener(
                    new ListView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(Health1Activity.this, Health3Activity.class);
                            intent.putExtra("title", healthList.get(position).get("title"));
                            intent.putExtra("message", healthList.get(position).get("message"));
                            intent.putExtra("sns", healthList.get(position).get("sns"));
                            intent.putExtra("category", healthList.get(position).get("category"));
                            startActivity(intent);
                        }
                    });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getData(String url) {
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                myJSON = result;

                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
    }


    public void writeButtonClicked3(View v) {
        Intent intent = new Intent(getApplicationContext(), Health2Activity.class);
        startActivity(intent);
    }

    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }



}
