package com.example.mytool.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytool.R;
import com.example.mytool.bean.start.StartDayLuck;
import com.example.mytool.bean.start.StartMonthLuck;
import com.example.mytool.bean.start.StartWeekLuck;
import com.example.mytool.bean.start.StartYearLuck;
import com.example.mytool.custom.spinner.NiceSpinner;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.Util;
import com.example.mytool.volley.CommentVolley;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StartActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTextViewTitle;
    private Button mButToday;
    private Button mButTomorrow;
    private Button mButWeek;
    private Button mButNextWeek;
    private Button mButYear;
    private Button mButMonth;
    private String mTitleString;
    private String mEditString;

    private NiceSpinner mNiceSpinner;
    private TextView mTextStartName;
    private TextView mTextStartDateTime;
    private TextView mTextStartAll;
    private TextView mTextStartColor;
    private TextView mTextStartHealth;
    private TextView mTextStartLove;
    private TextView mTextStartMoney;
    private TextView mTextStartNumber;
    private TextView mTextStartQFriend;
    private TextView mTextStartSummary;
    private TextView mTextStartWork;
    private LinearLayout mLinearLayout;


    List<String> dataset = new LinkedList<>(Arrays.asList("白羊座", "金牛座", "双子座", "巨蟹座", "狮子座",
            "处女座", "天枰座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initData();
        initView();
    }

    private void initData() {


    }

    private void initView() {
        mTextViewTitle = (TextView) findViewById(R.id.title_text);
        mButToday = (Button) findViewById(R.id.today_but);
        mButTomorrow = (Button) findViewById(R.id.tomorrow_but);
        mButWeek = (Button) findViewById(R.id.week_but);
        mButNextWeek = (Button) findViewById(R.id.next_week_but);
        mButMonth = (Button) findViewById(R.id.month_but);
        mButYear = (Button) findViewById(R.id.year_but);
        mLinearLayout = (LinearLayout) findViewById(R.id.history_content);

        mTextStartName = (TextView) findViewById(R.id.start_name);
        mTextStartDateTime = (TextView) findViewById(R.id.start_datetime);
        mTextStartAll = (TextView) findViewById(R.id.start_all);
        mTextStartColor = (TextView) findViewById(R.id.start_color);
        mTextStartHealth = (TextView) findViewById(R.id.start_health);
        mTextStartLove = (TextView) findViewById(R.id.start_love);
        mTextStartMoney = (TextView) findViewById(R.id.start_money);
        mTextStartNumber = (TextView) findViewById(R.id.start_number);
        mTextStartQFriend = (TextView) findViewById(R.id.start_QFriend);
        mTextStartSummary = (TextView) findViewById(R.id.start_summary);
        mTextStartWork = (TextView) findViewById(R.id.start_work);
        mNiceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
        mTitleString = getIntent().getStringExtra("title");
        mNiceSpinner.attachDataSource(dataset);
        mTextViewTitle.setText(mTitleString);
        mButToday.setOnClickListener(this);
        mButTomorrow.setOnClickListener(this);
        mButWeek.setOnClickListener(this);
        mButNextWeek.setOnClickListener(this);
        mButYear.setOnClickListener(this);
        mButMonth.setOnClickListener(this);

        mNiceSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayout.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.today_but:
                mLinearLayout.setVisibility(View.VISIBLE);
                mEditString = mNiceSpinner.getText().toString().trim();
                if (Util.isNetWorkAvailable(this)) {
                    getDayFromNet("today");
                } else {
                    Toast.makeText(this, "亲！木有网络哟", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.tomorrow_but:
                mLinearLayout.setVisibility(View.VISIBLE);

                mEditString = mNiceSpinner.getText().toString().trim();
                if (Util.isNetWorkAvailable(this)) {
                    getDayFromNet("tomorrow");
                } else {
                    Toast.makeText(this, "亲！木有网络哟", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.week_but:
                mLinearLayout.setVisibility(View.VISIBLE);

                mEditString = mNiceSpinner.getText().toString().trim();
                if (Util.isNetWorkAvailable(this)) {
                    getWeekFromNet("week");
                } else {
                    Toast.makeText(this, "亲！木有网络哟", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.next_week_but:
                mLinearLayout.setVisibility(View.VISIBLE);

                mEditString = mNiceSpinner.getText().toString().trim();
                if (Util.isNetWorkAvailable(this)) {
                    getWeekFromNet("nextweek");
                } else {
                    Toast.makeText(this, "亲！木有网络哟", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.month_but:
                mLinearLayout.setVisibility(View.VISIBLE);

                mEditString = mNiceSpinner.getText().toString().trim();
                if (Util.isNetWorkAvailable(this)) {
                    getMonthFromNet("month");
                } else {
                    Toast.makeText(this, "亲！木有网络哟", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.year_but:
                mLinearLayout.setVisibility(View.VISIBLE);

                mEditString = mNiceSpinner.getText().toString().trim();
                if (Util.isNetWorkAvailable(this)) {
                    getYearFromNet("year");
                } else {
                    Toast.makeText(this, "亲！木有网络哟", Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }

    private void getYearFromNet(String str) {
        String url = getUrl(str);
        CommentVolley<StartYearLuck> commentVolley = new CommentVolley<StartYearLuck>();
        StartYearLuck startYearLuck = new StartYearLuck();
        commentVolley.getDateByVolley(url, this, startYearLuck, new CommentVolley.VolleyCallBack<StartYearLuck>() {
            @Override
            public void success(StartYearLuck startYearLuck) {
                mTextStartName.setText("星座名称:    " + startYearLuck.getName() + "\n");
                mTextStartDateTime.setText("时间:    " + startYearLuck.getDate() + "\n");
                mTextStartAll.setText("职业分析:    " + startYearLuck.getCareer()[0] + "\n");
                mTextStartHealth.setText("健康指数:    " + startYearLuck.getHealth()[0] + "\n");
                mTextStartLove.setText("爱情指数:    " + startYearLuck.getLove()[0] + "\n");
                mTextStartMoney.setText("财运指数:    " + startYearLuck.getFinance()[0] + "\n");
                if (startYearLuck.getLuckyStone() != null) {
                    mTextStartNumber.setText("幸运石：    " + startYearLuck.getLuckyStone() + "\n");

                } else {
                    mTextStartNumber.setText("幸运石：    " + "\n");

                }
                mTextStartQFriend.setText("信息：    " + startYearLuck.getMima().getInfo() + "\n");
                mTextStartSummary.setText("总结：    " + startYearLuck.getMima().getText()[0] + "\n");
            }

            @Override
            public void error(String str) {

            }
        });

    }

    private void getMonthFromNet(String str) {
        String url = getUrl(str);
        CommentVolley<StartMonthLuck> commentVolley = new CommentVolley<StartMonthLuck>();
        StartMonthLuck startMonthLuck = new StartMonthLuck();
        commentVolley.getDateByVolley(url, this, startMonthLuck, new CommentVolley.VolleyCallBack<StartMonthLuck>() {
            @Override
            public void success(StartMonthLuck startMonthLuck) {
                mTextStartName.setText("星座名称:    " + startMonthLuck.getName() + "\n");
                mTextStartDateTime.setText("时间:    " + startMonthLuck.getDate() + "\n");
                mTextStartAll.setText("求职指数:    " + startMonthLuck.getWork() + "\n");
                mTextStartColor.setText("工作分析:    " + startMonthLuck.getWork() + "\n");
                mTextStartHealth.setText("健康指数:    " + startMonthLuck.getHealth() + "\n");
                mTextStartLove.setText("爱情指数:    " + startMonthLuck.getLove() + "\n");
                mTextStartMoney.setText("财运指数:    " + startMonthLuck.getMoney() + "\n");
                mTextStartSummary.setText("总结:    " + startMonthLuck.getAll() + "\n");

            }

            @Override
            public void error(String str) {

            }
        });

    }

    private void getWeekFromNet(String str) {
        String url = getUrl(str);
        CommentVolley<StartWeekLuck> commentVolley = new CommentVolley<StartWeekLuck>();
        StartWeekLuck startWeekLuck = new StartWeekLuck();
        commentVolley.getDateByVolley(url, this, startWeekLuck, new CommentVolley.VolleyCallBack<StartWeekLuck>() {
            @Override
            public void success(StartWeekLuck startWeekLuck) {
                mTextStartName.setText("星座名称:    " + startWeekLuck.getName());
                mTextStartDateTime.setText("时间:    " + startWeekLuck.getDate());
                mTextStartAll.setText("求职指数:    " + startWeekLuck.getJob());
                mTextStartColor.setText("工作分析:    " + startWeekLuck.getWork());
                mTextStartHealth.setText("健康指数:    " + startWeekLuck.getHealth());
                mTextStartLove.setText("爱情指数:    " + startWeekLuck.getLove());
                mTextStartMoney.setText("财运指数:    " + startWeekLuck.getMoney());
            }

            @Override
            public void error(String str) {

            }
        });

    }

    private void getDayFromNet(String str) {
        String url = getUrl(str);
        CommentVolley<StartDayLuck> commentVolley = new CommentVolley<StartDayLuck>();
        StartDayLuck startLuck = new StartDayLuck();
        commentVolley.getDateByVolley(url, this, startLuck, new CommentVolley.VolleyCallBack<StartDayLuck>() {
            @Override
            public void success(StartDayLuck startLuck) {
                Log.v("Amence", startLuck.toString());
                if (startLuck != null) {
                    mTextStartName.setText("星座名称:    " + startLuck.getName());
                    mTextStartDateTime.setText("时间:    " + startLuck.getDatetime());
                    mTextStartAll.setText("综合指数:    " + startLuck.getAll());
                    mTextStartColor.setText("幸运颜色:    " + startLuck.getColor());
                    mTextStartHealth.setText("健康指数:    " + startLuck.getHealth());
                    mTextStartLove.setText("爱情指数:    " + startLuck.getLove());
                    mTextStartMoney.setText("财运指数:    " + startLuck.getMoney());
                    mTextStartNumber.setText("幸运数字：    " + startLuck.getNumber());
                    mTextStartQFriend.setText("速配星座：    " + startLuck.getQFriend());
                    mTextStartSummary.setText("总结:    " + startLuck.getSummary());
                    mTextStartWork.setText("工作指数：    " + startLuck.getWork());
                } else {

                }


            }

            @Override
            public void error(String str) {

            }
        });

    }

    private String getUrl(String str) {
        String date = str.trim();
        String url = API.STARTLUCKURL + date + "&consName=" + mEditString;
        return url;
    }


}
