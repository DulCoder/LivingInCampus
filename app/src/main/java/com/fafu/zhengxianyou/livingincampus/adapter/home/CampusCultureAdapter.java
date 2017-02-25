package com.fafu.zhengxianyou.livingincampus.adapter.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.bean.ResultBeanData;

import java.util.List;

/**
 * Created by zhengxianyou on 2017/1/5.
 */

public class CampusCultureAdapter extends RecyclerView.Adapter<CampusCultureAdapter.CampusCultureViewHolder1>{

    private final Context context;
    private final  List<ResultBeanData.CampusCultureBean> mCampusCultureBeen;

    public CampusCultureAdapter(Context context, List<ResultBeanData.CampusCultureBean> campusCultureBeanList) {
        this.context = context;
        mCampusCultureBeen = campusCultureBeanList;
    }

    @Override
    public CampusCultureViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CampusCultureViewHolder1(LayoutInflater.from(context).inflate(R.layout.item_rv,null));
    }

    @Override
    public void onBindViewHolder(CampusCultureViewHolder1 holder, int position) {
        holder.setData(position);

    }

    @Override
    public int getItemCount() {
        return mCampusCultureBeen.size();
    }



    class CampusCultureViewHolder1 extends RecyclerView.ViewHolder{
        TextView tv_news;

        public CampusCultureViewHolder1(View itemView) {
            super(itemView);
            tv_news = (TextView) itemView.findViewById(R.id.tv_news);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onRecyclerViewClickListener != null){
                        onRecyclerViewClickListener.onItemClickListener(getLayoutPosition());
                    }
                }
            });

        }

        public void setData( int position) {
            tv_news.setText(mCampusCultureBeen.get(position).getTitle());

        }
    }

    /**
     * 设置监听事件回调接口
     */
    private OnRecyclerViewClickListener onRecyclerViewClickListener;

    public interface OnRecyclerViewClickListener{
        void onItemClickListener(int position);
    }

    public void setOnRecyclerViewClickListener(OnRecyclerViewClickListener onRecyclerViewClickListener) {
        this.onRecyclerViewClickListener = onRecyclerViewClickListener;
    }
}
