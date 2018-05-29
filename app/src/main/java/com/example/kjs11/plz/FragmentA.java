package com.example.kjs11.plz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentA extends Fragment{



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_a, container, false);


      //ImageButton food1 = (ImageButton) v.findViewById(R.id.foodImage1) ;


        v.findViewById(R.id.foodImage1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(getActivity(), FoodFirst.class);
                        startActivity(intent1);
                    }
                }
        );

        v.findViewById(R.id.foodImage2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(getActivity(), FoodSecond.class);
                        startActivity(intent1);
                    }
                }
        );

        v.findViewById(R.id.foodImage3).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(getActivity(), FoodThird.class);
                        startActivity(intent1);
                    }
                }
        );

        return v;
    }

}



