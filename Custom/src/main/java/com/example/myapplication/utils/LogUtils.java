package com.example.myapplication.utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/12/23.
 */

public class LogUtils {
    private static boolean enableLong = true;

    public static void e(String tag, String msg) {
        if (enableLong) {
            Log.e(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (enableLong) {
            Log.w(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (enableLong) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (enableLong) {
            Log.d(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (enableLong) {
            Log.v(tag, msg);
        }
    }
}
