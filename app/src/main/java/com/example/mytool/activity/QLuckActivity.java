package com.example.mytool.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.mytool.R;
import com.example.mytool.bean.qq.Qdata;
import com.example.mytool.bean.qq.Qluck;
import com.example.mytool.bean.qq.Qresult;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.StackManager;
import com.example.mytool.volley.CommentVolley;

public class QLuckActivity extends BaseActivity {
    private EditText mEditText;
    private TextView mTextViewQuery;
    private TextView mTextViewConclusion;
    private TextView mTextViewAnalysis;
    private TextView mTextViewError;
    private TextView mTextTitle;
    private String qq;

    private String conclusion;
    private String analysis;
    private QLuckActivity activity;
    private String mTitleString;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Qdata qdata = (Qdata) msg.obj;
            analysis = qdata.getAnalysis();
            conclusion = qdata.getConclusion();
            //设置数据
            mTextViewConclusion.setText(conclusion);
            mTextViewAnalysis.setText(analysis);
            activity.reportFullyDrawn();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qluck);
        StackManager.onActivityCreated(this);
        activity = this;
        initView();
        initData();


    }

    public void initData() {

        mTextViewQuery.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                qq = mEditText.getText().toString();
                //进行网络请求
                getQQContent(qq);

            }
        });


    }

    //初始化控件
    public void initView() {
        mTitleString = getIntent().getStringExtra("title");
        mEditText = (EditText) findViewById(R.id.number_input);
        mTextViewQuery = (TextView) findViewById(R.id.query_text);
        mTextViewConclusion = (TextView) findViewById(R.id.conclusion_textView);
        mTextViewAnalysis = (TextView) findViewById(R.id.analysis_textView);
        mTextViewError = (TextView) findViewById(R.id.qq_error_text);
        mTextTitle = (TextView) findViewById(R.id.title_text);
        mTextTitle.setText(mTitleString);
        mEditText.setHint(mTitleString);
    }

    //获取数据
    private void getQQContent(String qq) {

        final RequestQueue queue = Volley.newRequestQueue(this);
        String url = API.QQURL + qq;
        Log.v("Amence", "qqUrl" + url);
        CommentVolley<Qluck> commentVolley = new CommentVolley<>();
        Qluck qluck = new Qluck();
        commentVolley.getDateByVolley(url, this, qluck, new CommentVolley.VolleyCallBack<Qluck>() {
            @Override
            public void success(Qluck qluck) {
                if (qluck.getError_code().equals("0")) {
                    Qresult result = qluck.getResult();
                    Qdata data = result.getData();
                    Message message = Message.obtain();
                    message.obj = data;
                    mHandler.sendMessage(message);
                    mTextViewError.setVisibility(View.GONE);
                } else {
                    mTextViewError.setText(qluck.getReason());
                    mTextViewError.setVisibility(View.VISIBLE);

                }


            }

            @Override
            public void error(String str) {

            }
        });


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackManager.onActivityDestory(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        StackManager.finishActivity(this.getClass().getName());
    }
}
