package com.example.zhuwojia.guojianglivedemo.ui.user;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.zhuwojia.guojianglivedemo.R;
import com.example.zhuwojia.guojianglivedemo.application.App;
import com.example.zhuwojia.guojianglivedemo.base.BaseFragment;
import com.example.zhuwojia.guojianglivedemo.databinding.FragmentUserBinding;
import com.hyphenate.chat.ChatClient;
import com.hyphenate.chat.ChatManager;
import com.hyphenate.chat.Message;
import com.hyphenate.helpdesk.callback.Callback;
import com.hyphenate.helpdesk.easeui.util.IntentBuilder;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends BaseFragment<FragmentUserBinding> {


    @Override
    public int getInflaterId() {
        return R.layout.fragment_user;
    }

    @Override
    public void initView() {
        bindingView.bntKefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatClient.getInstance().login(App.user_name, App.user_password, new Callback() {
                    @Override
                    public void onSuccess() {
                        Intent intent = new IntentBuilder(getActivity())
                                .setServiceIMNumber("kefuchannelimid_479715")
                                .build();
                        startActivity(intent);
                    }

                    @Override
                    public void onError(int i, String s) {

                    }

                    @Override
                    public void onProgress(int i, String s) {

                    }
                });
            }
        });

    }

    @Override
    public void loadData() {
        showSuccessView();

    }

}
