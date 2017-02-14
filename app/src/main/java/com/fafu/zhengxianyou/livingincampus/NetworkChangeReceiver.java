package com.fafu.zhengxianyou.livingincampus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.fafu.zhengxianyou.livingincampus.config.Config;

/**
 * Created by zhengxianyou on 2017/1/22.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NetworkInfo.State wifiState;
        NetworkInfo.State mobileState;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        wifiState = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        mobileState = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        if (wifiState != null && mobileState != null
                && NetworkInfo.State.CONNECTED != wifiState
                && NetworkInfo.State.CONNECTED == mobileState) {
            // 手机网络连接成功
        } else if (wifiState != null && mobileState != null
                && NetworkInfo.State.CONNECTED != wifiState
                && NetworkInfo.State.CONNECTED != mobileState) {
            // 手机没有任何的网络
            Config.setIsConnectNet(false);

        } else if (wifiState != null && NetworkInfo.State.CONNECTED == wifiState) {
            // 无线网络连接成功
        }
    }
}
