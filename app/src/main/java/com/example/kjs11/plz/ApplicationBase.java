package com.example.kjs11.plz;

import android.app.Application;

import com.tsengvn.typekit.Typekit;

/**
 * Created by kjs11 on 2017-06-12.
 */

public class ApplicationBase extends Application {
    public void onCreate() {
        super.onCreate();
        Typekit.getInstance()

                .addNormal(Typekit.createFromAsset(this,"NanumPen.ttf"))
                .addBold(Typekit.createFromAsset(this,"NanumPen.ttf"));

    }
}
