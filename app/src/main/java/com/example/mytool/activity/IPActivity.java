package com.example.mytool.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mytool.R;
import com.example.mytool.bean.ip.IP;
import com.example.mytool.bean.ip.IpResult;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.StackManager;
import com.example.mytool.volley.CommentVolley;

public class IPActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTextViewQuery;
    private EditText mEditTextIp;
    private TextView mTextIpArea;
    private TextView mTextIpResult;
    private TextView mTextIpError;
    private TextView mTextTitle;
    private String ipNumber;
    private IpResult result;
    private String area;
    private String location;
    private String mTitleString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);
        StackManager.onActivityCreated(this);
        initData();
        initView();

    }

    private void initData() {
        mTitleString =getIntent().getStringExtra("title");
    }


    public void initView() {
        mEditTextIp = (EditText) findViewById(R.id.number_input);
        mTextViewQuery = (TextView) findViewById(R.id.query_text);
        mTextIpArea = (TextView) findViewById(R.id.ip_text_area);
        mTextIpResult = (TextView) findViewById(R.id.ip_text_location);
        mTextIpError = (TextView) findViewById(R.id.ip_error_text);
        mTextTitle = (TextView) findViewById(R.id.title_text);
        mTextTitle.setText(mTitleString);
        mEditTextIp.setHint(mTitleString);
        mTextViewQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ipNumber = mEditTextIp.getText().toString();
        getIpContentFromNet(ipNumber);

    }

    private void getIpContentFromNet(String ipNumber) {
        CommentVolley<IP> commentVolley = new CommentVolley<IP>();
        IP ip = new IP();
        String url = API.IPURL + ipNumber;
        commentVolley.getDateByVolley(url, this, ip, new CommentVolley.VolleyCallBack<IP>() {

            @Override
            public void success(IP ip) {
                if (ip.getResult() == null) {
                    mTextIpError.setText(ip.getReason());
                    mTextIpError.setVisibility(View.VISIBLE);
                } else {
                    result = ip.getResult();
                    area = result.getArea();
                    location = result.getLocation();
                    mTextIpArea.setText("area : " + area);
                    mTextIpResult.setText("location ： " + location);
                    mTextIpError.setVisibility(View.GONE);
                }


            }

            @Override
            public void error(String str) {

            }
        });


    }


}
