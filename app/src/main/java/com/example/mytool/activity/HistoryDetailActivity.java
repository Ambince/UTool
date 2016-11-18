package com.example.mytool.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mytool.R;
import com.example.mytool.bean.history.HistoryDetail;
import com.example.mytool.bean.history.HistoryDetailResult;
import com.example.mytool.bean.history.HistoryDetailResultUrl;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.StackManager;
import com.example.mytool.uitil.Util;
import com.example.mytool.volley.CommentVolley;

import java.util.List;

public class HistoryDetailActivity extends BaseActivity {
    private String url;
    private TextView mTextViewTitle;
    private ImageView mImageView;
    private TextView mTextViewContent;
    private Context mContext;
    private List<HistoryDetailResultUrl> picUrl;
    private String HISTORY_DETAIL_KEY = "HISTORY_DETAIL_KEY";
    private static final String HISTORY_DETAIL_FIRSET = "HISTORY_DETAIL_FIRSET";
    private String urlKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        StackManager.onActivityCreated(this);
        mContext = this;
        urlKey = getIntent().getStringExtra("e_id");
        HISTORY_DETAIL_KEY += urlKey;

        initView();
        initData();
    }

    private void initData() {
        HistoryDetail historyDetail = new HistoryDetail();
        CommentVolley.isCache = true;
        CommentVolley.cacheKey = HISTORY_DETAIL_KEY;
        Log.v("Amence", CommentVolley.cacheKey);
        if (!Util.isNetWorkAvailable(this)) {
            HistoryDetail data = Util.parseGson(Util.getString(this, HISTORY_DETAIL_KEY), historyDetail);
            if (data.getResult() != null) {
                onHandlerUI(data.getResult().get(0));

            } else {
                Toast.makeText(HistoryDetailActivity.this, "网上没有数据，看不了了！", Toast.LENGTH_SHORT).show();

            }
        } else {
            url = API.HISTORYDETAIL + urlKey;
            Log.v("Amence", url);
            CommentVolley<HistoryDetail> commentVolley = new CommentVolley<HistoryDetail>();
            commentVolley.getDateByVolley(url, this, historyDetail, new CommentVolley.VolleyCallBack<HistoryDetail>() {
                @Override
                public void success(HistoryDetail historyDetail) {

                    if (historyDetail.getResult() != null) {
                        onHandlerUI(historyDetail.getResult().get(0));
                    } else {
                        Toast.makeText(HistoryDetailActivity.this, "网上没有数据，看不了了！", Toast.LENGTH_SHORT).show();
                    }


                }

                @Override
                public void error(String str) {

                }
            });
        }


    }

    private void onHandlerUI(HistoryDetailResult historyDetailResult) {
        if (historyDetailResult != null) {
            mTextViewTitle.setText(historyDetailResult.getTitle());
            picUrl = historyDetailResult.getPicUrl();
            mTextViewContent.setText(historyDetailResult.getContent());
            if (picUrl.size() > 0) {
                mImageView.setVisibility(View.VISIBLE);
                Glide.with(mContext)
                        .load(picUrl.get(0).getUrl())
                        .into(mImageView);
            } else {
                mImageView.setVisibility(View.GONE);
            }

        } else {
            Toast.makeText(HistoryDetailActivity.this, "网上没有数据，看不了了！", Toast.LENGTH_SHORT).show();
        }

    }

    private void initView() {
        mTextViewTitle = (TextView) findViewById(R.id.text_title);
        mTextViewContent = (TextView) findViewById(R.id.text_content);
        mImageView = (ImageView) findViewById(R.id.title_image);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackManager.onActivityDestory(this);
    }
}
