package com.example.zhuwojia.guojianglivedemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * author：shixinxin on 2017/7/27
 * version：v1.0
 */


public class StaticReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,intent.getStringExtra("info"),Toast.LENGTH_SHORT).show();
    }
}