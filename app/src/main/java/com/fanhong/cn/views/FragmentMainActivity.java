package com.fanhong.cn.views;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.fanhong.cn.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

/**
 * Created by Administrator on 2017/8/30.
 */
@ContentView(R.layout.activity_main)
public class FragmentMainActivity extends FragmentActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}
