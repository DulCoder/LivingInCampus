package com.fafu.zhengxianyou.livingincampus.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fafu.zhengxianyou.livingincampus.constant.Constants;


/**
 * Created by zhengxianyou on 2016/11/28.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.VERSION);
    }

    /**
     * 如果数据库不存在会调用该方法
     * @param db 用于操作数据库的工具类
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE_COURSE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Constants.DROP_TABLE_COURSE);
        db.execSQL(Constants.CREATE_TABLE_COURSE);

    }
}
