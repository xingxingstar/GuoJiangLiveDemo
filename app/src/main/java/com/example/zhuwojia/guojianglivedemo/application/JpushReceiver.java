package com.example.zhuwojia.guojianglivedemo.application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by zhuwojia on 2017/2/17.
 */



public class JpushReceiver extends BroadcastReceiver {
    private final String TAG="me";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        System.out.println("---------JpushReceiver");
        //得到注册id
        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())){
            String string = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);

        }else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())){
            //自定义消息
            System.out.println("-----自定义消息");

        }else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())){
            //接收到通知
            int anInt = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
            System.out.println("-----接收成功");

        }else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())){
            //点开通知
            System.out.println("-----点开通知");
//            Intent intent1=new Intent(context, MsgCenterActivity.class);
//            String string = bundle.toString();

//            Logger.e(string+"你好");


//            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(intent1);
        }

    }

}

