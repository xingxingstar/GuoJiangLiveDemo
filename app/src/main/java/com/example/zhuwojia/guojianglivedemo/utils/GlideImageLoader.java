package com.example.zhuwojia.guojianglivedemo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhuwojia.guojianglivedemo.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by jingbin on 2016/11/30.
 * 首页轮播图
 */

public class GlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(path)
                .error(R.mipmap.image_not_exist)
                .crossFade(1500)
                .into(imageView);
    }
}
