package com.fanhong.cn.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fanhong.cn.R;
import com.fanhong.cn.mines.LoginActivity;

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

    private final static int RESULT = 11;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = x.view().inject(this,inflater,container);
        return view;
    }
    @Event({R.id.iv_login,R.id.ll_userset,R.id.ll_mytradeno,R.id.ll_notice,R.id.ll_call,
            R.id.ll_generalset,R.id.ll_versionupgrade,R.id.ll_about})
    private void onClick(View v){
        Intent intent = null;
        switch (v.getId()){
            case R.id.iv_login://登录图标
                intent = new Intent(getActivity(),LoginActivity.class);
                startActivityForResult(intent,RESULT);
                break;
            case R.id.ll_userset://账号设置
                intent = new Intent(getActivity(),LoginActivity.class);
                startActivityForResult(intent,RESULT);
                break;
            case R.id.ll_mytradeno://我的订单
                intent = new Intent(getActivity(),LoginActivity.class);
                startActivityForResult(intent,RESULT);
                break;
            case R.id.ll_notice://消息通知
                intent = new Intent(getActivity(),LoginActivity.class);
                startActivityForResult(intent,RESULT);
                break;
            case R.id.ll_call://拨打热线
                String call = tvCall.getText().toString();
                showDialog(call);
                break;
            case R.id.ll_generalset://通用设置
                intent = new Intent(getActivity(),LoginActivity.class);
                startActivityForResult(intent,RESULT);
                break;
            case R.id.ll_versionupgrade://版本更新
                Toast.makeText(getActivity(),"暂无版本更新",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_about://关于我们
                break;
        }
    }
    private void showDialog(final String str){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("将要拨打"+str);
        builder.setMessage("是否立即拨打？");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callNumber(str);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
//        builder.setCancelable(true);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void callNumber(String num){
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + num);
        intent.setData(data);
        startActivity(intent);
    }
}
