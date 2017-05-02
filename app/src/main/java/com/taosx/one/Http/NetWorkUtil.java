package com.taosx.one.Http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.taosx.one.BaseApplication;

/**
 * Created by zhong on 2016/4/19.
 * 网络相关的工具类
 */
public class NetWorkUtil {
    private static ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) BaseApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public static boolean isConnect() {
        if (getConnectivityManager() == null) {
            return false;
        } else {
            NetworkInfo info = getConnectivityManager().getActiveNetworkInfo();
            return null != info && info.isConnected() && info.getState() == NetworkInfo.State.CONNECTED;
        }
    }


}
