package com.example.mytool.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mytool.uitil.StorageManager;

/**
 * Created by Amence on 2016/11/5.
 */

public class DBHelper extends SQLiteOpenHelper {
    /**
     * 获取SD卡目录
     */
    public static final String SD_PATH = StorageManager.getExternalStorageDirectory().getAbsoluteFile().getAbsolutePath();

    /**
     * 设置数据库存储位置
     */
    public static final String MY_TOOL_PATH = SD_PATH + "/mytool";

    /**
     * 当前数据库版本号
     */
    public static final int DB_VERSION_001 = 1;

    /**
     * 天气表名
     */
    public static final String TABLE_WEATHER_NAME = "weather";
    /**
     * 管理模块数据库名
     */
    public static final String MGMT_DB_NAME = "myTool";

    private Context mContext;
    private SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, MY_TOOL_PATH, null, DB_VERSION_001);
        this.mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建天气表
        createWeatherTable(db);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        this.db = sqLiteDatabase;
        switch (oldVersion) {
            case 1:
                createWeatherTable(db);
                break;

        }

    }

    /**
     * 创建天气表(直接存储json数据)
     *
     * @param db
     */
    private void createWeatherTable(SQLiteDatabase db) {
        StringBuilder appStr = new StringBuilder();
        appStr.append("create table ").append(TABLE_WEATHER_NAME).append(" ( ");
        appStr.append(WeatherColumns.ID).append(" integer primary key autoincrement,");
        appStr.append(WeatherColumns.WEATHERRESULT).append(" text);");
        db.execSQL(appStr.toString());

    }


}
