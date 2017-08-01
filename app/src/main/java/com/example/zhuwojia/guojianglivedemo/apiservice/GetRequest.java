package com.example.zhuwojia.guojianglivedemo.apiservice;

import com.example.zhuwojia.guojianglivedemo.constant.Url;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author：shixinxin on 2017/6/19
 * version：v1.0
 */

public interface GetRequest {

    @GET(Url.SLIDE_PICTURE)
    Call<String> getSlidePicture(
            @Query("version") String version,
            @Query("platform") String platform,
            @Query("packageId") String packageId,
            @Query("channel") String channel,
            @Query("deviceName") String deviceName,
            @Query("androidVersion") String androidVersion
    );

    @GET(Url.HOT_URL)
    Call<String> getHotData(
            @Query("page") int page,
            @Query("status") String status,
            @Query("version") String version,
            @Query("platform") String platform,
            @Query("packageId") String packageId,
            @Query("channel") String channel,
            @Query("deviceName") String deviceName,
            @Query("androidVersion") String androidVersion
    );
    @GET(Url.USER_URL)
    Call<String> getUserData(
            @Query("version") String version,
            @Query("platform") String platform,
            @Query("packageId") String packageId,
            @Query("channel") String channel,
            @Query("deviceName") String deviceName,
            @Query("androidVersion") String androidVersion
    );
}
