package com.example.mytool.activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mytool.R;
import com.example.mytool.bean.phone.PhoneInfo;
import com.example.mytool.bean.phone.PhoneResult;
import com.example.mytool.db.AddressDao;
import com.example.mytool.uitil.API;
import com.example.mytool.uitil.StackManager;
import com.example.mytool.uitil.Util;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PhoneActivity extends BaseActivity implements View.OnClickListener {
    private EditText mEditText;
    private TextView mTextView;
    private ImageView mImageView;
    private String mPhoneNumber;
    private Context mContext;
    private TextView mNumber;
    private TextView mAddress;
    private TextView mCardInfo;
    private TextView mBlock;
    private TextView mZipCode;
    private TextView mLuck;
    private TextView mLocalResult;
    private String result;
    private PhoneResult phoneResult;
    private LinearLayout mLinearLayout;
    private TextView mTextTitle;
    private String mTitleString;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 0:
                    result = (String) msg.obj;
                    mLinearLayout.setVisibility(View.GONE);
                    mLocalResult.setVisibility(View.VISIBLE);
                    mLocalResult.setText("本地数据库查询结果:" + result);
                    break;

                case 1:
                    result = (String) msg.obj;
                    if (result.equals("error")) {
                        Toast.makeText(PhoneActivity.this, "由于网络服务器异常，使用本地数据查询", Toast.LENGTH_SHORT).show();
                        queryFormDBA(mPhoneNumber);

                    } else {
                        mLinearLayout.setVisibility(View.VISIBLE);
                        mAddress.setText("归属地:   " + phoneResult.getProvince() + phoneResult.getCity());
                        mCardInfo.setText("卡信息:   " + phoneResult.getCompany());
                        mBlock.setText("区号:   " + phoneResult.getAreacode());
                        mZipCode.setText("邮编:   " + phoneResult.getZip());
                        mNumber.setText("号码:   " + mPhoneNumber);
                        mLuck.setText("测吉凶:   吉");
                        mLocalResult.setVisibility(View.GONE);
                    }

                    break;
            }


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        mContext = this;
        StackManager.onActivityCreated(this);
        initData();
        initView();
    }

    public void initView() {
        mEditText = (EditText) findViewById(R.id.number_input);
        mTextView = (TextView) findViewById(R.id.query_text);
        mImageView = (ImageView) findViewById(R.id.call_phone);
        mCardInfo = (TextView) findViewById(R.id.info_card);
        mAddress = (TextView) findViewById(R.id.address);
        mBlock = (TextView) findViewById(R.id.block);
        mZipCode = (TextView) findViewById(R.id.zip_code);
        mLuck = (TextView) findViewById(R.id.luck);
        mLocalResult = (TextView) findViewById(R.id.local_result);
        mNumber = (TextView) findViewById(R.id.number);
        mTextTitle = (TextView) findViewById(R.id.title_text);
        mLinearLayout = (LinearLayout) findViewById(R.id.phone_info_ll);
        mTextTitle.setText(mTitleString);
        mEditText.setHint(mTitleString);
        mTextView.setOnClickListener(this);
        mImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.query_text://查询电话号码
                mPhoneNumber = mEditText.getText().toString();
                makeSureQueryWhere(mPhoneNumber);

                break;
            case R.id.call_phone://拨打号码
                mPhoneNumber = mEditText.getText().toString();
                if (Util.isNumeric(mPhoneNumber) && !TextUtils.isEmpty(mPhoneNumber)) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + mPhoneNumber));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "请输入合法手机号码", Toast.LENGTH_SHORT).show();

                }
                break;
        }

    }

    /**
     * 使用网络数据查询
     *
     * @param mPhoneNumber
     */
    private void queryFormNet(final String mPhoneNumber) {
        String netUrl = API.PHONEURL + mPhoneNumber;
        final Message message = Message.obtain();
        message.what = 1;
        RequestQueue queue = Volley.newRequestQueue(this);
        final JsonObjectRequest json = new JsonObjectRequest(netUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Gson gson = new Gson();
                PhoneInfo phoneInfo = gson.fromJson(jsonObject.toString(), PhoneInfo.class);
                if (phoneInfo.getResultcode().equals("200")) {
                    phoneResult = phoneInfo.getResult();
                    message.obj = "success";
                    mHandler.sendMessage(message);
                } else {
                    message.obj = "error";
                    mHandler.sendMessage(message);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        queue.add(json);


    }


    /**
     * 查询电话号码归属地
     *
     * @param mPhoneNumber
     */
    private void makeSureQueryWhere(final String mPhoneNumber) {
        if (Util.isWifi(PhoneActivity.this) && !Util.isMOBILE(PhoneActivity.this)) {
            queryFormNet(mPhoneNumber);
            Toast.makeText(this, "此时使用wifi,在网络数据库查询", Toast.LENGTH_SHORT).show();

        } else if (Util.isMOBILE(PhoneActivity.this)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("此时使用数据流量");
            builder.setMessage("是否进行联网查询?"); //设置内容
            builder.setIcon(R.drawable.shortcut_djreport_able);//设置图标，图片id即可

            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); //关闭dialog
                    Toast.makeText(PhoneActivity.this, "使用联网查询", Toast.LENGTH_SHORT).show();
                    queryFormNet(mPhoneNumber);

                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Toast.makeText(PhoneActivity.this, "使用本地数据库查询", Toast.LENGTH_SHORT).show();
                    queryFormDBA(mPhoneNumber);
                }
            });

            builder.show();

        } else {
            queryFormDBA(mPhoneNumber);
        }


    }

    /**
     * 使用本地数据库
     *
     * @param mPhoneNumber
     */
    private void queryFormDBA(final String mPhoneNumber) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                initAddressDB("address.db");
                AddressDao dao = new AddressDao();
                result = dao.getAddress(mPhoneNumber);
                Message message = Message.obtain();
                message.what = 0;
                message.obj = result;
                mHandler.sendMessage(message);

            }
        }).start();


    }


    /**
     * 拷贝数据库值files文件夹下
     *
     * @param dbName 数据库名称
     */
    private void initAddressDB(String dbName) {
        //1,在files文件夹下创建同名dbName数据库文件过程
        File files = getFilesDir();
        File file = new File(files, dbName);
        if (file.exists()) {
            return;
        }
        InputStream stream = null;
        FileOutputStream fos = null;
        //2,输入流读取第三方资产目录下的文件
        try {
            stream = getAssets().open(dbName);
            //3,将读取的内容写入到指定文件夹的文件中去
            fos = new FileOutputStream(file);
            //4,每次的读取内容大小
            byte[] bs = new byte[1024];
            int temp = -1;
            while ((temp = stream.read(bs)) != -1) {
                fos.write(bs, 0, temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null && fos != null) {
                try {
                    stream.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackManager.onActivityDestory(this);
    }

    public void initData() {
        mTitleString = getIntent().getStringExtra("title");
    }
}
