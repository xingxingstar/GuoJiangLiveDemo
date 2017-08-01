package com.example.zhuwojia.guojianglivedemo.net;

import android.content.Context;

import com.example.zhuwojia.guojianglivedemo.constant.Url;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * author：shixinxin on 2017/2/22
 * version：v1.0
 */

public class RetrofitManager2 {
    private Retrofit mRetrofit;

    private volatile static RetrofitManager2 instance;

    private RetrofitManager2(Context context) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new ReceivedCookiesInterceptor(context)).addInterceptor(new AddCookiesInterceptor(context)).build();
        mRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Url.URL_NUMBER)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }


    public static RetrofitManager2 getInstance(Context context) {
        if (instance == null) {
            synchronized (RetrofitManager2.class) {
                if (instance == null) {
                    instance = new RetrofitManager2(context);
                }
            }
        }
        return instance;
    }

    public Retrofit getRetrofit(Context context) {
        if (mRetrofit == null) {
            mRetrofit = RetrofitManager2.getInstance(context).initRetrofit();
        }
        return mRetrofit;
    }

    private Retrofit initRetrofit() {
        return mRetrofit;
    }
}
