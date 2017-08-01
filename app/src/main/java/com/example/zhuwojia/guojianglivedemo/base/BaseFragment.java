package com.example.zhuwojia.guojianglivedemo.base;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhuwojia.guojianglivedemo.R;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import static android.view.View.GONE;

/**
 * author：shixinxin on 2017/7/12
 * version：v1.0
 */

public abstract class BaseFragment<SV extends ViewDataBinding> extends Fragment {
    protected SV bindingView;
    private RelativeLayout rl_fail, rl_loadding;
    private ImageView iv_load;
    private ObjectAnimator animator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ll = inflater.inflate(R.layout.fragment_base, null);
        bindingView = DataBindingUtil.inflate(getActivity().getLayoutInflater(), getInflaterId(), null, false);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        bindingView.getRoot().setLayoutParams(params);
        FrameLayout fl_container = (FrameLayout) ll.findViewById(R.id.fl_container);
        rl_fail = (RelativeLayout) ll.findViewById(R.id.rl_fail);
        rl_loadding = (RelativeLayout) ll.findViewById(R.id.rl_loadding);
        iv_load = (ImageView) ll.findViewById(R.id.iv_load);
        TextView tv_fail = (TextView) ll.findViewById(R.id.tv_fail);
        tv_fail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoadding();
                loadData();
            }
        });
        fl_container.addView(bindingView.getRoot());
        bindingView.getRoot().setVisibility(GONE);
        initView();
        showLoadding();
        return ll;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    protected void showLoadding() {
        if (animator == null) {
            animator = ObjectAnimator.ofFloat(iv_load, "rotation", 0f, 360f);
            animator.setDuration(1500);
            animator.setRepeatCount(-1);
            animator.setRepeatMode(ValueAnimator.RESTART);
        }
        animator.start();
        if (bindingView.getRoot().getVisibility() == View.VISIBLE) {
            bindingView.getRoot().setVisibility(View.GONE);
        }
        if (rl_loadding.getVisibility() == GONE) {
            rl_loadding.setVisibility(View.VISIBLE);
        }
    }

    protected void showSuccessView() {
        if (animator != null && animator.isRunning()) {
            animator.cancel();
        }
        if (bindingView.getRoot().getVisibility() == GONE) {
            bindingView.getRoot().setVisibility(View.VISIBLE);
        }
        if (rl_loadding.getVisibility() == View.VISIBLE) {
            rl_loadding.setVisibility(GONE);
        }
        if (rl_fail.getVisibility() == View.VISIBLE) {
            rl_fail.setVisibility(GONE);
        }
    }

    protected void showFail() {
        if (animator != null && animator.isRunning()) {
            animator.cancel();
        }
        if (bindingView.getRoot().getVisibility() == View.VISIBLE) {
            bindingView.getRoot().setVisibility(GONE);
        }
        if (rl_loadding.getVisibility() == View.VISIBLE) {
            rl_loadding.setVisibility(GONE);
        }
        if (rl_fail.getVisibility() == GONE) {
            rl_fail.setVisibility(View.VISIBLE);
        }
    }

    public abstract int getInflaterId();
    public abstract void initView();
    public abstract void loadData();


    public RequestBody getRequestBody(Object object){
        String json = new Gson().toJson(object);
        Logger.e("上传json:"+json);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        return requestBody;
    }
}
