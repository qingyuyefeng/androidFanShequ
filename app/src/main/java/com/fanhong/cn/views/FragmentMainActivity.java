package com.fanhong.cn.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.fanhong.cn.R;
import com.fanhong.cn.myviews.FixedViewPager;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import io.rong.imlib.RongIMClient;


/**
 * Created by Administrator on 2017/8/30.
 */
@ContentView(R.layout.activity_main)
public class FragmentMainActivity extends FragmentActivity {
    @ViewInject(R.id.viewPager)
    private FixedViewPager viewPager;
    @ViewInject(R.id.home_page)
    private RadioButton rbHome;

    private RadioButton[] radioButtons = new RadioButton[5];
    private ImageView[] imageViews = new ImageView[5];
    private Fragment[] fragments;
    private int lastCheced = R.id.home_page;//记录前一个页面以方便跳回

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initViews();
    }

    private void initViews() {
        radioButtons[0] = (RadioButton) findViewById(R.id.home_page);
        radioButtons[1] = (RadioButton) findViewById(R.id.service_page);
        radioButtons[2] = (RadioButton) findViewById(R.id.door_page);
        radioButtons[3] = (RadioButton) findViewById(R.id.interact_page);
        radioButtons[4] = (RadioButton) findViewById(R.id.mine_page);
        imageViews[0] = (ImageView) findViewById(R.id.click_home);
        imageViews[1] = (ImageView) findViewById(R.id.click_serve);
        imageViews[2] = (ImageView) findViewById(R.id.click_entrance);
        imageViews[3] = (ImageView) findViewById(R.id.click_interaction);
        imageViews[4] = (ImageView) findViewById(R.id.click_user);

        MFragmentPagerAdapter pagerAdapter = new MFragmentPagerAdapter(getSupportFragmentManager(), getFragments());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(4);//设置向左和向右都缓存limit个页面
        rbHome.setChecked(true);
    }

    private Fragment[] getFragments() {
        fragments = new Fragment[5];
        fragments[0] = new HomeViewFragment();
        fragments[1] = new MineViewFragment();
        fragments[2] = new MineViewFragment();
        fragments[3] = new MineViewFragment();
        fragments[4] = new MineViewFragment();
        return fragments;
    }

    @Event(value = R.id.bottom_radiogroup, type = RadioGroup.OnCheckedChangeListener.class)
    private void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.home_page:
                setPage(0);
                lastCheced = R.id.home_page;
                break;
            case R.id.service_page:
                setPage(1);
                lastCheced = R.id.service_page;
                break;
            case R.id.door_page:
                setPage(2);
                lastCheced = R.id.door_page;
                break;
            case R.id.interact_page:
                setPage(3);
                lastCheced = R.id.interact_page;
                break;
            case R.id.mine_page:
                setPage(4);
                lastCheced = R.id.mine_page;
                break;
        }
    }

    private void setPage(int x) {
        viewPager.setCurrentItem(x);
        for (int i = 0; i < 5; i++) {
            if (i == x) {
                radioButtons[i].setTextColor(getResources().getColor(R.color.skyblue));
                imageViews[i].setVisibility(View.VISIBLE);
            } else {
                radioButtons[i].setTextColor(getResources().getColor(R.color.notchecked));
                imageViews[i].setVisibility(View.INVISIBLE);
            }
        }
    }


    private long lastPressBackKeyTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastPressBackKeyTime < 2000) {
                RongIMClient.getInstance().disconnect();
                finish();
            } else {
                Toast.makeText(this, R.string.exit_app_tip, Toast.LENGTH_LONG).show();
                lastPressBackKeyTime = currentTime;
            }
            return true;

        }
        return super.onKeyDown(keyCode, event);
    }

    private void createDialog(int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (i) {
            case 0:
                builder.setTitle("你还没有登录哦");
                builder.setMessage("是否立即登录？");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(FragmentMainActivity.this, LoginActivity.class);
//                        startActivity(intent);
                    }
                });
                break;
            case 1:
                builder.setTitle("你还没选择小区");
                builder.setMessage("是否立即去选择小区？");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(FragmentMainActivity.this, GardenSelecterActivity.class);
//                        startActivityForResult(intent, 12);
                    }
                });
                break;
        }
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
