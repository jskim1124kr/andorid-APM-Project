package com.example.kjs11.plz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentB extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_b, container, false);

        v.findViewById(R.id.exerImage1).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(getActivity(), ExerFirst.class);
                        startActivity(intent1);
                    }
                }
        );

        v.findViewById(R.id.exerImage2).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(getActivity(), ExerSecond.class);
                        startActivity(intent1);
                    }
                }
        );

        v.findViewById(R.id.exerImage3).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent1 = new Intent(getActivity(), ExerThird.class);
                        startActivity(intent1);
                    }
                }
        );

        return v;
    }
}



