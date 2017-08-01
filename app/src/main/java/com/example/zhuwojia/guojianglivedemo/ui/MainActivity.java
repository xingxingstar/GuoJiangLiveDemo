package com.example.zhuwojia.guojianglivedemo.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.base.BaseActivity;
import com.example.zhuwojia.guojianglivedemo.databinding.ActivityMainBinding;
import com.example.zhuwojia.guojianglivedemo.interfaces.BottomNavigationClickListener;
import com.example.zhuwojia.guojianglivedemo.ui.camera.LiveActivity;
import com.example.zhuwojia.guojianglivedemo.ui.home.HomeFragment;
import com.example.zhuwojia.guojianglivedemo.ui.mse.MseFragment;
import com.example.zhuwojia.guojianglivedemo.ui.play.PlayFragment;
import com.example.zhuwojia.guojianglivedemo.ui.user.UserFragment;

public class MainActivity extends BaseActivity implements BottomNavigationClickListener {
    private long mLastPressBackTime = 0;
    private static final int INTERVAL_OF_TWO_CLICK_TO_QUIT = 1000; // 1 seconde
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_container, HomeFragment.newInstance()).commit();
        dataBinding.bnvBottom.setBottomNavigationClickListener(this);
        dataBinding.ivLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LiveActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                transaction.replace(R.id.ll_container, HomeFragment.newInstance());
                break;
            case 1:
                transaction.replace(R.id.ll_container, PlayFragment.newInstance());
                break;
            case 2:
                transaction.replace(R.id.ll_container, MseFragment.newInstance());
                break;
            case 3:
                transaction.replace(R.id.ll_container, new UserFragment());
                break;
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        if (System.currentTimeMillis() - mLastPressBackTime < INTERVAL_OF_TWO_CLICK_TO_QUIT) {
//            finish();
//        } else {
            Toast.makeText(this, "再次按下返回键将退出应用！", Toast.LENGTH_SHORT).show();
//
    }


}
