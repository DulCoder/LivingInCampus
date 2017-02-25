package com.fafu.zhengxianyou.livingincampus.app;

import android.app.Application;
import android.content.SharedPreferences;

import com.amap.api.location.AMapLocationClient;
import com.fafu.zhengxianyou.livingincampus.config.Config;
import com.fafu.zhengxianyou.livingincampus.constant.Constants;
import com.fafu.zhengxianyou.livingincampus.sqlite.DatabaseAdapter;

import cn.bmob.v3.Bmob;

/**
 * Created by zhengxianyou on 2017/1/8.
 */

public class MyApplication extends Application{
    public static SharedPreferences sp;
    public static  SharedPreferences.Editor editor;
    private DatabaseAdapter mDatabaseAdapter = new DatabaseAdapter(this);

    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, Constants.BMOB_APP_ID);
        AMapLocationClient.setApiKey(Constants.AMAPKEY);

        sp = getSharedPreferences(Constants.SP_NAME,MODE_PRIVATE);
        editor = sp.edit();


        Config.setDatabaseAdapter(mDatabaseAdapter);
    }
}
