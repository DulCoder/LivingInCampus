package com.fafu.zhengxianyou.livingincampus.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.fafu.zhengxianyou.livingincampus.BannerInfoActivity;
import com.fafu.zhengxianyou.livingincampus.BusLineActivity;
import com.fafu.zhengxianyou.livingincampus.Constants.Constant;
import com.fafu.zhengxianyou.livingincampus.CourseActivity;
import com.fafu.zhengxianyou.livingincampus.route.PoiAroundSearchActivity;
import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.WeatherActivity;
import com.fafu.zhengxianyou.livingincampus.adapter.ClassifyAdapter;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;
import com.fafu.zhengxianyou.livingincampus.bean.ClassifyBean;
import com.fafu.zhengxianyou.livingincampus.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengxianyou on 2017/1/2.
 */

public class ClassifyFragment extends BaseFragment {
    private View mView;
    private GridView gv_classify;
    private List<ClassifyBean> gridBeanList;

    /**
     * 创建返回实例
     */
    public static ClassifyFragment newInstance() {

        ClassifyFragment fragment = new ClassifyFragment();
        return fragment;
    }

    @Override
    protected View initView() {
        mView = View.inflate(mContext, R.layout.fragment_classify, null);

        gv_classify = (GridView) mView.findViewById(R.id.gv_classify);
        return mView;
    }

    @Override
    protected void initData() {
        super.initData();

        gridBeanList = new ArrayList<>();
        ClassifyBean freshmen = new ClassifyBean(R.drawable.curriculum, R.string.freshmen);
        gridBeanList.add(freshmen);

        ClassifyBean graduate = new ClassifyBean(R.drawable.graduate, R.string.library);
        gridBeanList.add(graduate);

        ClassifyBean community = new ClassifyBean(R.drawable.community, R.string.community);
        gridBeanList.add(community);

        ClassifyBean weather = new ClassifyBean(R.drawable.weather, R.string.weather);
        gridBeanList.add(weather);

        ClassifyBean periphery = new ClassifyBean(R.drawable.periphery, R.string.periphery);
        gridBeanList.add(periphery);

        ClassifyBean route = new ClassifyBean(R.drawable.route, R.string.route);
        gridBeanList.add(route);

        ClassifyBean bus = new ClassifyBean(R.drawable.icon_bus, R.string.bus);
        gridBeanList.add(bus);


        gv_classify.setAdapter(new ClassifyAdapter(mContext, gridBeanList));

        gv_classify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(mContext, CourseActivity.class));

                        break;
                    case 1:
                        Intent intent = new Intent(mContext, BannerInfoActivity.class);
                        intent.putExtra("url", Constant.LIBRARY);
                        startActivity(intent);
                        break;
                    case 2:
                        Utils.toast(mContext, "此模块待开发...");

                        break;
                    case 3:
                        startActivity(new Intent(mContext, WeatherActivity.class));
                        break;
                    case 4:
                        Utils.toast(mContext, "此模块待开发...");

                        break;
                    case 5:
                        startActivity(new Intent(mContext, PoiAroundSearchActivity.class));

                        break;
                    case 6:
                        startActivity(new Intent(mContext, BusLineActivity.class));

                        break;


                }
            }
        });
    }
}
