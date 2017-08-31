package com.fanhong.cn.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanhong.cn.R;
import com.zhy.autolayout.AutoLinearLayout;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2017/8/30.
 */
@ContentView(R.layout.fragment_mine)
public class MineViewFragment extends Fragment {
    @ViewInject(R.id.iv_login)
    private ImageView ivLogin;
    @ViewInject(R.id.tv_login)
    private TextView tvLogin;
    @ViewInject(R.id.tv_call)
    private TextView tvCall;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);
        return view;
    }
    @Event({R.id.iv_login,R.id.tv_login,R.id.ll_userset,R.id.ll_mytradeno})
    private void onClick(View v){

    }
}
