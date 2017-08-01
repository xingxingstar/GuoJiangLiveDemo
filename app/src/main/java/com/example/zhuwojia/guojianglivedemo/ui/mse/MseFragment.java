package com.example.zhuwojia.guojianglivedemo.ui.mse;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhuwojia.guojianglivedemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MseFragment extends Fragment {

    public static MseFragment fragment;
    public static MseFragment newInstance() {
        if(fragment==null) {
             fragment = new MseFragment();
        }
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mse, container, false);
    }

}
