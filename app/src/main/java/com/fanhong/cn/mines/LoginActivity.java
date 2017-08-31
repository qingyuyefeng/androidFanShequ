package com.fanhong.cn.mines;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanhong.cn.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2017/8/31.
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends Activity{
    @ViewInject(R.id.tv_title)
    private TextView title;
    @ViewInject(R.id.username)
    private EditText userName;
    @ViewInject(R.id.password)
    private EditText password;
    @ViewInject(R.id.et_code)
    private EditText checkCode;
    @ViewInject(R.id.iv_showCode)
    private ImageView showCode;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        title.setText(R.string.app_login);
    }
    @Event({R.id.img_back,R.id.login,R.id.tv_forgetpassword,R.id.tv_startregister})
    private void onClick(View v){
        switch (v.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.login:
                break;
            case R.id.tv_forgetpassword:
                break;
            case R.id.tv_startregister:
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivityForResult(intent,0);
                break;
        }
    }
}
