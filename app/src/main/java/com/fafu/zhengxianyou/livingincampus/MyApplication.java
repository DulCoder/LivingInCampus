package com.fafu.zhengxianyou.livingincampus;

import android.app.Application;
import android.content.SharedPreferences;

import com.amap.api.location.AMapLocationClient;
import com.fafu.zhengxianyou.livingincampus.Constants.Constant;

import cn.bmob.v3.Bmob;

/**
 * Created by zhengxianyou on 2017/1/8.
 */

public class MyApplication extends Application{
    public static SharedPreferences sp;
    public static  SharedPreferences.Editor editor;

    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, Constant.BMOB_APP_ID);
        AMapLocationClient.setApiKey(Constant.AMAPKEY);

        sp = getSharedPreferences(Constant.SP_NAME,MODE_PRIVATE);
        editor = sp.edit();

    }
}
