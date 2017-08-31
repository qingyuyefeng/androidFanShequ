package com.fanhong.cn.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fanhong.cn.R;
import com.fanhong.cn.myviews.MyGridView;

import org.xutils.view.annotation.ContentView;

/**
 * Created by Administrator on 2017/8/31.
 */

@ContentView(R.layout.fragment_service)
public class ServiceViewFragment extends Fragment {

    //定义数组来存放按钮图片
    private int mImageViewArray1[] = {
            R.drawable.service_store, R.drawable.service_es,
            //			R.drawable.service_pay,
            R.drawable.service_dai,R.drawable.service_distribution,R.drawable.service_fix};

    //定义数组文字
    private int mTextviewArray1[] = {
            R.string.service_store, R.string.service_es,
//			R.string.service_pay,
            R.string.service_dai,R.string.service_zsdl,R.string.service_fix};

    private int mImageViewArray2[] = {R.drawable.service_mt, R.drawable.service_dz, R.drawable.service_tb,
            R.drawable.service_jds, R.drawable.service_wph, R.drawable.service_yms,
            R.drawable.service_xc, R.drawable.service_qne, R.drawable.service_tn,
            R.drawable.service_tc};
    private int mTextviewArray2[] = {R.string.service_mt, R.string.service_dz, R.string.service_tb,
            R.string.service_jds, R.string.service_wph, R.string.service_yms,
            R.string.service_xc, R.string.service_qne, R.string.service_tn,
            R.string.service_tc};
    private int mUrlArray2[] = {R.string.url_meituan, R.string.url_dianping, R.string.url_taobao,
            R.string.url_jingdong, R.string.url_weiping, R.string.url_yamaxun,
            R.string.url_xiecheng, R.string.url_quna, R.string.url_tuniu,
            R.string.url_tongcheng};

    private int mImageViewArray3[] = {R.drawable.service_hj, R.drawable.service_funhos, R.drawable.service_ks,
            R.drawable.service_gwy, R.drawable.service_zc, R.drawable.service_my};
    private int mTextviewArray3[] = {R.string.service_hj, R.string.service_funhos, R.string.service_ks,
            R.string.service_gwy, R.string.service_zc, R.string.service_my};
    private int mUrlArray3[] = {R.string.url_huzhang, R.string.url_quyy, R.string.url_teacher,
            R.string.url_gongwuyuan, R.string.url_zhichen, R.string.url_muying};

    MyGridView opergridview1, opergridview2, opergridview3;
    ImageAdapter typeAdapter1, typeAdapter2, typeAdapter3;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View serView = inflater.inflate(R.layout.fragment_service, null);
        return serView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        opergridview1 = (MyGridView) view.findViewById(R.id.opergridview1);
        opergridview2 = (MyGridView) view.findViewById(R.id.opergridview2);
        opergridview3 = (MyGridView) view.findViewById(R.id.opergridview3);
        setGridView1();
        setGridView2();
        setGridView3();
    }

    public void setGridView1() {
        typeAdapter1 = new ImageAdapter(this.getActivity(), mImageViewArray1, mTextviewArray1);
        opergridview1.setAdapter(typeAdapter1);
        opergridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                oper1(position);
                typeAdapter2.SetSelItem(-1);
                typeAdapter2.notifyDataSetChanged();
            }
        });

        opergridview1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    float currentXPosition = event.getX();
                    float currentYPosition = event.getY();
                    int position = opergridview1.pointToPosition((int) currentXPosition, (int) currentYPosition);
                    //m_gv_touch_down = true;
                    if (position != typeAdapter1.GetSelItem()) {
                        typeAdapter1.SetSelItem(position);
                        typeAdapter1.notifyDataSetChanged();
                    }

                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    float currentXPosition = event.getX();
                    float currentYPosition = event.getY();
                    int position = opergridview1.pointToPosition((int) currentXPosition, (int) currentYPosition);
                    //m_gv_touch_down = true;
                    if (position != typeAdapter1.GetSelItem()) {
                        typeAdapter1.SetSelItem(-1);
                        typeAdapter1.notifyDataSetChanged();
                    }
                }
                return false;
            }
        });
    }

    public void setGridView2() {
        typeAdapter2 = new ImageAdapter(this.getActivity(), mImageViewArray2, mTextviewArray2);
        opergridview2.setAdapter(typeAdapter2);
        opergridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                oper2(position);
                typeAdapter2.SetSelItem(-1);
                typeAdapter2.notifyDataSetChanged();
            }
        });
    }

    public void setGridView3() {
        typeAdapter3 = new ImageAdapter(this.getActivity(), mImageViewArray3, mTextviewArray3);
        opergridview3.setAdapter(typeAdapter3);
        opergridview3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                oper3(position);
                typeAdapter3.SetSelItem(-1);
                typeAdapter3.notifyDataSetChanged();
            }
        });
    }

    // 继承BaseAdapter
    public class ImageAdapter extends BaseAdapter {
        // 上下文
        private Context mContext;
        private int m_nSelItem = -1;
        private int[] imageid, textid;

        // 构造方法
        public ImageAdapter(Context c, int[] imageid1, int[] textid1) {
            mContext = c;
            imageid = imageid1;
            textid = textid1;
        }

        // 组件个数
        public int getCount() {
            return imageid.length;
        }

        // 当前组件
        public Object getItem(int position) {
            return null;
        }

        public void SetSelItem(int nItem) {
            m_nSelItem = nItem;
        }

        public int GetSelItem() {
            return m_nSelItem;
        }

        // 当前组件id
        public long getItemId(int position) {
            return 0;
        }

        // 获得当前视图
        public View getView(int position, View convertView, ViewGroup parent) {
            // 声明图片视图
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View v = null;
            ImageView imageView = null;
            TextView tv = null;
            if (convertView == null) {
                // 实例化图片视图
                v = inflater.inflate(R.layout.operatelistview, null);
                // 设置图片视图属性
                v.setPadding(4, 4, 4, 4);
            } else {
                v = (View) convertView;
            }
            // 获得ImageView对象
            imageView = (ImageView) v
                    .findViewById(R.id.ItemImage);
            // 设置图片视图属性
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(4, 4, 4, 4);
            //imageView.setImageResource(imageid[position]);
            Drawable im = getResources().getDrawable(imageid[position]);
            imageView.setImageDrawable(im);
            // 获得TextView对象
            tv = (TextView) v.findViewById(R.id.ItemTitle);
            String str = getString(textid[position]);
            // 为TextView设置操作命令
            tv.setText(str);
            return v;
        }

    }

    //服务区便民服务的点击事件
    private void oper1(int arg) {
        switch (arg) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private void oper2(int arg) {
//        String url = getString(mUrlArray2[arg]);
//        String str = getString(mTextviewArray2[arg]);
//        Intent intent2 = new Intent(getActivity(), WebViewActivity.class);
//        intent2.putExtra("url", url);
//        intent2.putExtra("title", str);
//        startActivityForResult(intent2, 1);
    }

    private void oper3(int arg) {
//        String url = getString(mUrlArray3[arg]);
//        String str = getString(mTextviewArray3[arg]);
//        Intent intent2 = new Intent(getActivity(), WebViewActivity.class);
//        intent2.putExtra("url", url);
//        intent2.putExtra("title", str);
//        startActivityForResult(intent2, 1);
    }
}
