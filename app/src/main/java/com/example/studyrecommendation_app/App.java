package com.example.studyrecommendation_app;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static Context mApplicationContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = this;
    }

    public static Context getContext() {
        return mApplicationContext;
    }

}
