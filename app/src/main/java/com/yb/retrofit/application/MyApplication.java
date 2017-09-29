package com.yb.retrofit.application;

import android.app.Application;

import com.yb.retrofit.config.Constants;
import com.yb.retrofit.http.YbHttp;

/**
 * Created by yangbo on 2017/5/4.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        YbHttp.init(this, Constants.URL_API_ROOT);
        YbHttp.setHttpCache(false);
    }
}
