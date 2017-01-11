package com.fafu.zhengxianyou.livingincampus;

import android.app.Application;

import com.amap.api.location.AMapLocationClient;
import com.fafu.zhengxianyou.livingincampus.Constants.Constant;

/**
 * Created by zhengxianyou on 2017/1/8.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        AMapLocationClient.setApiKey(Constant.AMAPKEY);

    }
}
