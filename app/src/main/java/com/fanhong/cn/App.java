package com.fanhong.cn;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Process;

import org.xutils.x;

import java.util.HashSet;
import java.util.Set;

import io.rong.imlib.RongIMClient;

/**
 * Created by Administrator on 2017/8/29.
 */

public class App extends Application {
    public static String USER = "";   //登录名
    public static String PHONENUMBER = "";
    public static int USER_STATE = 0;  //登录成功1，失败为0
    public static String ALIAS = "";   //昵称
    public static String PASSWORD = "";   //登录密码
    public static String LOGO_URL = "";   //头像的url
    public static String TOKEN = "";   //融云Token码
    public static String CHATROOM = "";   //聊天室ID
    public static Set<Long> old_msg_times = new HashSet<>();

    public static final String WEB_SITE = "http://m.wuyebest.com";
    public static final String UPDATE_SERVER = "http://m.wuyebest.com/public/apk/";//UPDATE_SERVER = "http://www.safphone.com:801/apk/";
    public static final String UPDATE_APKNAME = "FanHong.apk";
    public static final String UPDATE_VERJSON = "ver_FanHong.json";
    //统一接口路径
    public static String CMDURL = "http://m.wuyebest.com/index.php/App/index";
    //用户头像上传服务器的路径
    public static final String HEAD_PICTURE_URL = "http://m.wuyebest.com/index.php/App/index/upapp";
    //public static final String HEAD_PICTURE_URL = "http://192.168.0.103/upload.php";
    //评论图片上传路径
    public static final String PINGLUN_PICTURE_URL = "http://m.wuyebest.com/index.php/App/index/plup";
    //门禁图片上传路径
    public static final String DOOR_PICTURE_URL = "http://m.wuyebest.com/index.php/App/index/user_xx";
    //二手卖品图片上传路径
    public static final String GOODS_PICTURE_URL = "http://m.wuyebest.com/index.php/App/index/goods2";
    //开门禁所需访问的路径
//	public static final String OPEN_LOCKED_URL = "http://fhtxjs.imwork.net:30626/BEST1.0.1/index.php/AppAdmin/Index/yjkd";
    public static final String OPEN_LOCKED_URL = "http://m.wuyebest.com/index.php/App/index/yjkm";

    @Override
    public void onCreate() {
        super.onCreate();
        //xUtils初始化
        x.Ext.init(this);
        /**
         * OnCreate 会被多个进程重入，这段保护代码，确保只有您需要使用 RongIMClient 的进程和 Push 进程执行了 init。
         * io.rong.push 为融云 push 进程名称，不可修改。
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
            if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext())) ||
                    "io.rong.push".equals(getCurProcessName(getApplicationContext()))) {
                RongIMClient.init(this);
            }
        }
    }

    public static String getCurProcessName(Context context) {

        int pid = Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
            for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                    .getRunningAppProcesses()) {

                if (appProcess.pid == pid) {
                    return appProcess.processName;
                }
            }
        }
        return null;
    }

    public static String getUrlFromUri(Uri uri) {
        return WEB_SITE + uri.getPath();
    }
}
