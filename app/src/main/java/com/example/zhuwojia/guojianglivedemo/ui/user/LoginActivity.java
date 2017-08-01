package com.example.zhuwojia.guojianglivedemo.ui.user;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.databinding.ActivityLoginBinding;
import com.example.zhuwojia.guojianglivedemo.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

public class LoginActivity extends AppCompatActivity {

    private String userName;
    private String userIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        //用户协议的点击事件
        dataBinding.tvUserProctol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, UserProcolActivity.class);
                startActivity(intent);
            }
        });
        //QQ的点击事件
        dataBinding.bntQq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showTextToast(LoginActivity.this,"QQ已点击");
                setPlatform(QQ.NAME);

            }
        });

        //微信的点击事件
        dataBinding.bntWeixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlatform(Wechat.NAME);
            }
        });
        //微博的点击事件
        dataBinding.bntWeibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlatform(SinaWeibo.NAME);
            }
        });
        //电话的点击事件
        dataBinding.bntPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(LoginActivity.this,PhoneLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setPlatform(String platformName) {
        Platform qq = ShareSDK.getPlatform(platformName);
        qq.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                PlatformDb db = platform.getDb();
                 userName = db.getUserName();
                 userIcon = db.getUserIcon();
                Logger.e(userName + userIcon);
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                ToastUtils.showTextToast(LoginActivity.this,"授权失败"+throwable.getMessage());
            }

            @Override
            public void onCancel(Platform platform, int i) {
                ToastUtils.showTextToast(LoginActivity.this,"授权终止");
            }
        });
        if(qq.isAuthValid()){
            qq.removeAccount(true);
        }
        qq.authorize();
        qq.showUser(null);
//        if(qq.getName().equals(SinaWeibo.NAME)){
//            qq.SSOSetting(false);
//        }else{
//            qq.SSOSetting(true);
//        }
    }
}
