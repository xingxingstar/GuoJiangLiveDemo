package com.example.zhuwojia.guojianglivedemo.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.baidu.cloud.media.player.IMediaPlayer;
import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.base.BaseActivity;
import com.example.zhuwojia.guojianglivedemo.databinding.ActivityVideoPlayBinding;
import com.example.zhuwojia.guojianglivedemo.live.info.SharedPrefsStore;
import com.example.zhuwojia.guojianglivedemo.live.widget.BDCloudVideoView;
import com.orhanobut.logger.Logger;

public class VideoPlayActivity extends BaseActivity implements IMediaPlayer.OnPreparedListener,
        IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener,
        IMediaPlayer.OnInfoListener, IMediaPlayer.OnBufferingUpdateListener,
        BDCloudVideoView.OnPlayerStateListener {

    private ActivityVideoPlayBinding bindData;
    private static String palyUrl;
    private BDCloudVideoView mVV;
//    private SimpleMediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BDCloudVideoView.setAK("cb08a09fade84802a9d54fd34ccb6243");
        bindData = DataBindingUtil.setContentView(this, R.layout.activity_video_play);
//        mediaController = bindData.svController;
        mVV = new BDCloudVideoView(this);
        mVV.setVideoPath(palyUrl);
        Logger.e(palyUrl);
        if (SharedPrefsStore.isPlayerFitModeCrapping(getApplicationContext())) {
            mVV.setVideoScalingMode(BDCloudVideoView.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING);
        } else {
            mVV.setVideoScalingMode(BDCloudVideoView.VIDEO_SCALING_MODE_SCALE_TO_FIT);
        }
        RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(-1, -1);
        rllp.addRule(RelativeLayout.CENTER_IN_PARENT);
        bindData.rlContainer.addView(mVV);
        mVV.setOnPreparedListener(this);
        mVV.setOnCompletionListener(this);
        mVV.setOnErrorListener(this);
        mVV.setOnInfoListener(this);
        mVV.setOnBufferingUpdateListener(this);
        mVV.setOnPlayerStateListener(this);

//        bindData.svController.setMediaPlayerControl(mVV);

        mVV.start();
    }


    public static void startVideoPlayActivity(Context context, String url) {
        Intent intent = new Intent(context, VideoPlayActivity.class);
        context.startActivity(intent);
        palyUrl = url;

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (mVV != null) {
            mVV.enterForeground();
        }
    }

    @Override
    protected void onStop() {
        if (mVV != null) {
            mVV.enterBackground();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVV != null) {
            mVV.stopPlayback();
        }
    }

    @Override
    public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
//        if (mediaController != null && mVV != null) {
//            mediaController.onTotalCacheUpdate(percent * mVV.getDuration() / 100);
//        }
    }

    @Override
    public void onCompletion(IMediaPlayer iMediaPlayer) {

    }

    @Override
    public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(IMediaPlayer iMediaPlayer) {

    }

    @Override
    public void onPlayerStateChanged(BDCloudVideoView.PlayerState nowState) {
//        if (mediaController != null) {
//            mediaController.changeState();
//        }
    }
}
