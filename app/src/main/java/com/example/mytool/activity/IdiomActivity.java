package com.example.mytool.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mytool.R;
import com.example.mytool.bean.idiom.Idiom;
import com.example.mytool.bean.idiom.IdiomResult;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.StackManager;
import com.example.mytool.uitil.Util;
import com.example.mytool.volley.CommentVolley;

import org.w3c.dom.Text;

public class IdiomActivity extends BaseActivity {

    private EditText mEditText;
    private TextView mTextViewQuery;
    private String mIdiomText;
    private IdiomResult result;
    private String mTitleString;
    private TextView mTextViewBuShou;
    private TextView mTextViewHead;
    private TextView mTextViewPinYin;
    private TextView mTextViewExplain;
    private TextView mTextViewFrom;
    private TextView mTextViewExample;
    private TextView mTextViewGrammar;
    private TextView mTextViewTermExplain;
    private TextView mTextViewYinYong;
    private TextView mTextViewSynonymous;
    private TextView mTextViewError;
    private TextView mTextViewIdiom;
    private LinearLayout mLinearLayout;
    private TextView mTextTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idom);
        StackManager.onActivityCreated(this);
        initData();
        initView();
    }

    private void initData() {
        mTitleString = getIntent().getStringExtra("title");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackManager.onActivityDestory(this);

    }


    public void initView() {
        mEditText = (EditText) findViewById(R.id.number_input);
        mTextViewQuery = (TextView) findViewById(R.id.query_text);
        mTextViewBuShou = (TextView) findViewById(R.id.bushou_text);
        mTextViewHead = (TextView) findViewById(R.id.head_text);
        mTextViewPinYin = (TextView) findViewById(R.id.pingyin_text);
        mTextViewExplain = (TextView) findViewById(R.id.chengyujs_text);
        mTextViewFrom = (TextView) findViewById(R.id.from_text);
        mTextViewExample = (TextView) findViewById(R.id.example_text);
        mTextViewGrammar = (TextView) findViewById(R.id.yufa_text);
        mTextViewTermExplain = (TextView) findViewById(R.id.ciyujs_text);
        mTextViewYinYong = (TextView) findViewById(R.id.yinzhengjs_text);
        mTextViewSynonymous = (TextView) findViewById(R.id.citongyi_text);
        mTextViewError = (TextView) findViewById(R.id.idiom_error_text);
        mLinearLayout = (LinearLayout) findViewById(R.id.idiom_ll);
        mTextViewIdiom = (TextView) findViewById(R.id.idiom_text);
        mTextTitle = (TextView) findViewById(R.id.title_text);

        mTextTitle.setText(mTitleString);
        mEditText.setHint(mTitleString);


        mTextViewQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIdiomText = mEditText.getText().toString();
                CommentVolley<Idiom> commentVolley = new CommentVolley<Idiom>();
                String url = API.IDIOMURL + Util.HanZi4UrlUnicode(mIdiomText);
                Idiom idiom = new Idiom();
                commentVolley.getDateByVolley(url, IdiomActivity.this, idiom, new CommentVolley.VolleyCallBack<Idiom>() {
                    @Override
                    public void success(Idiom idiom) {
                        if (idiom.getReason().equals("success")) {
                            mTextViewIdiom.setVisibility(View.VISIBLE);
                            mTextViewError.setVisibility(View.GONE);
                            mLinearLayout.setVisibility(View.VISIBLE);
                            mTextViewIdiom.setText(mIdiomText);
                            result = idiom.getResult();
                            mTextViewBuShou.setText("部首： " + result.getBushou());
                            mTextViewHead.setText("头： " + result.getHead());
                            mTextViewPinYin.setText("拼音： " + result.getPinyin());
                            mTextViewExplain.setText("成语解释： " + result.getExample());
                            mTextViewFrom.setText("摘自： " + result.getFrom_());
                            mTextViewExample.setText("例子： " + result.getExample());
                            mTextViewGrammar.setText("语法： " + result.getYufa());
                            mTextViewTermExplain.setText("词语解释： " + result.getCiyujs());
                            mTextViewYinYong.setText("应用解释： " + result.getYinzhengjs());
                            String str = "";
                            for (int i = 0; i < result.getTongyi().length; i++) {
                                if (result.getTongyi()[i] != null) {
                                    str += result.getTongyi()[i];
                                }

                            }
                            mTextViewSynonymous.setText("同义： " + str);


                        } else {
                            mTextViewIdiom.setVisibility(View.GONE);
                            mLinearLayout.setVisibility(View.GONE);
                            mTextViewError.setText(idiom.getReason());
                            mTextViewError.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void error(String str) {

                    }
                });

            }
        });
    }
}
