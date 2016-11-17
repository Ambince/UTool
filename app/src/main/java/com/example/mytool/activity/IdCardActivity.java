package com.example.mytool.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mytool.R;
import com.example.mytool.bean.idCard.IdCard;
import com.example.mytool.bean.idCard.IdResult;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.StackManager;
import com.example.mytool.volley.CommentVolley;

public class IdCardActivity extends BaseActivity implements View.OnClickListener {
    private EditText mEditText;
    private TextView mTextViewQuery;
    private TextView mTextViewArea;
    private TextView mTextViewSex;
    private TextView mTextViewbirthday;
    private TextView mTextViewReason;
    private TextView mTextVieTitle;
    private String mIdCardNumber;
    private IdResult result;
    private String area;
    private String sex;
    private String birthday;
    private String reason;
    private String resultcode;
    private String mTitleString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_card);
        StackManager.onActivityCreated(this);
        initData();
        initView();
    }

    private void initData() {
        mTitleString = getIntent().getStringExtra("title");
    }

    public void initView() {
        mEditText = (EditText) findViewById(R.id.number_input);
        mTextViewQuery = (TextView) findViewById(R.id.query_text);
        mTextViewArea = (TextView) findViewById(R.id.area_text);
        mTextViewbirthday = (TextView) findViewById(R.id.birthday_text);
        mTextViewSex = (TextView) findViewById(R.id.sex_text);
        mTextViewReason = (TextView) findViewById(R.id.response_reason_text);
        mTextVieTitle = (TextView) findViewById(R.id.title_text);
        mTextVieTitle.setText(mTitleString);
        mEditText.setHint(mTitleString);
        mTextViewQuery.setOnClickListener(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackManager.onActivityDestory(this);
    }


    @Override
    public void onClick(View v) {
        mIdCardNumber = mEditText.getText().toString();
        String url = API.IDCORDURL + mIdCardNumber;
        CommentVolley<IdCard> commentVolley = new CommentVolley<IdCard>();
        IdCard card = new IdCard();
        commentVolley.getDateByVolley(url, this, card, new CommentVolley.VolleyCallBack<IdCard>() {
            @Override
            public void success(IdCard idCard) {

                resultcode = idCard.getResultcode();
                if (resultcode.equals("200")) {
                    result = idCard.getResult();
                    if (result != null) {
                        mTextViewArea.setText("所属地区：    " + result.getArea());
                        mTextViewbirthday.setText("生日：   " + result.getBirthday());
                        mTextViewSex.setText("性别：  " + result.getSex());
                        mTextViewReason.setVisibility(View.GONE);
                    }
                } else {
                    reason = idCard.getReason();
                    mTextViewReason.setText(reason);
                    mTextViewReason.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void error(String str) {

            }
        });

    }
}
