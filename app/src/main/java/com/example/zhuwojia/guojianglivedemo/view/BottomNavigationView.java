package com.example.zhuwojia.guojianglivedemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.interfaces.BottomNavigationClickListener;

/**
 * author：shixinxin on 2017/6/29
 * version：v1.0
 */

public class BottomNavigationView extends LinearLayout implements View.OnClickListener {
    private Drawable home_drawable, mse_drawable, camera_drawable, play_drawable, user_drawable;
    private ImageView iv_home, iv_play, iv_camera, iv_mse, iv_user, currentView;
    private BottomNavigationClickListener bottomNavigationClickListener;

    public void setBottomNavigationClickListener(BottomNavigationClickListener bottomNavigationClickListener) {
        this.bottomNavigationClickListener = bottomNavigationClickListener;
    }

    public BottomNavigationView(Context context) {
        super(context);
        init(context, null);
    }

    public BottomNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomNavigationView);
        home_drawable = typedArray.getDrawable(R.styleable.BottomNavigationView_home_drawable);
        play_drawable = typedArray.getDrawable(R.styleable.BottomNavigationView_play_drawable);
        camera_drawable = typedArray.getDrawable(R.styleable.BottomNavigationView_camera_drawable);
        mse_drawable = typedArray.getDrawable(R.styleable.BottomNavigationView_mse_drawable);
        user_drawable = typedArray.getDrawable(R.styleable.BottomNavigationView_user_drawable);
        typedArray.recycle();
        setOrientation(VERTICAL);
        View view = LayoutInflater.from(context).inflate(R.layout.bottom_view_item, null);
        iv_home = (ImageView) view.findViewById(R.id.iv_home);
        iv_play = (ImageView) view.findViewById(R.id.iv_play);
        iv_mse = (ImageView) view.findViewById(R.id.iv_mse);
        iv_user = (ImageView) view.findViewById(R.id.iv_user);
        iv_home.setOnClickListener(this);
        iv_play.setOnClickListener(this);
        iv_mse.setOnClickListener(this);
        iv_user.setOnClickListener(this);
        iv_home.setSelected(true);

        currentView = iv_home;
        addView(view);
        setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundResource(R.color.sx_white);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), (int) getResources().getDimension(R.dimen.sx_50dp));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_home:
                setPressState(iv_home, 0);
                break;
            case R.id.iv_play:
                setPressState(iv_play, 1);
                break;
            case R.id.iv_mse:
                setPressState(iv_mse, 2);
                break;
            case R.id.iv_user:
                setPressState(iv_user, 3);
                break;
        }
    }

    private void setPressState(ImageView imageView, int position) {
        currentView.setSelected(false);
        imageView.setSelected(true);
        currentView = imageView;
        bottomNavigationClickListener.onClick(position);
    }
}
