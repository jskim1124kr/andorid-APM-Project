package com.example.kjs11.plz;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kjs11 on 2017-05-08.
 */



public class FoodSecond extends Activity {
    ImageView image1,image2,image3,image4,image5,image6,image7;
    TextView text,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,
    text12, text13;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.food_detail2);

        Init();

        JsoupTask task = new JsoupTask();
        task.execute();

    }
    void Init(){

        text = (TextView)findViewById(R.id.detail2_message1);
        image1 = (ImageView)findViewById(R.id.detail2_1);
        image1.setImageResource(R.drawable.fdetail2_1);


        text2 = (TextView)findViewById(R.id.detail2_message2);
        image2 = (ImageView)findViewById(R.id.detail2_2);
        image2.setImageResource(R.drawable.fdetail2_2);

        text3 = (TextView)findViewById(R.id.detail2_message3);
        image3 = (ImageView)findViewById(R.id.detail2_3);
        image3.setImageResource(R.drawable.fdetail2_3);

    }
    public class JsoupTask extends AsyncTask<Void, Void, Void> {

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> text1 = new ArrayList<String>();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {

            try {

                Document doc = Jsoup.connect("http://terms.naver.com/entry.nhn?docId=1993097&cid=48180&categoryId=48246").get();
                Elements sel = doc.select("div.section_wrap");
                Elements info = sel.select("tbody").select("tr");
                Elements txt = sel.select("p.txt");

                for(int i = 0; i<info.size(); i++){
                    list.add(info.get(i).text());
                }
                for(int i = 0; i<txt.size(); i++){
                    text1.add(txt.get(i).text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {

            text.setText(list.get(0) + "\n" + "\n" + list.get(1) + "\n" + "\n" + list.get(2) + "\n" + "\n" + text1.get(0));

            text2.setText(text1.get(1)+ "\n");

            text3.setText(text1.get(2));
        }
    }

    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
