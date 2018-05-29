package com.example.kjs11.plz;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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



public class FoodFirst extends Activity {
    ImageView image1,image2,image3,image4,image5,image6,image7;
    TextView text,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,
            text12, text13;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.food_detail1);

        Init();

        JsoupTask task = new JsoupTask();
        task.execute();

    }
    void Init(){
        image1 = (ImageView)findViewById(R.id.detail1_title);
        image1.setImageResource(R.drawable.food3);

        text = (TextView)findViewById(R.id.detail_message1);

        image2 = (ImageView)findViewById(R.id.detail1_image1);
        image2.setImageResource(R.drawable.food7);
        text2 = (TextView)findViewById(R.id.detail_message2);
        text3 = (TextView)findViewById(R.id.detail_message3);

        image3 = (ImageView)findViewById(R.id.detail1_image2);
        image3.setImageResource(R.drawable.food4);
        text4 = (TextView)findViewById(R.id.detail_message4);
        text5 = (TextView)findViewById(R.id.detail_message5);

        image4 = (ImageView)findViewById(R.id.detail1_image3);
        image4.setImageResource(R.drawable.food1);
        text6 = (TextView)findViewById(R.id.detail_message6);
        text7 = (TextView)findViewById(R.id.detail_message7);

        image5 = (ImageView)findViewById(R.id.detail1_image4);
        image5.setImageResource(R.drawable.food2);
        text8 = (TextView)findViewById(R.id.detail_message8);
        text9 = (TextView)findViewById(R.id.detail_message9);


        image6 = (ImageView)findViewById(R.id.detail1_image5);
        image6.setImageResource(R.drawable.food6);
        text10 = (TextView)findViewById(R.id.detail_message10);
        text11 = (TextView)findViewById(R.id.detail_message11);


        image7 = (ImageView)findViewById(R.id.detail1_image6);
        image7.setImageResource(R.drawable.food5);
        text12 = (TextView)findViewById(R.id.detail_message12);
        text13 = (TextView)findViewById(R.id.detail_message13);

    }
    public class JsoupTask extends AsyncTask<Void, Void, Void> {

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> title = new ArrayList<String>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {

            try {

                Document doc = Jsoup.connect("http://navercast.naver.com/magazine_contents.nhn?rid=1095&contents_id=90120&hash=sec1#sec1").get();
                Elements sel = doc.select("div.na_doc_container");
                Elements tit = sel.select("strong.t_lv_tit2");
                Elements txt = sel.select("p.t_txt");

                for(int j = 0; j< tit.size(); j++)
                {
                    title.add(tit.get(j).text());
                }
                for(int i = 0; i< txt.size(); i++){
                    list.add(txt.get(i).text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            text.setText(list.get(0) + "\n");


            text2.setText(title.get(0)+ "\n");
            text2.setTextSize(20);
            text3.setText(list.get(2) + "\n" + "\n" +  list.get(3) + "\n" +  "\n" + list.get(4));


            text4.setText(title.get(1) + "\n");
            text5.setText(list.get(5) + "\n" + "\n" +  list.get(6));


            text6.setText(title.get(2) + "\n");
            text7.setText(list.get(8) + "\n" + "\n" +  list.get(9)+ "\n" +  "\n" + list.get(10));


            text8.setText(title.get(3) + "\n");
            text9.setText(list.get(11) + "\n" + "\n" +  list.get(12) + "\n" + "\n" +list.get(13));


            text10.setText(title.get(4) + "\n");
            text11.setText(list.get(15)   + "\n" +  "\n" + list.get(16) + "\n" +  "\n" + list.get(17));


            text12.setText(title.get(5) + "\n");
            text13.setText(list.get(18)   + "\n" +  "\n" + list.get(19) + "\n" +  "\n" + list.get(20));




        }
    }

    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}