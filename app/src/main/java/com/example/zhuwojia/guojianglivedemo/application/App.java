package com.example.zhuwojia.guojianglivedemo.application;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;

import com.example.zhuwojia.guojianglivedemo.utils.ToastUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.hyphenate.chat.ChatClient;
import com.hyphenate.chat.ChatManager;
import com.hyphenate.chat.Message;
import com.hyphenate.helpdesk.callback.Callback;
import com.hyphenate.helpdesk.easeui.UIProvider;
import com.mob.MobSDK;

import java.util.List;

import cn.jpush.android.api.JPushInterface;

/**
 * author：shixinxin on 2017/6/22
 * version：v1.0
 */

public class App extends Application {
    public static int user_id = 1;
    public static String device, currentapiVersion;
    private SharedPreferences cookies_prefs;
    public static String user_name,user_password;
    Handler handler = new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(getApplicationContext(), "1ee1bfbf47500", "4a56a428e594337c04de2167d32004e3");
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        device = Build.BRAND + " " + Build.MODEL;
        currentapiVersion = Build.VERSION.RELEASE;

        cookies_prefs = getSharedPreferences("cookie",  Context.MODE_PRIVATE);
        String cookie = "uid=10055139;__DAYU_PP=uYz7YUiNfvv2AjFMZM2Fffffffff86bf6f56fb40;PHPSESSID=lmvc409vchg1cc4fqo6skmoh51";
        SharedPreferences.Editor editor = cookies_prefs.edit();
        editor.putString("cookie",cookie);
        editor.commit();

        Fresco.initialize(this);

        ChatClient.Options options = new ChatClient.Options();
        options.setAppkey("1191170727115650#kefuchannelapp45230");//必填项，appkey获取地址：kefu.easemob.com，“管理员模式 > 渠道管理 > 手机APP”页面的关联的“AppKey”
        options.setTenantId("45230");//必填项，tenantId获取地址：kefu.easemob.com，“管理员模式 > 设置 > 企业信息”页面的“租户ID”

        // Kefu SDK 初始化
        if (!ChatClient.getInstance().init(this, options)){
            return;
        }
        // Kefu EaseUI的初始化
        UIProvider.getInstance().init(this);
        //后面可以设置其他属性
        user_name = "15712883024";
        user_password = "111111";
        ChatClient.getInstance().createAccount("15712883024", "111111", new Callback(){
            @Override
            public void onSuccess() {

               handler.post(new Runnable() {
                   @Override
                   public void run() {
                       ToastUtils.showTextToast(getApplicationContext(),"登录成功");
                   }
               });
            }

            @Override
            public void onError(int i, final String s) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showTextToast(getApplicationContext(),"注册失败"+s);
                    }
                });
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });

        ChatClient.getInstance().chatManager().addMessageListener(new ChatManager.MessageListener() {
            @Override
            public void onMessage(List<Message> list) {
                //收到普通消息
                String s = list.get(0).getBody().toString();
                Intent intent = new Intent();
                intent.setAction("com.broadcast.test");
                intent.putExtra("info","客服已回复"+s);
                getApplicationContext().sendBroadcast(intent);
            }

            @Override
            public void onCmdMessage(List<Message> list) {
                //收到命令消息，命令消息不存数据库，一般用来作为系统通知，例如留言评论更新，
                //会话被客服接入，被转接，被关闭提醒
            }

            @Override
            public void onMessageStatusUpdate() {
                //消息的状态修改，一般可以用来刷新列表，显示最新的状态
            }

            @Override
            public void onMessageSent() {
                //发送消息后，会调用，可以在此刷新列表，显示最新的消息
            }
        });
    }
}
