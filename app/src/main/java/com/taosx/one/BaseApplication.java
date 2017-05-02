package com.taosx.one;

import android.app.Application;
import android.content.Context;

/**
 * Created by TAO_SX on 2017/4/25/025.
 */

public class BaseApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getBaseContext();
    }

    public static Context getContext(){
        return context;
    }


}
