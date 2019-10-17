package com.app.mvvmBase;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.app.mvvmBase.local.AppDatabase;


public class MainApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static Context getAppContext() {
        return context;
    }



}
