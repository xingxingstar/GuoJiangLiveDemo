package com.example.zhuwojia.guojianglivedemo.ui.home.child;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.adapter.home.HomeAdapter;
import com.example.zhuwojia.guojianglivedemo.apiservice.GetRequest;
import com.example.zhuwojia.guojianglivedemo.application.App;
import com.example.zhuwojia.guojianglivedemo.base.BaseFragment;
import com.example.zhuwojia.guojianglivedemo.bean.HomeBanner;
import com.example.zhuwojia.guojianglivedemo.bean.HomeBean;
import com.example.zhuwojia.guojianglivedemo.bean.UseBean;
import com.example.zhuwojia.guojianglivedemo.constant.Constant;
import com.example.zhuwojia.guojianglivedemo.databinding.FragmentHomeChildBinding;
import com.example.zhuwojia.guojianglivedemo.net.RetrofitManager;
import com.example.zhuwojia.guojianglivedemo.ui.VideoPlayActivity;
import com.example.zhuwojia.guojianglivedemo.utils.DownUtils;
import com.example.zhuwojia.guojianglivedemo.utils.GlideImageLoader;
import com.example.zhuwojia.guojianglivedemo.utils.ToastUtils;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeChildFragment extends BaseFragment<FragmentHomeChildBinding> {
    private static int tag;
    private Context context;
    private LRecyclerViewAdapter adapter;
    private int page = 0;
    private HomeAdapter homeAdapter;
    private int[] indicator = {R.drawable.icon_selected, R.drawable.icon_unselected};
    private  List<HomeBean.DataBean> data;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public int getInflaterId() {
        return R.layout.fragment_home_child;
    }

    @Override
    public void initView() {
        bindingView.recyHome.setLayoutManager(new LinearLayoutManager(context));
        homeAdapter = new HomeAdapter(context);
        adapter = new LRecyclerViewAdapter(homeAdapter);
        bindingView.recyHome.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String url = data.get(position).getVideoPlayUrl();
                VideoPlayActivity.startVideoPlayActivity(context,url);
            }
        });
    }

    @Override
    public void loadData() {
        tag = getArguments().getInt("tag");
        if (tag == 1) {
            downUserInfo();
            downBannerData();
            downHotData();
        }
    }

    private void downUserInfo() {
        Call<String> call = DownUtils.downGetRequest2(context).getUserData(Constant.VERSION, Constant.PLATFORM, Constant.packageId, Constant.CHANNEL, App.device, App.currentapiVersion);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String json = response.body();
                Logger.e("user json"+json);
                UseBean bean = new Gson().fromJson(json, UseBean.class);
                String id = bean.getData().getId();
                SharedPreferences cookies_prefs = context.getSharedPreferences("cookie",  Context.MODE_PRIVATE);
                String cookie = "uid="+id+";__DAYU_PP=uYz7YUiNfvv2AjFMZM2Fffffffff86bf6f56fb40;PHPSESSID=lmvc409vchg1cc4fqo6skmoh51";
                SharedPreferences.Editor editor = cookies_prefs.edit();
                editor.putString("cookie",cookie);
                editor.commit();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }


    /**
     * 下载轮播图数据
     */
    private void downBannerData() {
        Call<String> call = RetrofitManager.getInstance(context).getRetrofit(context).create(GetRequest.class).getSlidePicture("3.1.5", "android", "0", "and-wandoujia-0", App.device, App.currentapiVersion);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                showSuccessView();
                String json = response.body();
                Logger.e(json);
                HomeBanner banner = new Gson().fromJson(json, HomeBanner.class);
                View view = LayoutInflater.from(context).inflate(R.layout.header_home_child, null);
                List<String> picLists = new ArrayList<String>();
                for (int i = 0; i < banner.getData().size(); i++) {
                    String pic = banner.getData().get(i).getPic();
                    picLists.add(pic);
                }
                Banner cb_pic = (Banner) view.findViewById(R.id.cb_pic);
                cb_pic.isAutoPlay(true);
                cb_pic.setDelayTime(2000);
                cb_pic.setImages(picLists).setImageLoader(new GlideImageLoader()).start();
                adapter.addHeaderView(view);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                showFail();
                Logger.e("错误日志：" + t.getMessage());
                ToastUtils.showTextToast(context, "数据加载错误" + t.getMessage());
            }
        });
    }

    /**
     * 下载热门数据
     */
    private void downHotData() {
        Call<String> call = DownUtils.downGetRequest2(context).getHotData(page, "1", "3.1.5", "android", "0", "and-wandoujia-0", App.device, App.currentapiVersion);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                showSuccessView();
                String json = response.body();
                data = new Gson().fromJson(json, HomeBean.class).getData();
                homeAdapter.setDataList(data);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                showFail();
            }
        });
    }
}
