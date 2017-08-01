package com.example.zhuwojia.guojianglivedemo.ui.user;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.base.BaseActivity;
import com.example.zhuwojia.guojianglivedemo.databinding.ActivityPhoneLoginBinding;
import com.example.zhuwojia.guojianglivedemo.utils.ToolbarUtils;

public class PhoneLoginActivity extends BaseActivity {
    Toolbar toolBar;
    private TextView toolBarTitle;
    private RelativeLayout rlBg;
    private View line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPhoneLoginBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_phone_login);
        toolBar = dataBinding.includeToolbar.toolBar;
        toolBarTitle = dataBinding.includeToolbar.toolBarTitle;
        rlBg = dataBinding.includeToolbar.rlBg;
        line = dataBinding.includeToolbar.line;
        toolBarTitle.setTextColor(getResources().getColor(R.color.sx_white));
        ToolbarUtils.setToolBar(this, toolBar, toolBarTitle, line, rlBg, R.color.sx_transparent, R.drawable.ic_action_back, "登录");
        dataBinding.tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneLoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
