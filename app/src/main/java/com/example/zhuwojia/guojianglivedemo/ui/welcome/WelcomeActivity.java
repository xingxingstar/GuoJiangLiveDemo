package com.example.zhuwojia.guojianglivedemo.ui.welcome;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.ui.user.LoginActivity;
import com.example.zhuwojia.guojianglivedemo.ui.MainActivity;
import com.example.zhuwojia.guojianglivedemo.application.App;
import com.example.zhuwojia.guojianglivedemo.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        ActivityWelcomeBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
        dataBinding.ivShow.setImageResource(R.mipmap.welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              if(App.user_id==-1){
                  Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                  startActivity(intent);
              }else{
                  Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                  startActivity(intent);
              }
                finish();
            }
        }, 2000);
    }



}
