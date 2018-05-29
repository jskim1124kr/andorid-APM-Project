package com.example.kjs11.plz;

/**
 * Created by kjs11 on 2017-06-04.
 */
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;



public class FoodActivity extends ActionBarActivity implements OnClickListener {


    ViewPager viewPager = null;


    Handler handler = null;

    int p = 0;    //페이지번호

    int v = 1;    //화면 전환 뱡향


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.food_activity);



        viewPager = (ViewPager) findViewById(R.id.viewPager);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());


        viewPager.setAdapter(adapter);



        handler = new Handler() {


            public void handleMessage(android.os.Message msg) {

                if (p == 0) {

                    viewPager.setCurrentItem(1);

                    p++;

                    v = 1;

                }
                if (p == 1 && v == 0) {

                    viewPager.setCurrentItem(1);

                    p--;

                }
                if (p == 1 && v == 1) {

                    viewPager.setCurrentItem(2);

                    p++;

                }
                if (p == 2) {

                    viewPager.setCurrentItem(1);

                    p--;

                    v = 0;

                }

            }

        };
    }


        @Override

    public void onClick(View v) {


    }
}

