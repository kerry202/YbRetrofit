package com.yb.retrofit.listener;


import com.yb.retrofit.http.L;



/**
 * User:yangbo(903023560@qq.com)
 * Date:2017-05-02
 */

public abstract class UploadListener {

    public abstract void onResponse(okhttp3.Call call, okhttp3.Response response);

    public abstract void onProgress(long progress, long total, boolean done);

    public void onFailure(okhttp3.Call call, Throwable t) {
        L.e(t);
    }

}
