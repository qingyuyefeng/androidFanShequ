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
import com.sivin.Banner;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2017/8/30.
 */
@ContentView(R.layout.fragment_home)
public class HomeViewFragment extends Fragment {
    @ViewInject(R.id.image_choosecell)
    private ImageView chooseCell;
    @ViewInject(R.id.show_cellname)
    private TextView showCellName;
    @ViewInject(R.id.show_notice)
    private TextView moreNotice;
    @ViewInject(R.id.home_banner)
    private Banner banner;
    @ViewInject(R.id.tv_shequgonggao)
    private TextView cellNotice;
    @ViewInject(R.id.tv_wuyezhixing)
    private TextView wuyeStar;
    @ViewInject(R.id.tv_zhaoshangdaili)
    private TextView investment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
    @Event({R.id.image_choosecell,R.id.show_notice,R.id.tv_shequgonggao,
            R.id.tv_wuyezhixing,R.id.tv_zhaoshangdaili})
    private void onClick(View v){
        switch (v.getId()){
            case R.id.image_choosecell:
                break;
        }
    }
}
