package com.fafu.zhengxianyou.livingincampus.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fafu.zhengxianyou.livingincampus.app.WebInfoActivity;
import com.fafu.zhengxianyou.livingincampus.constant.Constants;
import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.bean.ResultBeanData;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengxianyou on 2017/1/3.
 * 首页六个模块的数据添加
 */

public class HomeFragmentAdapter extends RecyclerView.Adapter {
    /**
     * 滚动窗口
     */
    public static final int BANNER = 0;
    /**
     * 聚焦农大
     */
    public static final int FOCUS = 1;
    /**
     * 公示公告
     */
    public static final int ANNOUNCEMENT = 2;
    /**
     * 文化校园
     */
    public static final int CAMPUS_CULTURE = 3;
    /**
     * 学院动态
     */
    public static final int COLLEGE_TENDS = 4;
    /**
     * 教务动态
     */
    public static final int ACADEMIC_TENDS = 5;

    /**
     * 用来初始化布局
     */
    private LayoutInflater mLayoutInflater;
    private final ResultBeanData.ResultBean resultBean;
    private Context mContext;


    /**
     * 当前类型
     */
    private int currentType = BANNER;

    public HomeFragmentAdapter(Context mContext, ResultBeanData.ResultBean resultBean) {
        this.mContext = mContext;
        this.resultBean = resultBean;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case BANNER:
                return new BannerViewHolder(mLayoutInflater.inflate(R.layout.banner_viewpager, null), mContext);
            case FOCUS:
                return new FocusViewHolder(mLayoutInflater.inflate(R.layout.news_item, null), mContext);
            case ANNOUNCEMENT:
                return new AnnouncementViewHolder(mLayoutInflater.inflate(R.layout.news_item,null),mContext);
            case CAMPUS_CULTURE:
                return new CampusCultureViewHolder(mLayoutInflater.inflate(R.layout.news_item,null),mContext);
            case COLLEGE_TENDS:
                return new CollegeTendsViewHolder(mLayoutInflater.inflate(R.layout.news_item,null),mContext);
            case ACADEMIC_TENDS:
                return new AcademicTendsViewHolder(mLayoutInflater.inflate(R.layout.news_item,null),mContext);
        }

        return null;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case BANNER:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;

                //设置banner的数据
                if (resultBean.getPictureUrlBeanList()!=null)
                bannerViewHolder.setData(resultBean.getPictureUrlBeanList());
                break;
            case FOCUS:
                FocusViewHolder focusViewHolder = (FocusViewHolder) holder;

                if (resultBean.getFocusBeanList()!=null)
                focusViewHolder.setData(resultBean.getFocusBeanList());
                break;
            case ANNOUNCEMENT:
                AnnouncementViewHolder announcementViewHolder = (AnnouncementViewHolder) holder;

                if (resultBean.getAnnouncementBeanList()!=null)
                announcementViewHolder.setData(resultBean.getAnnouncementBeanList());
                break;
            case CAMPUS_CULTURE:
                CampusCultureViewHolder campusCultureViewHolder = (CampusCultureViewHolder) holder;

                if (resultBean.getCampusCultureBeanList()!=null)
                campusCultureViewHolder.setData(resultBean.getCampusCultureBeanList());
                break;
            case COLLEGE_TENDS:
                CollegeTendsViewHolder collegeTendsViewHolder = (CollegeTendsViewHolder) holder;

                if (resultBean.getCollegeTendsBeanList()!=null)
                collegeTendsViewHolder.setData(resultBean.getCollegeTendsBeanList());
                break;
            case ACADEMIC_TENDS:
                AcademicTendsViewHolder academicTendsViewHolder = (AcademicTendsViewHolder) holder;

                if (resultBean.getAcademicTendsBeanList()!=null)
                academicTendsViewHolder.setData(resultBean.getAcademicTendsBeanList());
                break;
        }


    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case BANNER:
                currentType = BANNER;
                break;
            case FOCUS:
                currentType = FOCUS;
                break;
            case ANNOUNCEMENT:
                currentType = ANNOUNCEMENT;
                break;
            case CAMPUS_CULTURE:
                currentType = CAMPUS_CULTURE;
                break;
            case COLLEGE_TENDS:
                currentType = COLLEGE_TENDS;
                break;
            case ACADEMIC_TENDS:
                currentType = ACADEMIC_TENDS;
                break;
        }
        return currentType;
    }

    //////////////////////////////滚动窗口////////////////////////////////////////////////////////////////////////

    class BannerViewHolder extends RecyclerView.ViewHolder {

        public Banner mBanner;
        public Context mContext;

        public BannerViewHolder(View itemView, Context mContext) {
            super(itemView);
            this.mContext = mContext;
            mBanner = (Banner) itemView.findViewById(R.id.banner);
        }


        public void setData(final List<ResultBeanData.PictureUrlBean> pictureBeans) {
            List<String> imageUrls = new ArrayList<>();
            int size = pictureBeans.size();
            for (int i = 0; i < size; i++) {
                String images = Constants.FAFU + pictureBeans.get(i).getSrc();
                imageUrls.add(images);
            }

            mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);//循环播放
            mBanner.setBannerAnimation(Transformer.Accordion);  //设置手风琴切换效果
            mBanner.setImages(imageUrls).setImageLoader(new GlideImageLoader()).start();

            mBanner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    String url = pictureBeans.get(position - 1).getUrl();
                    Intent intent = new Intent(mContext, WebInfoActivity.class);
                    intent.putExtra("url", url);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */

            //Glide 加载图片简单用法
            //请求图片
            Glide.with(mContext).load(path).into(imageView);

        }
    }


