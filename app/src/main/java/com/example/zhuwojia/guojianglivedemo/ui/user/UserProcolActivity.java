package com.example.zhuwojia.guojianglivedemo.ui.user;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.databinding.ActivityUserProcolBinding;
import com.example.zhuwojia.guojianglivedemo.utils.ToolbarUtils;

public class UserProcolActivity extends AppCompatActivity {

    private WebView webView;
    private Toolbar toolbar;
    private TextView toolTitle;
    private RelativeLayout rlBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);

        }
        super.onCreate(savedInstanceState);
        ActivityUserProcolBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_procol);
        webView = dataBinding.webView;
        toolbar = dataBinding.includeToolbar.toolBar;
        toolTitle = dataBinding.includeToolbar.toolBarTitle;
        rlBg = dataBinding.includeToolbar.rlBg;
        ToolbarUtils.setToolBar(this,toolbar,toolTitle,rlBg,R.color.sx_orange,R.drawable.ic_action_close,"用户协议");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://m.guojiang.tv/user/protocol");
    }
}
