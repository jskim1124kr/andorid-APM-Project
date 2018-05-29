package com.example.kjs11.plz;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;

import android.support.v4.app.FragmentStatePagerAdapter;



public class MyViewPagerAdapter extends FragmentStatePagerAdapter{
    Fragment[] fragments = new Fragment[2];


    public MyViewPagerAdapter(FragmentManager fm) {

        super(fm);

        fragments[0] = new FragmentA();

        fragments[1] = new FragmentB();



    }
    public Fragment getItem(int arg0) {

        return fragments[arg0];

    }
    public int getCount() {

        return fragments.length;

    }
}



