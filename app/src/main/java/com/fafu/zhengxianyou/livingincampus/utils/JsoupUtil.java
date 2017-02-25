package com.fafu.zhengxianyou.livingincampus.utils;

import android.text.TextUtils;
import android.util.Log;

import com.fafu.zhengxianyou.livingincampus.bean.Course;
import com.fafu.zhengxianyou.livingincampus.bean.Score;
import com.fafu.zhengxianyou.livingincampus.config.Config;
import com.fafu.zhengxianyou.livingincampus.constant.Constants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhengxianyou on 2017/2/21.
 */

public class JsoupUtil {
    private static final String TAG = JsoupUtil.class.getSimpleName();
    private static JsoupUtil mJsoupUtil;
    List<Course> courseList = new ArrayList<>();


    private JsoupUtil() {
    }

    private static JsoupUtil getInstance() {
        if (mJsoupUtil == null) {
            synchronized (OkHttpUtil.class) {
                if (mJsoupUtil == null) {
                    mJsoupUtil = new JsoupUtil();
                }
            }
        }
        return mJsoupUtil;
    }

    private Map<String, String> _getViewStateValue(String html) {
        Map<String, String> viewStateValue = new LinkedHashMap<>();
        if (null != html) {
            Document document = Jsoup.parse(html);
            Element viewStateElement = document.select("input[name=\"__VIEWSTATE\"]").first();
            Element viewStateGeneratorElement = document.select("input[name=\"__VIEWSTATEGENERATOR\"]").first();
            if (null != viewStateElement) {
                viewStateValue.put(Constants.LOGIN_BODY_NAME_VIEWSTATE, viewStateElement.attr("value"));
            }
            if (null != viewStateGeneratorElement) {
                viewStateValue.put(Constants.LOGIN_BODY_NAME_VIEWSTATEGENERATOR, viewStateGeneratorElement.attr("value"));
            }
        }
        return viewStateValue;
    }

    private Map<String, String> _getNameOrFailedInfo(String html) {
        Map<String, String> returnInfo = new LinkedHashMap<>();
        if (null != html) {
            Document document = Jsoup.parse(html);
            Element nameElement = document.getElementById("xhxm");
            if (null != nameElement) {
                String studentName = nameElement.html();
                Pattern p = Pattern.compile("(.+)[^同学]");
                Matcher m = p.matcher(studentName);
                if (m.find()) {
                    returnInfo.put(Constants.STUDENTNAME, m.group());
                }
            } else { // 找不到学生姓名，说明登录失败，跳转回了登录界面。这里取得登录失败的原因后返回
                Element infoElement = document.select("script[defer]").last();
                if (null != infoElement) {
                    String login_failed_info = infoElement.html();
                    Pattern p = Pattern.compile("([\\u4E00-\\u9FA5]+)");
                    Matcher m = p.matcher(login_failed_info);
                    if (m.find()) {
                        returnInfo.put(Constants.FAILEDINFO, m.group());
                    }
                }
            }
        }
        return returnInfo;
    }

    /**
     * 获取课程表
     *
     * @param html 通过模拟登录获得的网页源代码
     * @return 课程集合
     */
    private void _getCourseList(String html) {

        if (null == html) {
            return;
        }

        Document document = Jsoup.parse(html);
        Element data = document.getElementById("Table1");

        Elements tr = data.getElementsByTag("tr");
        Elements td;
        for (int i = 2; i < 12; i++) {
            td = tr.get(i).getElementsByTag("td");

            switch (i) {
                case 2:                         //第一节am
                    Log.e(TAG, "2");

                    getItem(td, 2, 9);
                    break;
                case 4:                        //第三节am
                    Log.e(TAG, "4");

                    getItem(td, 1, 8);
                    break;
                case 7:                         //第六节pm
                    Log.e(TAG, "7");

                    getItem(td, 2, 9);
                    break;
                case 9:                        //第八节pm
                    Log.e(TAG, "9");

                    getItem(td, 1, 8);
                    break;
                case 11:                       //第十节em
                    Log.e(TAG, "11");
                    int size = td.size();
                    if (size > 8)
                        getItem(td, 2, 9);
                    else getItem(td, 2, size);
                    break;
                default:
                    break;
            }

        }
    }

    /**
     * 逐个获取课程信息
     *
     * @param td 每周第n节课的课程信息
     * @param k  从第几个<td>开始读取即周一
     * @param p  <td></td>的个数即for的边界
     */
    private void getItem(Elements td, int k, int p) {
        String temp;
        int m;
        for (int j = k; j < p; j++) {          //获取周一到周日第一节的课程
            temp = td.get(j).text();
            if (temp.length() != 1 && !TextUtils.isEmpty(temp)) {
                Course course = new Course();
                int end = temp.indexOf(" 周");
                if (k == 2) {
                    course.setWeekNumber(j - 1);
                } else {
                    course.setWeekNumber(j);
                }
                course.setSubjectName(temp.substring(0, end));
                course.setDuring(temp.substring(end + 4, temp.indexOf("周}")));
                if (temp.contains("  ")) {
                    String[] str = temp.split("  ");
                    String s = str[0];
                    String[] str2 = s.split(" ");
                    int len = str2.length;

                    if (len > 5) {
                        course.setClassroom(str2[len - 3]);

                    } else {
                        course.setClassroom(str2[len - 1]);
                    }

                } else {
                    String[] str3 = temp.split(" ");
                    int len = str3.length;
                    if (len == 4 || len == 6 || len == 8 || len == 12) {
                        course.setClassroom(str3[3]);
                    } else {

                        course.setClassroom(str3[len - 3]);
                    }

                }

                courseList.add(course);
            }
        }
        Config.setCourseList(courseList);
        Log.e(TAG, " end");
    }

    public List<Score> _getScoreList(String html) {
        List<Score> scoreList = new ArrayList<>();

        if (null == html) {
            return scoreList;
        }

        Document document = Jsoup.parse(html);
        Elements tables = document.select("table[class=\"datelist\"]");
        Element datas = tables.get(0);
        Elements trs = datas.getElementsByTag("tr");

        for (int i = 0; i < trs.size(); i++) {
            Elements tds = trs.get(i).getElementsByTag("td");

            Score score = new Score();
            for (int j = 0; j < tds.size(); j++) {
                String content = tds.get(j).text();

                switch (j) {
                    case 0:
                        score.setSubject(content);
                        break;
                    case 1:
                        score.setCategory(content);
                        break;
                    case 3:
                        score.setScore(content);
                        break;
                    case 6:
                        score.setFinalScore(content);
                        break;
                    case 7:
                        score.setCredit(content);
                        break;
                    case 8:
                        score.setGradePoint(content);
                        break;

                }
            }
            scoreList.add(score);
        }
        return scoreList;
    }

    /************************
     * 以下为外部可以调用的方法
     ************************/

    public static Map<String, String> getViewStateValue(String html) {
        return getInstance()._getViewStateValue(html);
    }

    public static Map<String, String> getNameOrFailedInfo(String html) {
        return getInstance()._getNameOrFailedInfo(html);
    }

    public static void getCourseList(String html) {
        getInstance()._getCourseList(html);
    }

    public static List<Score> getScoreList(String html) {
        return getInstance()._getScoreList(html);
    }
}
