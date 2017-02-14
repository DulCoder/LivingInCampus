package com.fafu.zhengxianyou.livingincampus.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.fafu.zhengxianyou.livingincampus.Constants.Constant;
import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.adapter.HomeFragmentAdapter;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;
import com.fafu.zhengxianyou.livingincampus.bean.ResultBeanData;
import com.fafu.zhengxianyou.livingincampus.config.Config;
import com.fafu.zhengxianyou.livingincampus.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengxianyou on 2017/1/2.
 */

public class HomeFragment extends BaseFragment{
    private View mView;
    private RecyclerView rv_home;
    private  ResultBeanData.ResultBean resultBean;
    private  List<ResultBeanData.PictureUrlBean> pictureUrlBeanList;
    private  List<ResultBeanData.FocusBean> focusBeanList;
    private  List<ResultBeanData.AnnouncementBean> announcementBeanList;
    private  List<ResultBeanData.CampusCultureBean> campusCultureBeanList;
    private List<ResultBeanData.CollegeTendsBean> collegeTendsBeanList;
    private List<ResultBeanData.AcademicTendsBean> academicTendsBeanList;
    private String json;
    private static final String TAG = HomeFragment.class.getSimpleName();
    /**
     *创建返回实例
     */
    public static HomeFragment newInstance() {

        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            rv_home.setAdapter(new HomeFragmentAdapter(mContext,resultBean));

        }
    };

    @Override
    protected View initView() {
        mView = View.inflate(mContext,R.layout.fragment_home,null);

        rv_home = (RecyclerView) mView.findViewById(R.id.rv_home);
        rv_home.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));

        return mView;
    }

    /**
     * 请求网络数据
     */
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            getJson();               //请求滚动窗口的json数据

            getFocus();              //请求 农大要闻 数据

            getAnnouncement();       //请求 公示公告 数据

            getCampusCulture();      //请求 校园文化 数据

            getCollegeTends();       //请求 学院动态 数据

            getAcademicTends();      //请求 教务动态 数据

            processData();           //处理请求到的网络数据
        }
    };


    /**
     * 请求json数据
     */
    private void getJson() {

        try {
            URL   url = new URL(Constant.FAFU);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            String temp = contentBuf.toString();
            int begin = temp.indexOf("var w111imgJsons = ") + 19;
            int end= temp.indexOf("}];")+2;

            json = temp.substring(begin, end);

            Gson gson = new Gson();
            pictureUrlBeanList = gson.fromJson(json,new TypeToken<List<ResultBeanData.PictureUrlBean>>(){}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求 农大要闻 数据
     */
    private void getFocus() {
        focusBeanList = new ArrayList<>();
        ResultBeanData.FocusBean focusBean;
        try {
            Document document = Jsoup.connect(Constant.FOCUS).get();
            Element element = document.getElementById("wp_news_w3");
            Elements links = element.getElementsByTag("a");
            for (Element link:links){
                String href = link.attr("href");
                String title = link.attr("title");

                focusBean = new ResultBeanData.FocusBean(href,title);
                focusBeanList.add(focusBean);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求 公示公告 数据
     */
    private void getAnnouncement() {
        announcementBeanList = new ArrayList<>();
        ResultBeanData.AnnouncementBean announcementBean;
        try {
            Document document = Jsoup.connect(Constant.ANNOUNCEMENT).get();
            Element element = document.getElementById("wp_news_w3");
            Elements links = element.getElementsByTag("a");
            for (Element link:links){
                String href = link.attr("href");
                String title = link.attr("title");

                announcementBean = new ResultBeanData.AnnouncementBean(href,title);
                announcementBeanList.add(announcementBean);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求 校园文化 数据
     */
    private void getCampusCulture() {
        campusCultureBeanList = new ArrayList<>();
        ResultBeanData.CampusCultureBean campusCultureBean;

        try {
            Document document = Jsoup.connect(Constant.CAMPUS_CULTURE).get();
            Element element = document.getElementById("wp_news_w3");
            Elements links = element.getElementsByTag("a");
            for (Element link:links){
                String href = link.attr("href");
                String title = link.attr("title");

                campusCultureBean = new ResultBeanData.CampusCultureBean(href,title);
                campusCultureBeanList.add(campusCultureBean);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 请求 学院动态 数据
     */
    private void getCollegeTends() {
        collegeTendsBeanList = new ArrayList<>();
        ResultBeanData.CollegeTendsBean collegeTendsBean;

        try {
            Document document = Jsoup.connect(Constant.COLLEGE_TENDS).get();
            Element element = document.getElementById("wp_news_w3");
            Elements links = element.getElementsByTag("a");
            for (Element link:links){
                String href = link.attr("href");
                String title = link.attr("title");

                collegeTendsBean = new ResultBeanData.CollegeTendsBean(href,title);
                collegeTendsBeanList.add(collegeTendsBean);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 请求 教务动态 数据
     */
    private void getAcademicTends() {
        academicTendsBeanList = new ArrayList<>();
        ResultBeanData.AcademicTendsBean academicTendsBean;

        try {
            Document document = Jsoup.connect(Constant.ACADEMIC_TENDS).get();
            Element element = document.getElementById("wp_news_w3");
            Elements links = element.getElementsByTag("a");
            for (Element link:links){
                String href = link.attr("href");
                String title = link.attr("title");

                academicTendsBean = new ResultBeanData.AcademicTendsBean(href,title);
                academicTendsBeanList.add(academicTendsBean);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 处理请求到的网络数据
     */
    private void processData() {
        resultBean = new ResultBeanData.ResultBean();
        resultBean.setPictureUrlBeanList(pictureUrlBeanList);
        resultBean.setFocusBeanList(focusBeanList);
        resultBean.setAnnouncementBeanList(announcementBeanList);
        resultBean.setCampusCultureBeanList(campusCultureBeanList);
        resultBean.setCollegeTendsBeanList(collegeTendsBeanList);
        resultBean.setAcademicTendsBeanList(academicTendsBeanList);
        handler.sendEmptyMessage(0);
    }





    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "常用框架Fragment数据被初始化了...");

        // 开辟一个子线程请求网络数据
        if (Config.isConnectNet()) {
            new Thread(runnable).start();
        }else {
            Utils.toast(mContext,"无网络");
        }
    }
}
