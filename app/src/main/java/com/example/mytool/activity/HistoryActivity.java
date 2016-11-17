package com.example.mytool.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mytool.R;
import com.example.mytool.adapter.HistoryAdapter;
import com.example.mytool.bean.history.History;
import com.example.mytool.bean.history.HistoryResult;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.StackManager;
import com.example.mytool.uitil.Util;
import com.example.mytool.volley.CommentVolley;

import java.util.List;

public class HistoryActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private TextView mTextTitle;

    private List<HistoryResult> result;
    private HistoryAdapter historyAdapter;
    private String mTitleStr;

    public static final String HISTORY_KEY = "HISTORY_KEY";
    public static final String HISTORY_FIRST = "HISTORY_FIRST";
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        StackManager.onActivityCreated(this);
        initView();

        initData();
    }

    private void initView() {
        mTextTitle = (TextView) findViewById(R.id.title_text);
        mRecyclerView = (RecyclerView) findViewById(R.id.history_recycler);

        mTitleStr = getIntent().getStringExtra("title");
        mTextTitle.setText(mTitleStr);
    }


    private void initData() {

        String jsonCache = Util.getString(this, HISTORY_KEY);
        boolean isFirst = Util.getBoolean(this, HISTORY_FIRST);
        History history = new History();
        if (!isFirst && !Util.isWifi(this)) {//如果不是第一次或者wifi
            onHandlerUI(Util.parseGson(jsonCache, history));

        } else {//仅在第一次或者在wifi情况下处理
            Util.saveBoolean(this, HISTORY_FIRST, false);
            CommentVolley<History> commentVolley = new CommentVolley<History>();
            CommentVolley.cacheKey = HISTORY_KEY;
            CommentVolley.isCache = true;
            String date = Util.getCurrentTime();
            String url = API.HESTORYURL + Util.HanZi4UrlUnicode(date);
            commentVolley.getDateByVolley(url, this, history, new CommentVolley.VolleyCallBack<History>() {
                @Override
                public void success(History history) {
                    onHandlerUI(history);

                }

                @Override
                public void error(String str) {

                }
            });


        }


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackManager.onActivityDestory(this);
    }

    /**
     * 处理数据和UI的操作
     *
     * @param history
     */
    public void onHandlerUI(History history) {
        result = history.getResult();
        historyAdapter = new HistoryAdapter(result, HistoryActivity.this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(HistoryActivity.this, 3));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(historyAdapter);

        historyAdapter.setOnItemClickListener(new HistoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                id = result.get(position).getE_id();
                Intent intent = new Intent(HistoryActivity.this, HistoryDetailActivity.class);
                intent.putExtra("e_id", id);
                startActivity(intent);

            }

            @Override
            public void onItemLongClick(View view, int position) {
                Intent intent = new Intent(HistoryActivity.this, HistoryDetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
