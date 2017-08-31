package com.fanhong.cn.views;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanhong.cn.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * Created by Administrator on 2017/8/31.
 */
@ContentView(R.layout.fragment_enguard)
public class EnguardViewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);
        return view;
    }
}
