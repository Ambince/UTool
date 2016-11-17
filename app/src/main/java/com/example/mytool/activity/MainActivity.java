package com.example.mytool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytool.R;
import com.example.mytool.adapter.HomeAdapter;
import com.example.mytool.bean.weather.LifeWeatherInfo;
import com.example.mytool.bean.weather.Weather;
import com.example.mytool.bean.weather.WeatherData;
import com.example.mytool.bean.weather.WeatherDayInfo;
import com.example.mytool.bean.weather.WeatherDetail;
import com.example.mytool.bean.weather.WeatherList;
import com.example.mytool.bean.weather.WeatherRealtime;
import com.example.mytool.bean.weather.WeatherWind;
import com.example.mytool.uitil.StackManager;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    //温度
    private TextView mTextViewTemperature;
    //位置
    private TextView mTextViewCity;
    //温度间隔
    private TextView mTextViewDuration;
    //云
    private TextView mTextViewCloud;
    //风向
    private TextView mTextViewWind;
    //力度
    private TextView mTextViewDu;
    private TextView mTextViewIsShow;
    //天气状况icon
    private ImageView mImageViewIcon;
    private String[] mItemData;
    private String mTemperature;
    private String mCityName;
    private Weather mWeather;
    private String mWeatherInfoCould;
    private String mWind;
    private String power;
    private String mJson;

    private int[] mPhoto;
    private HomeAdapter mHomeAdapter;
    private boolean isShowWeather;


    private WeatherDetail weather;
    private Intent intent;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Weather mWeather = (Weather) msg.obj;
            setWeatherData(mWeather);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StackManager.onActivityCreated(this);
        initData();
        initView();
    }

    /**
     * 初始化数据
     */
    public void initData() {
        mItemData = new String[]{"QQ号测吉凶", "手机号查询", "IP查询", "身份证查询", "周公解梦", "星座运势",
                "成语查询", "历史上的今天", "H5在线电影票", "汇率"};
        mPhoto = new int[]{R.drawable.qq, R.drawable.phone, R.drawable.ip, R.drawable.idcard, R.drawable.zhougong,
                R.drawable.start, R.drawable.idiom, R.drawable.history, R.drawable.movie_h5, R.drawable.huilv};
        Bundle extras = getIntent().getExtras();
        isShowWeather = extras.getBoolean("isShowWeather");
        mCityName = extras.getString("city");
        mJson = extras.getString("json");
        if (mJson != null) {
            parseJson(mJson);
        }


    }

    /**
     * 解析json
     *
     * @param jsonString
     */
    private void parseJson(final String jsonString) {

        final Gson gson = new Gson();
        new Thread(new Runnable() {
            @Override
            public void run() {
                mWeather = gson.fromJson(jsonString, Weather.class);
                Message message = Message.obtain();
                message.obj = mWeather;
                mHandler.sendMessage(message);
            }
        }).start();


    }

    /**
     * 获取具体数据
     *
     * @param weather
     */
    private void setWeatherData(Weather weather) {
        //获取WeatherData
        WeatherData weatherData = weather.getResult().getData();
        //获取白天 夜间温度
        List<WeatherList> weather1 = weatherData.getWeather();
        WeatherDayInfo weatherDayInfo = weather1.get(0).getInfo();
        String[] day = weatherDayInfo.getDay();
        String[] night = weatherDayInfo.getNight();
        String temperatureDay = day[2];
        String temperatureNight = night[0];
        //获取 WeatherRealtime
        WeatherRealtime weatherRealtime = weatherData.getRealtime();
        //获取weather
        WeatherDetail weatherDetail = weatherRealtime.getWeather();
        //获取风力
        WeatherWind wind = weatherRealtime.getWind();


        mTemperature = weatherDetail.getTemperature();
        mWeatherInfoCould = weatherDetail.getInfo();
        mWind = wind.getDirect();
        power = wind.getPower();

        mTextViewCity.setText(mCityName);
        mTextViewTemperature.setText(mTemperature);
        mTextViewWind.setText(mWind + power + " ");
        mTextViewCloud.setText(mWeatherInfoCould);
        mTextViewDu.setText("°");

        mTextViewDuration.setText(temperatureNight + " / " + temperatureDay);

    }


    /**
     * 初始化布局
     */
    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recyclerView);
        mTextViewCity = (TextView) findViewById(R.id.city_textView);
        mTextViewTemperature = (TextView) findViewById(R.id.temperature_textView);
        mTextViewCloud = (TextView) findViewById(R.id.weatherCloud_textView);
        mTextViewDuration = (TextView) findViewById(R.id.duration_temperature);
        mTextViewWind = (TextView) findViewById(R.id.weatherWind_textView);
        mImageViewIcon = (ImageView) findViewById(R.id.weatherIcon_image);
        mTextViewIsShow = (TextView) findViewById(R.id.text_info_show);
        mTextViewDu = (TextView) findViewById(R.id.text_du);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mHomeAdapter = new HomeAdapter(this, mItemData, mPhoto);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mHomeAdapter);


        mHomeAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                if (mItemData[position].equals(mItemData[0])) {
                    startMyActivity(QLuckActivity.class, position);
                } else if (mItemData[position].equals(mItemData[1])) {
                    startMyActivity(PhoneActivity.class, position);

                } else if (mItemData[position].equals(mItemData[2])) {
                    startMyActivity(IPActivity.class, position);

                } else if (mItemData[position].equals(mItemData[3])) {
                    startMyActivity(IdCardActivity.class, position);

                } else if (mItemData[position].equals(mItemData[4])) {
                    startMyActivity(ZhouGongActivity.class, position);

                } else if (mItemData[position].equals(mItemData[5])) {
                    startMyActivity(StartActivity.class, position);
                } else if (mItemData[position].equals(mItemData[6])) {
                    startMyActivity(IdiomActivity.class, position);
                } else if (mItemData[position].equals(mItemData[7])) {
                    startMyActivity(HistoryActivity.class, position);

                } else if (mItemData[position].equals(mItemData[8])) {
                    Intent intent = new Intent(MainActivity.this, IdCardActivity.class);
                    startActivity(intent);

                }

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        if (isShowWeather) {
            mTextViewIsShow.setVisibility(View.VISIBLE);
        } else {
            mTextViewIsShow.setVisibility(View.GONE);

        }


    }

    public void startMyActivity(Class clazz, int position) {
        intent = new Intent();
        intent.putExtra("title", mItemData[position]);
        intent.setClass(MainActivity.this, clazz);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackManager.onActivityDestory(this);
    }


}
