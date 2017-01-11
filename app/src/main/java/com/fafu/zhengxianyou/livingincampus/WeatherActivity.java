package com.fafu.zhengxianyou.livingincampus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;
import com.fafu.zhengxianyou.livingincampus.config.Config;
import com.fafu.zhengxianyou.livingincampus.utils.Utils;

import java.util.Calendar;
import java.util.List;

import static com.fafu.zhengxianyou.livingincampus.R.id.reporttime1;

public class WeatherActivity extends Activity implements WeatherSearch.OnWeatherSearchListener {
    private TextView tv_forecast;
    private TextView reportTime1;
    private TextView currentTime;
    private TextView weather;
    private TextView Temperature;
    private TextView wind;
    private TextView humidity;
    private WeatherSearchQuery mQuery;
    private WeatherSearch mWeatherSearch;
    private LocalWeatherLive mWeatherLive;
    private LocalWeatherForecast mWeatherForecast;
    private List<LocalDayWeatherForecast> mForecastList = null;
    private String cityName = Config.getCityName();//天气搜索的城市，可以写名称或adcode；
    private String today;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        initView();
        getCurrentTime();
        searchLiveWeather();
        searchForecastWeather();
    }

    /**
     * 初始化View
     */
    private void initView() {
        TextView city = (TextView) findViewById(R.id.city);
        city.setText(cityName);
        tv_forecast = (TextView) findViewById(R.id.forecast);
        currentTime = (TextView) findViewById(R.id.currentTime);
        reportTime1 = (TextView) findViewById(reporttime1);
        weather = (TextView) findViewById(R.id.weather);
        Temperature = (TextView) findViewById(R.id.temp);
        wind = (TextView) findViewById(R.id.wind);
        humidity = (TextView) findViewById(R.id.humidity);
    }

    /**
     * 获取当前时间
     */
    private void getCurrentTime() {
        Calendar c = Calendar.getInstance();
//        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mWeek = String.valueOf(c.get(Calendar.DAY_OF_WEEK)-1);

        today = getWeek(Integer.parseInt(mWeek));
    }

    /**
     * 把当前时间转换成周几
     */
    private String getWeek(int mWeek) {
        String week = null;
        switch (mWeek){
            case 0:
                week = "周日";
                break;
            case 1:
                week = "周一";
                break;
            case 2:
                week = "周二";
                break;
            case 3:
                week = "周三";
                break;
            case 4:
                week = "周四";
                break;
            case 5:
                week = "周五";
                break;
            case 6:
                week = "周六";
                break;
            case 7:
                week = "周日";
                break;
            default:
                break;
        }
        return week;
    }

    /**
     * 请求最近四天的天气信息
     */
    private void searchForecastWeather() {
        mQuery = new WeatherSearchQuery(cityName, WeatherSearchQuery.WEATHER_TYPE_FORECAST);//检索参数为城市和天气类型，实时天气为1、天气预报为2
        mWeatherSearch = new WeatherSearch(this);
        mWeatherSearch.setOnWeatherSearchListener(this);
        mWeatherSearch.setQuery(mQuery);
        mWeatherSearch.searchWeatherAsyn(); //异步搜索
    }

    /**
     * 请求实时天气信息
     */
    private void searchLiveWeather() {
        mQuery = new WeatherSearchQuery(cityName, WeatherSearchQuery.WEATHER_TYPE_LIVE);//检索参数为城市和天气类型，实时天气为1、天气预报为2
        mWeatherSearch = new WeatherSearch(this);
        mWeatherSearch.setOnWeatherSearchListener(this);
        mWeatherSearch.setQuery(mQuery);
        mWeatherSearch.searchWeatherAsyn(); //异步搜索
    }

    @Override
    public void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int i) {
        if (i == 1000) {
            if (localWeatherLiveResult != null && localWeatherLiveResult.getLiveResult() != null) {
                mWeatherLive = localWeatherLiveResult.getLiveResult();
                reportTime1.setText(mWeatherLive.getReportTime() + "发布");
                currentTime.setText(today+"\n"+"实时");

                weather.setText(mWeatherLive.getWeather());
                Temperature.setText(mWeatherLive.getTemperature() + "°");
                wind.setText(mWeatherLive.getWindDirection() + "风     " + mWeatherLive.getWindPower() + "级");
                humidity.setText("湿度         " + mWeatherLive.getHumidity() + "%");
            } else {
            }
        } else {
            Utils.toast(this, i + "");
        }
    }

    @Override
    public void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int i) {
        if (i == 1000) {
            if (localWeatherForecastResult != null && localWeatherForecastResult.getForecastResult() != null
                    && localWeatherForecastResult.getForecastResult().getWeatherForecast() != null
                    && localWeatherForecastResult.getForecastResult().getWeatherForecast().size() > 0) {
                mWeatherForecast = localWeatherForecastResult.getForecastResult();
                mForecastList = mWeatherForecast.getWeatherForecast();
                fillForecast();

            } else {
            }
        } else {
            Utils.toast(this, i + "");

        }
    }

    /**
     * 显示未来四天的天气
     */
    private void fillForecast() {
        String forecast = "";
        for (int i = 0; i < mForecastList.size(); i++) {
            LocalDayWeatherForecast localdayweatherforecast = mForecastList.get(i);
            String week = getWeek(Integer.valueOf(localdayweatherforecast.getWeek()));

            String temp = String.format("%-3s/%3s",
                    localdayweatherforecast.getDayTemp() + "°",
                    localdayweatherforecast.getNightTemp() + "°");
            String weather = String.format("%-3s/%3s",
                    localdayweatherforecast.getDayWeather(),
                    localdayweatherforecast.getNightWeather());
            forecast += week + "      " + weather + "     " + temp + "\n\n";
        }
        tv_forecast.setText(forecast);
    }
}
