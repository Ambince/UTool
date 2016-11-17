package com.example.mytool.volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mytool.activity.HistoryActivity;
import com.example.mytool.uitil.Util;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by Amence on 2016/11/10.
 */

public class CommentVolley<T> {

    public static boolean isCache = false;
    public static String cacheKey;
    private Context mContext;

    T jsonData;

    /**
     * volley 获取获取网络数据通用方法
     *
     * @param url
     * @param context
     * @param t
     * @return
     */
    public void getDateByVolley(String url, Context context, final T t, final VolleyCallBack callBack) {
        this.mContext = context;
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest json = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                setCacheString(jsonObject.toString());
                jsonData = Util.parseGson(jsonObject.toString(), t);
                if (callBack != null) {
                    callBack.success(jsonData);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(json);

    }

    public interface VolleyCallBack<T> {
        void success(T t);

        void error(String str);

    }

    public void setCacheString(String json) {
        Util.saveString(mContext, this.cacheKey, json);
    }


}
