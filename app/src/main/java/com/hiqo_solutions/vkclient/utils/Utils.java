package com.hiqo_solutions.vkclient.utils;

import android.util.Log;
import android.widget.Toast;

import com.hiqo_solutions.vkclient.App;

/**
 * Created by dmitry.zheltko on 4/6/2015.
 */
public class Utils {

    //Use only for debugging
    public static void log() {
        try {
            String message = getMessage();
            Log.d("Utils.log.debug", message);
        } catch (Exception e) {
            Log.d("Utils.log.debug", "Got exception in Utils.log()" + e.getMessage());
        }

    }

    private static String getMessage() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement stackTraceElement = stackTrace[4];
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
    }

    public static void log(String message) {
        Log.d("debug.log:" + getMessage(), message);
    }

    public static void log(Object message) {
        Log.d("Utils.log.debug", String.valueOf(message));
    }

    public static void log(Object... messages) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < messages.length; i++) {
            builder.append(String.valueOf(messages[i]));
            if (i != messages.length - 1) {
                builder.append(" / ");
            }
        }
        Utils.log(builder);
    }

    public static void toast(Object message) {
        Toast.makeText(App.getContext(), String.valueOf(message), Toast.LENGTH_LONG).show();
    }

}
