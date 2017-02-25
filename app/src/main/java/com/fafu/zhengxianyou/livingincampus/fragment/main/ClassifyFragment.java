package com.fafu.zhengxianyou.livingincampus.fragment.main;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.adapter.ClassifyAdapter;
import com.fafu.zhengxianyou.livingincampus.app.MyApplication;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;
import com.fafu.zhengxianyou.livingincampus.bean.ClassifyBean;
import com.fafu.zhengxianyou.livingincampus.classify.BusLineActivity;
import com.fafu.zhengxianyou.livingincampus.classify.CommunityActivity;
import com.fafu.zhengxianyou.livingincampus.classify.LibraryActivity;
import com.fafu.zhengxianyou.livingincampus.classify.PoiAroundSearchActivity;
import com.fafu.zhengxianyou.livingincampus.classify.WeatherActivity;
import com.fafu.zhengxianyou.livingincampus.classify.course.CourseActivity;
import com.fafu.zhengxianyou.livingincampus.classify.course.CourseLoginActivity;
import com.fafu.zhengxianyou.livingincampus.config.Config;

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
        ClassifyBean freshmen = new ClassifyBean(R.drawable.curriculum, R.string.course);
        gridBeanList.add(freshmen);

        ClassifyBean graduate = new ClassifyBean(R.drawable.graduate, R.string.library);
        gridBeanList.add(graduate);

        ClassifyBean community = new ClassifyBean(R.drawable.community, R.string.community);
        gridBeanList.add(community);

        ClassifyBean weather = new ClassifyBean(R.drawable.weather, R.string.weather);
        gridBeanList.add(weather);

        ClassifyBean bus = new ClassifyBean(R.drawable.icon_bus, R.string.bus);
        gridBeanList.add(bus);

        ClassifyBean route = new ClassifyBean(R.drawable.route, R.string.route);
        gridBeanList.add(route);


        gv_classify.setAdapter(new ClassifyAdapter(mContext, gridBeanList));

        gv_classify.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        boolean isAddCourse = MyApplication.sp.getBoolean("isAddCourse", false);
                        if (isAddCourse) {
                            Config.setCourseList(Config.getDatabaseAdapter().queryAll());
                            startActivity(new Intent(mContext, CourseActivity.class));
                        }
                        else startActivity(new Intent(mContext, CourseLoginActivity.class));

                        break;
                    case 1:
                        Intent intent = new Intent(mContext, LibraryActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        startActivity(new Intent(mContext, CommunityActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(mContext, WeatherActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(mContext, BusLineActivity.class));

                        break;
                    case 5:
                        startActivity(new Intent(mContext, PoiAroundSearchActivity.class));

                        break;

                }
            }
        });
    }
}
