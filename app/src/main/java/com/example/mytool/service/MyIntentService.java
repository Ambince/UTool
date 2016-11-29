package com.example.mytool.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2016/11/25 0025.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {

        super(MyIntentService.class.getName());
        Log.v("Amence", "MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.v("Amence", "耗时操作");
    }
}
