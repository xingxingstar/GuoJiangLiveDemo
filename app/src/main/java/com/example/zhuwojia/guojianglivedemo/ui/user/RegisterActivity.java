package com.example.zhuwojia.guojianglivedemo.ui.user;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.base.BaseActivity;
import com.example.zhuwojia.guojianglivedemo.databinding.ActivityRegisterBinding;
import com.example.zhuwojia.guojianglivedemo.utils.ToastUtils;
import com.example.zhuwojia.guojianglivedemo.utils.ToolbarUtils;

import org.json.JSONObject;

import java.util.ArrayList;

import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

public class RegisterActivity extends BaseActivity {

    private EditText etPhone, etCode;
    private Button bntCode;
    private Toolbar toolBar;
    private TextView toolBarTitle;
    private RelativeLayout rlBg;
    private View line;
    private EventHandler eventHandler;
    private OnSendMessageHandler osmHandler;
    private static final int CODE_ING = 1;   //已发送，倒计时
    private static final int CODE_REPEAT = 2;  //重新发送
    private static final int SMSDDK_HANDLER = 3;  //短信回调
    private int TIME = 60;//倒计时60s

    private String phone;

    public void setOnSendMessageHandler(OnSendMessageHandler h) {
        osmHandler = h;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        etPhone = dataBinding.etPhone;
        etCode = dataBinding.etCode;
        bntCode = dataBinding.bntCode;
        toolBar = dataBinding.includeToolbar.toolBar;
        toolBarTitle = dataBinding.includeToolbar.toolBarTitle;
        rlBg = dataBinding.includeToolbar.rlBg;
        line = dataBinding.includeToolbar.line;
        ToolbarUtils.setToolBar(this, toolBar, toolBarTitle, line, rlBg, R.color.sx_transparent, R.drawable.ic_action_back, "注册");
        if (Build.VERSION.SDK_INT >= 23) {
            int readPhone = checkSelfPermission(Manifest.permission.READ_PHONE_STATE);
            int receiveSms = checkSelfPermission(Manifest.permission.RECEIVE_SMS);
            int readSms = checkSelfPermission(Manifest.permission.READ_SMS);
            int readContacts = checkSelfPermission(Manifest.permission.READ_CONTACTS);
            int readSdcard = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);

            int requestCode = 0;
            ArrayList<String> permissions = new ArrayList<String>();
            if (readPhone != PackageManager.PERMISSION_GRANTED) {
                requestCode |= 1 << 0;
                permissions.add(Manifest.permission.READ_PHONE_STATE);
            }
            if (receiveSms != PackageManager.PERMISSION_GRANTED) {
                requestCode |= 1 << 1;
                permissions.add(Manifest.permission.RECEIVE_SMS);
            }
            if (readSms != PackageManager.PERMISSION_GRANTED) {
                requestCode |= 1 << 2;
                permissions.add(Manifest.permission.READ_SMS);
            }
            if (readContacts != PackageManager.PERMISSION_GRANTED) {
                requestCode |= 1 << 3;
                permissions.add(Manifest.permission.READ_CONTACTS);
            }
            if (readSdcard != PackageManager.PERMISSION_GRANTED) {
                requestCode |= 1 << 4;
                permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }
            if (requestCode > 0) {
                String[] permission = new String[permissions.size()];
                this.requestPermissions(permissions.toArray(permission), requestCode);
                return;
            }
        }

        bntCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 phone = etPhone.getText().toString();
                if (etPhone != null && !phone.isEmpty()) {

                new AlertDialog.Builder(RegisterActivity.this)
                        .setTitle("发送短信")
                        .setMessage("我们将把验证码发送到以下号码:\n"+"+86:"+phone)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                SMSSDK.getVerificationCode("86", phone.trim(), osmHandler);
                                new Thread(new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        for (int i = 60; i > 0; i--)
                                        {
                                            handler.sendEmptyMessage(CODE_ING);
                                            if (i <= 0)
                                            {
                                                break;
                                            }
                                            try
                                            {
                                                Thread.sleep(1000);
                                            } catch (InterruptedException e)
                                            {
                                                e.printStackTrace();
                                            }
                                        }
                                        handler.sendEmptyMessage(CODE_REPEAT);
                                    }
                                }).start();
                                bntCode.setClickable(false);

                            }
                        })
                        .create()
                        .show();
                }else{
                    ToastUtils.showTextToast(RegisterActivity.this,"请输入您的手机号码");
                }
            }
        });
        dataBinding.bntNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = etCode.getText().toString();
                SMSSDK.submitVerificationCode("86", phone,code);//对验证码进行验证->回调函数
            }
        });
        initSDK();
    }

    private void initSDK()
    {
        eventHandler = new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                msg.what = SMSDDK_HANDLER;
                handler.sendMessage(msg);
            }
        };
        // 注册回调监听接口
        SMSSDK.registerEventHandler(eventHandler);
    }


    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }





    Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case CODE_ING://已发送,倒计时
                    bntCode.setText("重新发送("+--TIME+"s)");
                    break;
                case CODE_REPEAT://重新发送
                    bntCode.setText("获取验证码");
                    bntCode.setClickable(true);
                    break;
                case SMSDDK_HANDLER:
                    int event = msg.arg1;
                    int result = msg.arg2;
                    Object data = msg.obj;
                    //回调完成
                    if (result == SMSSDK.RESULT_COMPLETE)
                    {
                        //验证码验证成功
                        if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE)
                        {
                            Toast.makeText(RegisterActivity.this, "验证成功", Toast.LENGTH_LONG).show();
                        }
                        //已发送验证码
                        else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE)
                        {
                            Toast.makeText(getApplicationContext(), "验证码已经发送",
                                    Toast.LENGTH_SHORT).show();
                        } else
                        {
                            ((Throwable) data).printStackTrace();
                        }
                    }
                    if(result==SMSSDK.RESULT_ERROR)
                    {
                        try {
                            Throwable throwable = (Throwable) data;
                            throwable.printStackTrace();
                            JSONObject object = new JSONObject(throwable.getMessage());
                            String des = object.optString("detail");//错误描述
                            int status = object.optInt("status");//错误代码
                            if (status > 0 && !TextUtils.isEmpty(des)) {
                                Toast.makeText(getApplicationContext(), des, Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (Exception e) {
                            //do something
                        }
                    }
                    break;

            }
        }
    };
}