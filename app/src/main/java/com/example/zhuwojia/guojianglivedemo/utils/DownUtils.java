package com.example.zhuwojia.guojianglivedemo.utils;

import android.content.Context;

import com.example.zhuwojia.guojianglivedemo.apiservice.GetRequest;
import com.example.zhuwojia.guojianglivedemo.apiservice.PostRequest;
import com.example.zhuwojia.guojianglivedemo.net.RetrofitManager;
import com.example.zhuwojia.guojianglivedemo.net.RetrofitManager2;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * author：shixinxin on 2017/6/19
 * version：v1.0
 */

public class DownUtils {
    public static PostRequest downPostRequest(Context context) {
        return RetrofitManager.getInstance(context).getRetrofit(context).create(PostRequest.class);
    }

    public static GetRequest downGetRequest(Context context) {
        return RetrofitManager.getInstance(context).getRetrofit(context).create(GetRequest.class);
    }
    public static PostRequest downPostRequest2(Context context) {
        return RetrofitManager2.getInstance(context).getRetrofit(context).create(PostRequest.class);
    }

    public static GetRequest downGetRequest2(Context context) {
        return RetrofitManager2.getInstance(context).getRetrofit(context).create(GetRequest.class);
    }

    public static RequestBody getRequestBody(Object s) {
        Gson gson = new Gson();
        String key = gson.toJson(s);
        Logger.e("上传的json:" + key);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), key);
        return requestBody;
    }
}
