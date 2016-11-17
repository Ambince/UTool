package com.example.mytool.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Amence on 2016/11/5.
 */

public class DatabaseUtil {

    private static DatabaseUtil databaseUtil;
    private SQLiteDatabase db;
    private static DBHelper dbHelper;
    /**
     * 设置数据库存储位置
     */
    public static final String MY_TOOL_PATH = "/mytool";
    //数据库名字
    public static final String DB_NAME = "mytool";
    private static Context mContext;

    /**
     * 创建数据库
     *
     * @param context
     */
    private DatabaseUtil(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }


    /**
     * 获取数据库工具类
     *
     * @param context
     * @return
     */
    public synchronized static DatabaseUtil getInstance(Context context) {
        if (databaseUtil == null) {
            databaseUtil = new DatabaseUtil(context);
            mContext = context;
        }
        return databaseUtil;

    }


    /**
     * 检查某列表是否存在
     *
     * @param db
     * @param tableName
     * @param columnName
     * @return
     */
    private static boolean checkColumnExist(SQLiteDatabase db, String tableName, String columnName) {
        boolean result = false;
        Cursor cursor = null;
        //查询一行
        try {
            cursor = db.rawQuery("SELECT *FROM" + tableName + "LIMIT 1", null);
            result = cursor != null && cursor.getColumnIndex(columnName) != -1;

        } catch (Exception igored) {

        } finally {
            if (null != cursor && cursor.isClosed()) {
                cursor.close();

            }
        }
        return result;

    }

    /**
     * 插入天气json
     *
     * @param weather
     * @return
     */
    public static boolean updateWeather(String weather) {
        Log.v("Amence", "updateWeather");

        if (weather == null) {
            return false;
        }
        //插入sql
        String sql = "UPDATE weather SET weatherresult = '" + weather + "' WHERE id = '1' ";
        //获取数据库操作对象
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.v("Amence", "执行更新语句语句");
        db.execSQL(sql);

        return true;

    }

    public static String checkWeather() {
        Log.v("Amence", "checkWeather");
        //查询数据
        String weatherInfo = null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_WEATHER_NAME, null, null, null, null, null, null);
        if (cursor != null) {
            for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                weatherInfo = cursor.getString(cursor.getColumnIndexOrThrow(WeatherColumns.WEATHERRESULT));
            }
        } else {
            return null;
        }
        return weatherInfo;

    }

}
