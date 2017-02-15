package com.fafu.zhengxianyou.livingincampus.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.bean.CommunityItem;

import java.util.List;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by zhengxianyou on 2017/2/13.
 */

public class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder>{
    private Context mContext;
    private List<CommunityItem> mCommunityItemList;
    private String myIcon;


    public CommunityAdapter(Context context, List<CommunityItem> list) {
        mContext = context;
        mCommunityItemList = list;
    }

    @Override
    public CommunityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommunityViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_community_rv,null));
    }

    @Override
    public int getItemCount() {
        return mCommunityItemList.size();
    }

    @Override
    public void onBindViewHolder(CommunityViewHolder holder, int position) {
        holder.setData(position);

    }



    class CommunityViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_icon;
        TextView tv_nick, tv_content, tv_datetime, tv_number;
    public CommunityViewHolder(View itemView) {
        super(itemView);
        iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        tv_nick = (TextView) itemView.findViewById(R.id.tv_nick);
        tv_datetime = (TextView) itemView.findViewById(R.id.tv_datetime);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        tv_number = (TextView) itemView.findViewById(R.id.tv_number);

    }

        public void setData(int position) {
            CommunityItem item = mCommunityItemList.get(position);
            myIcon = item.getMyIcon();
            tv_nick.setText(item.getNickName());
            tv_datetime.setText(item.getDatetime());
            tv_content.setText(item.getContent());

            setIcon(myIcon);
        }

        /**
         * 填充头像
         * @param myIcon
         */
        private void setIcon(String myIcon) {
            switch (myIcon) {

                case "icon1":
                   Glide.with(mContext)
                           .load(R.drawable.icon1)
                           .bitmapTransform(new CropCircleTransformation(mContext))
                           .into(iv_icon);

                    break;

                case "icon2":
                    Glide.with(mContext)
                            .load(R.drawable.icon2)
                            .bitmapTransform(new CropCircleTransformation(mContext))
                            .into(iv_icon);
                    break;

                case "icon3":
                    Glide.with(mContext)
                            .load(R.drawable.icon3)
                            .bitmapTransform(new CropCircleTransformation(mContext))
                            .into(iv_icon);

                    break;

                case "icon4":
                    Glide.with(mContext)
                            .load(R.drawable.icon4)
                            .bitmapTransform(new CropCircleTransformation(mContext))
                            .into(iv_icon);

                    break;

                case "icon5":
                    Glide.with(mContext)
                            .load(R.drawable.icon5)
                            .bitmapTransform(new CropCircleTransformation(mContext))
                            .into(iv_icon);

                    break;

                case "icon6":
                    Glide.with(mContext)
                            .load(R.drawable.icon6)
                            .bitmapTransform(new CropCircleTransformation(mContext))
                            .into(iv_icon);

                    break;

                case "icon7":
                    Glide.with(mContext)
                            .load(R.drawable.icon7)
                            .bitmapTransform(new CropCircleTransformation(mContext))
                            .into(iv_icon);

                    break;

                case "icon8":
                    Glide.with(mContext)
                            .load(R.drawable.icon8)
                            .bitmapTransform(new CropCircleTransformation(mContext))
                            .into(iv_icon);

                    break;

                case "icon9":
                    Glide.with(mContext)
                            .load(R.drawable.icon9)
                            .bitmapTransform(new CropCircleTransformation(mContext))
                            .into(iv_icon);

                    break;

                default:

                    break;
            }
        }
    }

}
