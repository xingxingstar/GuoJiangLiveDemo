package com.example.zhuwojia.guojianglivedemo.ui.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.adapter.comm.VpFragmentAdapter;
import com.example.zhuwojia.guojianglivedemo.base.BaseFragmentNoLoadding;
import com.example.zhuwojia.guojianglivedemo.ui.home.child.HomeChildFragment;
import com.example.zhuwojia.guojianglivedemo.view.TopNavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragmentNoLoadding {

    public static HomeFragment fragment;
    public ViewPager vp_home_container;
    public TopNavigationView tnv_title;

    public static HomeFragment newInstance() {

        if (fragment == null) {
            fragment = new HomeFragment();
        }
        return fragment;
    }

    @Override
    public int getInflaterId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View contentView) {
        vp_home_container = (ViewPager) contentView.findViewById(R.id.vp_home_container);
        tnv_title = (TopNavigationView) contentView.findViewById(R.id.tnv_title);
        vp_home_container.setAdapter(new VpFragmentAdapter(getChildFragmentManager(), getFragment()));
        vp_home_container.setCurrentItem(1);
        vp_home_container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tnv_title.setCurrentPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tnv_title.setTopNaviagtionClickListener(new TopNavigationView.TopNaviagtionClickListener() {
            @Override
            public void onClick(int position) {
                vp_home_container.setCurrentItem(position);
            }
        });
    }

    @Override
    public void loadData() {

    }



    public List<Fragment> getFragment() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            HomeChildFragment fragment = new HomeChildFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("tag",i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        return fragments;
    }

}
