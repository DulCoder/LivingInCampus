package com.fafu.zhengxianyou.livingincampus.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhengxianyou on 2017/2/13.
 */

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder>{


    @Override
    public CommunityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(CommunityViewHolder holder, int position) {

    }


    class CommunityViewHolder extends RecyclerView.ViewHolder{

    public CommunityViewHolder(View itemView) {
        super(itemView);
    }
}

}
