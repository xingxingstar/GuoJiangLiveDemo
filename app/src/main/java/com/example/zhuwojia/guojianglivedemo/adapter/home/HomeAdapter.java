package com.example.zhuwojia.guojianglivedemo.adapter.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.base.ListBaseAdapter;
import com.example.zhuwojia.guojianglivedemo.base.SuperViewHolder;
import com.example.zhuwojia.guojianglivedemo.bean.HomeBean;
import com.example.zhuwojia.guojianglivedemo.utils.GlideUtils;
import com.example.zhuwojia.guojianglivedemo.view.RoundedImageView;

import java.util.List;

/**
 * author：shixinxin on 2017/7/18
 * version：v1.0
 */

public class HomeAdapter extends ListBaseAdapter<HomeBean.DataBean> {
    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_home_adpter;
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        List<HomeBean.DataBean> list = getDataList();
        HomeBean.DataBean dataBean = list.get(position);
        RoundedImageView iv_pic = holder.getView(R.id.iv_pic);
        GlideUtils.downPicture(mContext, dataBean.getHeadPic(), iv_pic);

        TextView tv_hour = holder.getView(R.id.tv_hour);
        tv_hour.setText(dataBean.getPlayStartTime() + "前");

        TextView tv_online = holder.getView(R.id.tv_online);
        tv_online.setText(dataBean.getOnlineNum() + "人在看");

        ImageView iv_header = holder.getView(R.id.iv_header);
        GlideUtils.downHeaderPicture(mContext, dataBean.getHeadPic(), iv_header);

        TextView tv_nickname = holder.getView(R.id.tv_nickname);
        String nickname = dataBean.getNickname();
        tv_nickname.setText(nickname);

        TextView tv_anno = holder.getView(R.id.tv_anno);
        tv_anno.setText(dataBean.getAnnouncement());

        TextView tv_city = holder.getView(R.id.tv_city);
        tv_city.setText(dataBean.getCity());

        TextView tv_tag = holder.getView(R.id.tv_tag);
        if (dataBean.getTags() != null && dataBean.getTags().size() > 0) {
            tv_tag.setVisibility(View.VISIBLE);
            String name = dataBean.getTags().get(0).getName();
            tv_tag.setText(name);
        }

    }
}
