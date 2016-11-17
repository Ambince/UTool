package com.example.mytool.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytool.R;
import com.example.mytool.bean.zhougong.ZhouGong;
import com.example.mytool.bean.zhougong.ZhouGongResult;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.StackManager;
import com.example.mytool.uitil.Util;
import com.example.mytool.volley.CommentVolley;

import java.util.List;

public class ZhouGongActivity extends BaseActivity {

    private TextView mTextViewTitle;
    private EditText mEditTextInput;
    private TextView mTextViewQuery;
    private TextView mTextViewContent;
    private String mTitleString;
    private String mEditTextString;
    private List<ZhouGongResult> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhou_gong);
        initData();
        initView();

    }

    public void initData() {
        mTitleString = getIntent().getStringExtra("title");

    }

    public void initView() {
        mTextViewTitle = (TextView) findViewById(R.id.title_text);
        mEditTextInput = (EditText) findViewById(R.id.number_input);
        mTextViewQuery = (TextView) findViewById(R.id.query_text);
        mTextViewContent = (TextView) findViewById(R.id.zhougong_content);
        mTextViewTitle.setText(mTitleString);
        mEditTextInput.setHint(mTitleString);

        mTextViewQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromNet();

            }
        });
    }

    private void getDataFromNet() {
        mEditTextString = mEditTextInput.getText().toString();
        String uri = API.ZHOUGONGURL + Util.HanZi4UrlUnicode(mEditTextString);

        CommentVolley<ZhouGong> commentVolley = new CommentVolley<ZhouGong>();
        ZhouGong zhouGong = new ZhouGong();
        commentVolley.getDateByVolley(uri, ZhouGongActivity.this, zhouGong, new CommentVolley.VolleyCallBack<ZhouGong>() {
            @Override
            public void success(ZhouGong zhouGong) {
                Log.v("Amence", zhouGong.toString());
                if (zhouGong.getResult() != null) {
                    result = zhouGong.getResult();
                    String resultData = "";
                    for (int i = 0; i < result.size(); i++) {
                        resultData += result.get(i).getTitle() + "\n" + result.get(i).getDes() + "\n" + "\n";

                    }
                    mTextViewContent.setText(resultData);
                } else {
                    Toast.makeText(ZhouGongActivity.this, "周公这个梦解不了呀！！！", Toast.LENGTH_SHORT).show();
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
}
