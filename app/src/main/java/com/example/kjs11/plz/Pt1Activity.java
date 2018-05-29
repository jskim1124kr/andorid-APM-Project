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


public class Pt1Activity extends Activity {

    String myJSON;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_TITLE = "title";
    private static final String TAG_NAME = "name";
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_PHONE = "phone";
    private static final String TAG_AREA = "area";
    private static final String TAG_PR = "pr";
    private static final String TAG_SNS = "sns";
    private static final String TAG_MONEY = "money";
    private static final String TAG_MESSAGE = "message";

    JSONArray pts = null;

    ArrayList<HashMap<String, String>> ptList;

    ImageView write, imageView4;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt1);
        list = (ListView) findViewById(R.id.ptList2);
        write = (ImageView) findViewById(R.id.writeButton3);
        write.setImageResource(R.drawable.swrite);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        ptList = new ArrayList<HashMap<String, String>>();

       getData("http://172.20.10.5/getdata2.php");



    }


    protected void showList() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            pts = jsonObj.getJSONArray(TAG_RESULTS);

            for (int i = 0; i < pts.length(); i++) {
                JSONObject c = pts.getJSONObject(i);
                String name = c.getString(TAG_NAME);
                String title = c.getString(TAG_TITLE);
                String category = c.getString(TAG_CATEGORY);
                String message = c.getString(TAG_MESSAGE);
                String money = c.getString(TAG_MONEY);
                String area = c.getString(TAG_AREA);
                String pr = c.getString(TAG_PR);
                String phone = c.getString(TAG_PHONE);
                String sns = c.getString(TAG_SNS);

                HashMap<String, String> pts2 = new HashMap<String, String>();
                pts2.put(TAG_NAME, name);
                pts2.put(TAG_TITLE, title);
                pts2.put(TAG_CATEGORY, category);
                pts2.put(TAG_MESSAGE, message);
                pts2.put(TAG_MONEY, money);
                pts2.put(TAG_AREA, area);
                pts2.put(TAG_PR, pr);
                pts2.put(TAG_PHONE, phone);
                pts2.put(TAG_SNS, sns);


                ptList.add(pts2);
            }

            ListAdapter adapter = new SimpleAdapter(
                    Pt1Activity.this, ptList, R.layout.list_item2,
                    new String[]{TAG_TITLE, TAG_CATEGORY,TAG_PR,TAG_SNS},
                    new int[]{R.id.title4, R.id.category4,R.id.pr4,R.id.sns4}

            );
            list.setAdapter(adapter);

            list.setOnItemClickListener(
                    new ListView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(Pt1Activity.this, Pt3Activity.class);
                            intent.putExtra("name", ptList.get(position).get("name"));
                            intent.putExtra("title", ptList.get(position).get("title"));
                            intent.putExtra("category", ptList.get(position).get("category"));
                            intent.putExtra("message", ptList.get(position).get("message"));
                            intent.putExtra("money", ptList.get(position).get("money"));
                            intent.putExtra("area", ptList.get(position).get("area"));
                            intent.putExtra("pr", ptList.get(position).get("pr"));
                            intent.putExtra("phone", ptList.get(position).get("phone"));
                            intent.putExtra("sns", ptList.get(position).get("sns"));
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


    public void writeButtonClicked4(View v) {
        Intent intent = new Intent(getApplicationContext(), Pt2Activity.class);
        startActivity(intent);

    }
    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
