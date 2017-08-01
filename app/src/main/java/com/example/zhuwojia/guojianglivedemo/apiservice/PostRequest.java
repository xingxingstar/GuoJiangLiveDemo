package com.example.zhuwojia.guojianglivedemo.apiservice;

import com.example.zhuwojia.guojianglivedemo.constant.Url;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * author：shixinxin on 2017/6/19
 * version：v1.0
 */

public interface PostRequest {

    //欢迎界面
    @POST(Url.DOWN_UPDATE)
    Call<String> getWelcome(@Body RequestBody body);


    @POST(Url.SLIDE_PICTURE)
    Call<String> getSlidePicture(@Body RequestBody body);

    @POST(Url.HOT_URL)
    Call<String> getHotData(@Body RequestBody body);
}
