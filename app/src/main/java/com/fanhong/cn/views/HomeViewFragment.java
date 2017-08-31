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
import com.fanhong.cn.models.BannerModel;
import com.sivin.Banner;
import com.sivin.BannerAdapter;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

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

    private BannerAdapter bannerAdapter;
    private List<BannerModel> bannerModelList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        bannerAdapter = new BannerAdapter<BannerModel>(bannerModelList) {

            @Override
            protected void bindTips(TextView tv, BannerModel bannerModel) {

            }

            @Override
            public void bindImage(ImageView imageView, BannerModel bannerModel) {
                ImageOptions options = new ImageOptions.Builder().setCrop(true).setPlaceholderScaleType(ImageView.ScaleType.FIT_XY).setUseMemCache(true).build();
                x.image().bind(imageView, bannerModel.getImageUrl(), options);
            }
        };
        banner.setBannerAdapter(bannerAdapter);
        getBannerImg();
    }
    @Event({R.id.image_choosecell,R.id.show_notice,R.id.tv_shequgonggao,
            R.id.tv_wuyezhixing,R.id.tv_zhaoshangdaili})
    private void onClick(View v){
        switch (v.getId()){
            case R.id.image_choosecell:
                break;
        }
    }
    private void getBannerImg() {
        bannerModelList.add(new BannerModel().setImageUrl("assets://images/title3.jpg"));
        bannerModelList.add(new BannerModel().setImageUrl("assets://images/banner.jpg"));
        bannerModelList.add(new BannerModel().setImageUrl("assets://images/top_banner.jpg"));
        banner.notifyDataHasChanged();
    }
}
