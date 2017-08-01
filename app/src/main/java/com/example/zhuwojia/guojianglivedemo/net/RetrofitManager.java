package com.example.zhuwojia.guojianglivedemo.net;

import android.content.Context;

import com.example.zhuwojia.guojianglivedemo.constant.Url;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * author：shixinxin on 2017/7/18
 * version：v1.0
 */

public class RetrofitManager {
    private Retrofit mRetrofit;

    private volatile static RetrofitManager instance;

    private RetrofitManager(Context context) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Url.URL_NUMBER)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }


    public static RetrofitManager getInstance(Context context) {
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager(context);
                }
            }
        }
        return instance;
    }

    public Retrofit getRetrofit(Context context) {
        if (mRetrofit == null) {
            mRetrofit = RetrofitManager.getInstance(context).initRetrofit();
        }
        return mRetrofit;
    }

    private Retrofit initRetrofit() {
        return mRetrofit;
    }
}
