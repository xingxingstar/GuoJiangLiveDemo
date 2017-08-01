package com.example.zhuwojia.guojianglivedemo.adapter.comm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author：shixinxin on 2017/7/14
 * version：v1.0
 */

public class VpFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public VpFragmentAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
