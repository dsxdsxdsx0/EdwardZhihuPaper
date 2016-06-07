package com.example.edwardlucci.edwardzhihupaper.base;

import android.app.Application;
import android.os.Build;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.orhanobut.logger.Logger;

import okhttp3.OkHttpClient;

/**
 * Created by edwardlucci on 16/5/20.
 */
public class MyApp extends Application{

    static public OkHttpClient okHttpClient;
    static private int SDK_VERSION;

    @Override
    public void onCreate() {
        super.onCreate();

        //logger setup
        Logger.init("Zhihu");

        //stetho
        Stetho.initializeWithDefaults(this);

        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        SDK_VERSION = Build.VERSION.SDK_INT;
        Logger.i(String.valueOf(SDK_VERSION));
    }

    public static int getSdkVersion() {
        return SDK_VERSION;
    }
}
