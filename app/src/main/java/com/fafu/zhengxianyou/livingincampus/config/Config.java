package com.fafu.zhengxianyou.livingincampus.config;

/**
 * Created by zhengxianyou on 2017/1/7.
 */

public class Config {
    private static String cityName;
    private static Double latitude = 26.083107;
    private static Double longitude = 119.241147;

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
}