//////////////////////////////聚焦农大////////////////////////////////////////////////////////////////////////

    class FocusViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        private RecyclerView rv_item;

        public FocusViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            rv_item = (RecyclerView) itemView.findViewById(R.id.rv_item);
        }


        public void setData(final List<ResultBeanData.FocusBean> focusBeanList) {
            rv_item.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            FocusAdapter adapter = new FocusAdapter(context, focusBeanList);
            adapter.setOnRecyclerViewClickListener(new FocusAdapter.OnRecyclerViewClickListener() {
                @Override
                public void onItemClickListener(int position) {
                    String url = Constants.FAFU+focusBeanList.get(position).getHref();
                    Intent intent = new Intent(mContext, WebInfoActivity.class);
                    intent.putExtra("url", url);
                    mContext.startActivity(intent);
                }
            });
            rv_item.setAdapter(adapter);
        }
    }

//////////////////////////////公示公告////////////////////////////////////////////////////////////////////////

class AnnouncementViewHolder extends RecyclerView.ViewHolder{
    private TextView tv_title;
    private RecyclerView rv_item;
    private final Context context;

    public AnnouncementViewHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        rv_item = (RecyclerView) itemView.findViewById(R.id.rv_item);

    }

    public void setData(final List<ResultBeanData.AnnouncementBean> announcementBeanList) {
        tv_title.setText(R.string.announcement);

        rv_item.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        AnnouncementAdapter adapter = new AnnouncementAdapter(context, announcementBeanList);
        adapter.setOnRecyclerViewClickListener(new AnnouncementAdapter.OnRecyclerViewClickListener() {
            @Override
            public void onItemClickListener(int position) {
                String url = Constants.FAFU+announcementBeanList.get(position).getHref();
                Intent intent = new Intent(mContext, WebInfoActivity.class);
                intent.putExtra("url", url);
                mContext.startActivity(intent);
            }
        });
        rv_item.setAdapter(adapter);
    }

    }

    //////////////////////////////校园文化////////////////////////////////////////////////////////////////////////

    class CampusCultureViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title;
        private RecyclerView rv_item;
        private final Context context;

        public CampusCultureViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            rv_item = (RecyclerView) itemView.findViewById(R.id.rv_item);

        }

        public void setData(final List<ResultBeanData.CampusCultureBean> campusCultureBeanList) {
            tv_title.setText(R.string.campusCulture);

            rv_item.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            CampusCultureAdapter adapter = new CampusCultureAdapter(context, campusCultureBeanList);
            adapter.setOnRecyclerViewClickListener(new CampusCultureAdapter.OnRecyclerViewClickListener() {
                @Override
                public void onItemClickListener(int position) {
                    String url = Constants.FAFU+campusCultureBeanList.get(position).getHref();
                    Intent intent = new Intent(mContext, WebInfoActivity.class);
                    intent.putExtra("url", url);
                    mContext.startActivity(intent);
                }
            });
            rv_item.setAdapter(adapter);

        }
    }

    //////////////////////////////学院动态////////////////////////////////////////////////////////////////////////

    private class CollegeTendsViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private RecyclerView rv_item;
        private final Context context;

        public CollegeTendsViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            rv_item = (RecyclerView) itemView.findViewById(R.id.rv_item);
        }

        public void setData(final List<ResultBeanData.CollegeTendsBean> collegeTendsBeanList) {
            tv_title.setText(R.string.collegeTends);

            rv_item.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            CollegeTendsAdapter adapter = new CollegeTendsAdapter(context, collegeTendsBeanList);
            adapter.setOnRecyclerViewClickListener(new CollegeTendsAdapter.OnRecyclerViewClickListener() {
                @Override
                public void onItemClickListener(int position) {
                    String url = Constants.FAFU+collegeTendsBeanList.get(position).getHref();
                    Intent intent = new Intent(mContext, WebInfoActivity.class);
                    intent.putExtra("url", url);
                    mContext.startActivity(intent);
                }
            });
            rv_item.setAdapter(adapter);
        }
    }

    //////////////////////////////教务动态////////////////////////////////////////////////////////////////////////

    private class AcademicTendsViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private RecyclerView rv_item;
        private final Context context;

        public AcademicTendsViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            rv_item = (RecyclerView) itemView.findViewById(R.id.rv_item);
        }

        public void setData(final List<ResultBeanData.AcademicTendsBean> academicTendsBeanList) {
            tv_title.setText(R.string.academicTends);

            rv_item.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            AcademicTendsAdapter adapter = new AcademicTendsAdapter(context, academicTendsBeanList);
            adapter.setOnRecyclerViewClickListener(new AcademicTendsAdapter.OnRecyclerViewClickListener() {
                @Override
                public void onItemClickListener(int position) {
                    String url = Constants.FAFU+academicTendsBeanList.get(position).getHref();
                    Intent intent = new Intent(mContext, WebInfoActivity.class);
                    intent.putExtra("url", url);
                    mContext.startActivity(intent);
                }
            });
            rv_item.setAdapter(adapter);
        }
    }



}
