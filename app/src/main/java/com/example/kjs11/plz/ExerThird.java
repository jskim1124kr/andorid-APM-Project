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


public class ExerThird extends Activity {
    ImageView image1,image2,image3,image4,image5,image6,image7;
    TextView text,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,
    text12, text13;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.exer_detail3);

        Init();

        JsoupTask task = new JsoupTask();
        task.execute();

    }
    void Init(){
        image1 = (ImageView)findViewById(R.id.e_detail3_title);
        image1.setImageResource(R.drawable.e_detail3_title1);
        image2 = (ImageView)findViewById(R.id.e_detail3_1);
        image2.setImageResource(R.drawable.exer3_detail1);
         text = (TextView)findViewById(R.id.e_detail3_message1);

        image3 = (ImageView)findViewById(R.id.e_detail3_title2);
        image3.setImageResource(R.drawable.e_detail3_title2);
        image4 = (ImageView)findViewById(R.id.e_detail3_2);
        image4.setImageResource(R.drawable.exer3_detail2);
        text2 = (TextView)findViewById(R.id.e_detail3_message2);

        image5 = (ImageView)findViewById(R.id.e_detail3_title3);
        image5.setImageResource(R.drawable.e_detail3_title3);
        image6 = (ImageView)findViewById(R.id.e_detail3_3);
        image6.setImageResource(R.drawable.exer3_detail3);
        text3 = (TextView)findViewById(R.id.e_detail3_message3);





    }
    public class JsoupTask extends AsyncTask<Void, Void, Void> {

       ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        ArrayList<String> list3 = new ArrayList<String>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {

            try {

                Document doc = Jsoup.connect("http://terms.naver.com/entry.nhn?docId=938848&cid=51030&categoryId=51030&expCategoryId=51030").get();
                Document doc2 = Jsoup.connect("http://terms.naver.com/entry.nhn?docId=938871&cid=51030&categoryId=51030&expCategoryId=51030").get();
                Document doc3 = Jsoup.connect("http://terms.naver.com/entry.nhn?docId=938922&cid=51030&categoryId=51030&expCategoryId=51030").get();
                Elements sel = doc.select("div#content");
                Elements info = sel.select("p.txt");

                Elements sel2 = doc2.select("div#content");
                Elements info2 = sel2.select("p.txt");

                Elements sel3 = doc3.select("div#content");
                Elements info3 = sel3.select("p.txt");

                for(int i = 0; i<info.size(); i++){
                    list.add(info.get(i).text());
                }

                for(int i = 0; i<info2.size(); i++){
                    list2.add(info2.get(i).text());
                }

                for(int i = 0; i<info3.size(); i++){
                    list3.add(info3.get(i).text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {

            for(int i = 0; i<list.size(); i++) {
                text.setText(list.get(i)+"\n");
            }

            for(int i = 0; i<list2.size(); i++) {
                text2.setText(list2.get(i)+"\n");
            }

            for(int i = 0; i<list3.size(); i++) {
                text3.setText(list3.get(i)+"\n");
            }
        }
    }

    @Override protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
