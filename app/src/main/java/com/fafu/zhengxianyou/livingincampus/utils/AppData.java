package com.fafu.zhengxianyou.livingincampus.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.fafu.zhengxianyou.livingincampus.constant.Constants;

/**
 * Created by zhengxianyou on 2017/2/21.
 */

public class AppData {
    /**
     * 保存是否第一次进入应用的状态值
     */
    public static void saveState(Context context, boolean isFirstOpen) {
        SharedPreferences share = context.getSharedPreferences(Constants.APP_DATA, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        editor.putBoolean(Constants.FIRST_INSTALL, isFirstOpen);
        editor.commit();
    }

    /**
     * 获取是否第一次进入应用的状态值
     */
    public static boolean getState(Context context) {
        SharedPreferences share = context.getSharedPreferences(Constants.APP_DATA, context.MODE_PRIVATE);
        return share.getBoolean(Constants.FIRST_INSTALL, true);
    }

    /**
     * 保存入学时间
     */
    public static void saveTime(Context context, String time) {
        SharedPreferences share = context.getSharedPreferences(Constants.APP_DATA, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        editor.putString(Constants.TIME_OF_ENROLLMENT, time);
        editor.commit();
    }

    /**
     * 获取入学时间
     */
    public static String getTime(Context context) {
        SharedPreferences share = context.getSharedPreferences(Constants.APP_DATA, context.MODE_PRIVATE);
        return share.getString(Constants.TIME_OF_ENROLLMENT, null);
    }
}
