package com.example.mytool.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mytool.R;
import com.example.mytool.uitil.StackManager;
import com.example.mytool.uitil.Util;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        Util.setFullScreen(this);
        StackManager.setCurrentActivity(this);
        StackManager.onActivityCreated(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackManager.onActivityDestory(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
