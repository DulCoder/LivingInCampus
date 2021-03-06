package com.fafu.zhengxianyou.livingincampus.config;

import com.fafu.zhengxianyou.livingincampus.bean.Course;
import com.fafu.zhengxianyou.livingincampus.sqlite.DatabaseAdapter;

import java.util.List;

/**
 * Created by zhengxianyou on 2017/1/7.
 */

public class Config {
    private static String cityName = "福州市";
    private static Double latitude = 26.083107;
    private static Double longitude = 119.241147;
    private static boolean isConnectNet = true;
    private static String myIcon;                                    //保存头像信息
    private static String nickName;                                  //保存昵称
    private static DatabaseAdapter sDatabaseAdapter;                                  //保存昵称

    private static List<Course> sCourseList;

    public static String getCityName() {
        return cityName;
    }

    public static void setCityName(String cityName) {
        Config.cityName = cityName;
    }

    public static Double getLatitude() {
        return latitude;
    }

    public static void setLatitude(Double latitude) {
        Config.latitude = latitude;
    }

    public static Double getLongitude() {
        return longitude;
    }

    public static void setLongitude(Double longitude) {
        Config.longitude = longitude;
    }

    public static boolean isConnectNet() {
        return isConnectNet;
    }

    public static void setIsConnectNet(boolean isConnectNet) {
        Config.isConnectNet = isConnectNet;
    }

    public static String getMyIcon() {
        return myIcon;
    }

    public static void setMyIcon(String myIcon) {
        Config.myIcon = myIcon;
    }

    public static String getNickName() {
        return nickName;
    }

    public static void setNickName(String nickName) {
        Config.nickName = nickName;
    }

    public static List<Course> getCourseList() {
        return sCourseList;
    }

    public static void setCourseList(List<Course> courseList) {
        sCourseList = courseList;
    }

    public static DatabaseAdapter getDatabaseAdapter() {
        return sDatabaseAdapter;
    }

    public static void setDatabaseAdapter(DatabaseAdapter databaseAdapter) {
        sDatabaseAdapter = databaseAdapter;
    }
}
