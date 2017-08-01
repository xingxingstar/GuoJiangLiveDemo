package com.example.zhuwojia.guojianglivedemo.ui.play;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhuwojia.guojianglivedemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class  PlayFragment extends Fragment {


    public static PlayFragment fragment;
    public static PlayFragment newInstance() {
        if(fragment==null) {
             fragment = new PlayFragment();
        }
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play, container, false);
    }

}
