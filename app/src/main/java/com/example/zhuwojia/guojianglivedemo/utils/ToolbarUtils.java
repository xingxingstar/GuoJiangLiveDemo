package com.example.zhuwojia.guojianglivedemo.utils;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * author：shixinxin on 2017/6/22
 * version：v1.0
 */

public class ToolbarUtils {
    public static void setToolBar(final Activity activity, Toolbar toolbar, TextView tv_title, String toolbarTitle) {
        tv_title.setText(toolbarTitle);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

    }

    public static void setToolBar(final Activity activity, Toolbar toolbar, TextView tv_title, int navigationIcon, String toolbarTitle) {
        tv_title.setText(toolbarTitle);
        toolbar.setNavigationIcon(navigationIcon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

    }

    public static void setToolBar(final Activity activity, Toolbar toolbar, TextView tv_title, RelativeLayout relativeLayout, int bgColor, int navigationIcon, String toolbarTitle) {
        tv_title.setText(toolbarTitle);
        relativeLayout.setBackgroundResource(bgColor);
        toolbar.setBackgroundResource(bgColor);
        toolbar.setNavigationIcon(navigationIcon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

    }
    public static void setToolBar(final Activity activity, Toolbar toolbar, TextView tv_title,View line, RelativeLayout relativeLayout, int bgColor, int navigationIcon, String toolbarTitle) {
        line.setVisibility(View.GONE);
        tv_title.setText(toolbarTitle);
        relativeLayout.setBackgroundResource(bgColor);
        toolbar.setBackgroundResource(bgColor);
        toolbar.setNavigationIcon(navigationIcon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

    }
    public static void setToolBar(final Activity activity, Toolbar toolbar, TextView tv_title, TextView tv_next, String toolbarTitle, String nextTitle) {
        tv_title.setText(toolbarTitle);

        tv_next.setVisibility(View.VISIBLE);
        tv_next.setText(nextTitle);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });

    }

}
