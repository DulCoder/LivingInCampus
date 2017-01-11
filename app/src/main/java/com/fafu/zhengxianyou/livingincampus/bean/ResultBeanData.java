package com.fafu.zhengxianyou.livingincampus.bean;

import java.util.List;

/**
 * Created by zhengxianyou on 2017/1/3.
 */

public class ResultBeanData {

    public static class ResultBean{
        private List<PictureUrlBean> mPictureUrlBeanList;
        private List<FocusBean> mFocusBeanList;
        private List<AnnouncementBean>mAnnouncementBeanList;
        private List<CampusCultureBean>mCampusCultureBeanList;
        private List<CollegeTendsBean>mCollegeTendsBeanList;
        private List<AcademicTendsBean>mAcademicTendsBeanList;

        public List<PictureUrlBean> getPictureUrlBeanList() {
            return mPictureUrlBeanList;
        }

        public void setPictureUrlBeanList(List<PictureUrlBean> pictureUrlBeanList) {
            mPictureUrlBeanList = pictureUrlBeanList;
        }

        public List<FocusBean> getFocusBeanList() {
            return mFocusBeanList;
        }

        public void setFocusBeanList(List<FocusBean> focusBeanList) {
            mFocusBeanList = focusBeanList;
        }

        public List<AnnouncementBean> getAnnouncementBeanList() {
            return mAnnouncementBeanList;
        }

        public void setAnnouncementBeanList(List<AnnouncementBean> announcementBeanList) {
            mAnnouncementBeanList = announcementBeanList;
        }

        public List<CampusCultureBean> getCampusCultureBeanList() {
            return mCampusCultureBeanList;
        }

        public void setCampusCultureBeanList(List<CampusCultureBean> campusCultureBeanList) {
            mCampusCultureBeanList = campusCultureBeanList;
        }

        public List<CollegeTendsBean> getCollegeTendsBeanList() {
            return mCollegeTendsBeanList;
        }

        public void setCollegeTendsBeanList(List<CollegeTendsBean> collegeTendsBeanList) {
            mCollegeTendsBeanList = collegeTendsBeanList;
        }

        public List<AcademicTendsBean> getAcademicTendsBeanList() {
            return mAcademicTendsBeanList;
        }

        public void setAcademicTendsBeanList(List<AcademicTendsBean> academicTendsBeanList) {
            mAcademicTendsBeanList = academicTendsBeanList;
        }
    }

    /**
     * 滚动窗口json数据
     */
    public static class PictureUrlBean{
        /**
         * src : /_upload/article/images/47/17/79daed0746278d17ff3f16b4fbb6/061147a5-095f-4ace-9ef2-8daacdd083e5.jpg
         * url : http://www.fafu.edu.cn/8d/26/c5276a167206/page.htm
         */

        private String src;
        private String url;

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

    }

    /**
     * 聚焦农大
     */
    public static class FocusBean{
        private String href;
        private String title;

        public FocusBean(String href, String title) {
            this.href = href;
            this.title = title;
        }

        public String getHref() {
            return href;
        }


        public String getTitle() {
            return title;
        }

    }

    /**
     * 公示公告
     */
    public static class AnnouncementBean{
        private String href;
        private String title;

        public AnnouncementBean(String href, String title) {
            this.href = href;
            this.title = title;
        }

        public String getHref() {
            return href;
        }

        public String getTitle() {
            return title;
        }
    }

    /**
     * 文化校园
     */
    public static class CampusCultureBean{
        private String href;
        private String title;

        public CampusCultureBean(String href, String title) {
            this.href = href;
            this.title = title;
        }

        public String getHref() {
            return href;
        }

        public String getTitle() {
            return title;
        }
    }

    /**
     * 学院动态
     */
    public static class CollegeTendsBean{
        private String href;
        private String title;

        public CollegeTendsBean(String href, String title) {
            this.href = href;
            this.title = title;
        }

        public String getHref() {
            return href;
        }

        public String getTitle() {
            return title;
        }
    }

    /**
     * 教务动态
     */
    public static class AcademicTendsBean{
        private String href;
        private String title;

        public AcademicTendsBean(String href, String title) {
            this.href = href;
            this.title = title;
        }

        public String getHref() {
            return href;
        }

        public String getTitle() {
            return title;
        }
    }

}
