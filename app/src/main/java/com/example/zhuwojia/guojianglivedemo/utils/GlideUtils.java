package com.example.zhuwojia.guojianglivedemo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.zhuwojia.guojianglivedemo.R;

/**
 * author：shixinxin on 2017/6/19
 * version：v1.0
 */

public class GlideUtils {
    public static void downPicture(Context context, String picUrl, ImageView imageView){
        Glide.with(context).load(picUrl).into(imageView);
    }
    public static void downHeaderPicture(final Context context, String picName, ImageView view){
        Glide.with(context).load(picName).centerCrop().placeholder(R.mipmap.image_not_exist)
                .transform(new GlideCircleTransform(context,2,context.getResources().getColor(R.color.white)))
                .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(view);
    }

}
