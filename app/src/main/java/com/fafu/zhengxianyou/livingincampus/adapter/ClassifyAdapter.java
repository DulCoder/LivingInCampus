package com.fafu.zhengxianyou.livingincampus.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.bean.ClassifyBean;

import java.util.List;

/**
 * Created by zhengxianyou on 2017/1/7.
 * 分类页面的图标排列显示
 */

public class ClassifyAdapter extends BaseAdapter{
    private Context mContext;
    private List<ClassifyBean> gridBeen;
    public ClassifyAdapter(Context context, List<ClassifyBean> gridBeanList) {
        mContext = context;
        gridBeen = gridBeanList;
    }

    @Override
    public int getCount() {
        return gridBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return gridBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = View.inflate(mContext, R.layout.item_grid,null);
            viewHolder = new ViewHolder();

            viewHolder.iv_classify = (ImageView) convertView.findViewById(R.id.iv_classify);
            viewHolder.tv_classify = (TextView) convertView.findViewById(R.id.tv_classify);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ClassifyBean classifyBean = gridBeen.get(position);
        viewHolder.tv_classify.setText(classifyBean.getName());
        viewHolder.iv_classify.setImageResource(classifyBean.getImageId());

        return convertView;
    }

    class ViewHolder{
        ImageView iv_classify;
        TextView tv_classify;
    }
}
