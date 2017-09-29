package com.yb.retrofit.utils;

/**
 * Created by yangbo on 2017/5/4.
 */

public class LogUtils {
    private static boolean isDebug = true;

    public static void s(Object o) {
        if (isDebug) {
            System.out.println("测试  ：" + o);
        }

    }


}
