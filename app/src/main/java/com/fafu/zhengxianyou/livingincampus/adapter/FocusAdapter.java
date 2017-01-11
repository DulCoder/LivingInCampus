package com.fafu.zhengxianyou.livingincampus.adapter;

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

public class FocusAdapter extends RecyclerView.Adapter<FocusAdapter.FocusViewHolder1>{

    private final Context context;
    private final  List<ResultBeanData.FocusBean> focusBeen;

    public FocusAdapter(Context context, List<ResultBeanData.FocusBean> focusBeanList) {
        this.context = context;
        focusBeen = focusBeanList;
    }

    @Override
    public FocusViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FocusViewHolder1(LayoutInflater.from(context).inflate(R.layout.item_rv,null));
    }

    @Override
    public void onBindViewHolder(FocusViewHolder1 holder, int position) {
        holder.setData(position);

    }

    @Override
    public int getItemCount() {
        return focusBeen.size();
    }



    class FocusViewHolder1 extends RecyclerView.ViewHolder{
        TextView tv_news;

        public FocusViewHolder1(View itemView) {
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
            tv_news.setText(focusBeen.get(position).getTitle());

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
