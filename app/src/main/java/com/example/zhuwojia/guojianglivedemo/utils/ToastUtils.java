package com.example.zhuwojia.guojianglivedemo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * author：shixinxin on 13
 * version：v1.0
 */

public class ToastUtils {
    private static Toast toast = null;

    public static void showTextToast(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
