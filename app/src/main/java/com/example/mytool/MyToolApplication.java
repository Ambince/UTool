package com.example.mytool;

import android.app.Application;
import android.widget.Toast;

import com.example.mytool.uitil.Util;

/**
 * Created by Amence on 2016/11/10.
 */

public class MyToolApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
        // Normal app init code...



    }
}
