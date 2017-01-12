package com.example.mytool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mytool.R;
import com.example.mytool.db.DatabaseUtil;
import com.example.mytool.service.MyIntentService;
import com.example.mytool.service.TestService;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.Util;

import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

public class FlashActivity extends BaseActivity {
    private String mCityName;
    private TimerTask task;
    private Timer timer;
    private String mJson;
    private boolean isShowWeather;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        Intent intent = new Intent(FlashActivity.this, TestService.class);
        startService(intent);

        Util.setFullScreen(this);
        task = new TimerTask() {
            @Override
            public void run() {
                mCityName = Util.getString(FlashActivity.this, "cityName");
                Intent intent = new Intent(FlashActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                DatabaseUtil.getInstance(FlashActivity.this);
                if (!TextUtils.isEmpty(mJson)) {
                    isShowWeather = false;
                    bundle.putString("json", mJson);
                    bundle.putString("city", mCityName);
                    bundle.putBoolean("isShowWeather", isShowWeather);
                    intent.putExtras(bundle);


                } else {
                    isShowWeather = true;
                    bundle.putString("city", mCityName);
                    intent.putExtras(bundle);
                }
                startActivity(intent);
                finish();


            }
        };


        if (Util.isNetWorkAvailable(this)) {//有网络
            try{
                city = Util.getCNBylocation(this);

            }catch (Exception e){
                city = Util.HanZi4UrlUnicode("成都");

            }
            if (!TextUtils.isEmpty(city)) {
                getWeatherData();

            } else {
            }
        } else {//无网络
            timer = new Timer();
            mJson = Util.getWeatherInfo(this);
            timer.schedule(task, 5000);
        }


    }


    /**
     * 网络请求
     */
    public void getWeatherData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        //请求天气
        mCityName = Util.UrlUnicode4HanZi(city);
        Util.saveString(this, "cityName", mCityName);
        String url = API.WEATHERURL + city;
        JsonObjectRequest json = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                mJson = jsonObject.toString();
                timer = new Timer();
                if (mJson != null) {
                    //存入sp
                    Util.saveWeatherInfo(FlashActivity.this, mJson);
                }
                timer.schedule(task, 5000);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(json);

    }
}
