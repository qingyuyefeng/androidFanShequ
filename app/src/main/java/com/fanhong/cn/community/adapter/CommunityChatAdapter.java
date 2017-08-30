package com.fanhong.cn.community.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanhong.cn.App;
import com.fanhong.cn.R;
import com.fanhong.cn.community.models.CommunityMessageBean;
import com.zhy.autolayout.utils.AutoUtils;

import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2017/6/30.
 */

public class CommunityChatAdapter extends BaseAdapter {

    private Context context;
    private List<CommunityMessageBean> list;
    private LayoutInflater mInflater;
    private ImageOptions options;
    private ViewHolderLeft holderLeft;
    private ViewHolderRight holderRight;
    private CommunityMessageBean bean;

    public CommunityChatAdapter(Context context, List<CommunityMessageBean> list) {
        this.context = context;
        this.list = list;
        this.mInflater = LayoutInflater.from(context);
        this.options = new ImageOptions.Builder().setLoadingDrawableId(R.mipmap.head_default).setIgnoreGif(false).setFailureDrawableId(R.mipmap.head_default).setCircular(true).setUseMemCache(true).build();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case CommunityMessageBean.TYPE_LEFT:
                    convertView = mInflater.inflate(R.layout.item_chat_left, null);
                    holderLeft = new ViewHolderLeft();
                    x.view().inject(holderLeft, convertView);
                    AutoUtils.autoSize(convertView);
                    convertView.setTag(holderLeft);
                    break;
                case CommunityMessageBean.TYPE_RIGHT:
                    convertView = mInflater.inflate(R.layout.item_chat_right, null);
                    holderRight = new ViewHolderRight();
                    x.view().inject(holderRight, convertView);
                    AutoUtils.autoSize(convertView);
                    convertView.setTag(holderRight);
                    break;
                default:
                    break;
            }
        } else {
            switch (type) {
                case CommunityMessageBean.TYPE_LEFT:
                    holderLeft = (ViewHolderLeft) convertView.getTag();
                    break;
                case CommunityMessageBean.TYPE_RIGHT:
                    holderRight = (ViewHolderRight) convertView.getTag();
                    break;
                default:
                    break;
            }
        }
        bean = list.get(position);
        switch (type) {
            case CommunityMessageBean.TYPE_LEFT:
                holderLeft.tv_time.setVisibility(View.GONE);
                if (App.old_msg_times.contains(bean.getMsgTime())) {
                    String sendTime = new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(bean.getMsgTime()));
                    holderLeft.tv_time.setVisibility(View.VISIBLE);
                    holderLeft.tv_time.setText(sendTime);
                }
                holderLeft.tv_user.setText(bean.getUserName());
                holderLeft.tv_msg.setText(bean.getMessage());
                x.image().bind(holderLeft.img_head, bean.getHeadUrl(), options);
                break;
            case CommunityMessageBean.TYPE_RIGHT:
                holderRight.tv_time.setVisibility(View.GONE);
                if (App.old_msg_times.contains(bean.getMsgTime())) {
                    String sendTime = new SimpleDateFormat("MM月dd日 HH:mm").format(new Date(bean.getMsgTime()));
                    holderRight.tv_time.setVisibility(View.VISIBLE);
                    holderRight.tv_time.setText(sendTime);
                }
                holderRight.tv_user.setText(bean.getUserName());
                holderRight.tv_msg.setText(bean.getMessage());

                x.image().bind(holderRight.img_head, App.LOGO_URL, options);
//                ImageLoader.getInstance().displayImage(SampleConnection.LOGO_URL, holderRight.img_head, new ImageLoaderPicture(context).getOptions(), new SimpleImageLoadingListener());
            default:
                break;
        }
        return convertView;
    }

    class ViewHolderLeft {
        @ViewInject(R.id.tv_msg_time_left)
        TextView tv_time;
        @ViewInject(R.id.tv_chat_user_left)
        TextView tv_user;
        @ViewInject(R.id.tv_chat_msg_left)
        TextView tv_msg;
        @ViewInject(R.id.img_chat_head_left)
        ImageView img_head;
    }

    class ViewHolderRight {
        @ViewInject(R.id.tv_msg_time_right)
        TextView tv_time;
        @ViewInject(R.id.tv_chat_user_right)
        TextView tv_user;
        @ViewInject(R.id.tv_chat_msg_right)
        TextView tv_msg;
        @ViewInject(R.id.img_chat_head_right)
        ImageView img_head;
    }
}
