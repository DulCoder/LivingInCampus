package com.fafu.zhengxianyou.livingincampus.constant;

import com.fafu.zhengxianyou.livingincampus.sqlite.CourseMeteData;

/**
 * Created by zhengxianyou on 2017/1/3.
 */

public class Constants {
    //Bmob后端云Application ID
    public static final String BMOB_APP_ID = "7b64e748a03eb3a873a7c703f399cf2b";

    /**
     * 数据库相关
     */
    //数据库名
    public static final String DB_NAME = "note.db";
    //数据库版本
    public final static int VERSION = 1;
    public static final String CREATE_TABLE_COURSE =
            "CREATE TABLE "+ CourseMeteData.CourseTable.TABLE_NAME+"(_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "subjectName TEXT,weekNumber INTEGER,during TEXT,classroom TEXT)";

    public static final String DROP_TABLE_COURSE = "DROP TABLE IF EXISTS "+ CourseMeteData.CourseTable.TABLE_NAME;

    //福建农林大学官网
    public static final String FAFU = "http://www.fafu.edu.cn";

    //聚焦农大
    public static final String FOCUS = "http://www.fafu.edu.cn/5276/list.htm";

    //公示公告
    public static final String ANNOUNCEMENT = "http://www.fafu.edu.cn/5280/list.htm";

    //校园文化
    public static final String CAMPUS_CULTURE = "http://www.fafu.edu.cn/5275/list.htm";

    //学院动态
    public static final String COLLEGE_TENDS = "http://www.fafu.edu.cn/5271/list.htm";

    //教务动态
    public static final String ACADEMIC_TENDS = "http://www.fafu.edu.cn/5273/list.htm";

    //图书馆馆藏目录
    public static final String LIBRARY_NATIVE = "http://210.34.85.114:8080/opac/openlink.php?strSearchType=";
    public static final String LIBRARY_NATIVE_TEXT ="&historyCount=1&strText=";
    public static final String LIBRARY_NATIVE_TYPE = "&doctype=";

    //图书馆百度学术
    public static final String BAIDU_ACADEMIC = "http://xueshu.baidu.com/s?wd=";
    public static final String BAIDU_TEXT = "&rsv_bp=0&tn=SE_baiduxueshu_c1gjeupa&rsv_spt=3&ie=utf-8&f=8&rsv_sug2=1&sc_f_para=sc_tasktype%3D{firstSimpleSearch}";
    //高德key
    public static final String AMAPKEY = "24c64b84e1d42b6858387de12d60e8ae";

    //SharedPreferences名称
    public static final String SP_NAME = "Campus";


    /**
     * 模拟登录相关URL
     */
    // 用于SharedPreferences保存程序状态文件时
    public static final String APP_DATA = "app_data";
    public static final String FIRST_INSTALL = "first_install";
    public static final String TIME_OF_ENROLLMENT = "time_of_enrollment";


    // 要查询的信息的类型
    public static final int SEARCH_SCHEDULE = 1;
    public static final int SEARCH_SCORE = 2;

    // Jsoup解析后传递的Map所用的key值
    public static final String STUDENTNAME = "studentName";
    public static final String FAILEDINFO = "failedInfo";

    /**
     * 验证码网址
     */
    public static final String VERIFICATION_CODE_URL = "http://jwgl.fafu.edu.cn/(bx01nz55jvuxd055gohnru55)/CheckCode.aspx?";
    /**
     * 教务系统登录界面网址
     */
    public static final String EDUCATION_SYSTEM_LOGIN_URL = "http://jwgl.fafu.edu.cn/(bx01nz55jvuxd055gohnru55)/";
    /**
     * 查询课表的网址
     */
    public static final String SEARCH_SCHEDULE_URL = "http://jwgl.fafu.edu.cn/(bx01nz55jvuxd055gohnru55)/xskbcx.aspx?xh=" + Constants.LOGIN_BODY_NAME_USERNAME + "&xm=" + Constants.STUDENTNAME + "&gnmkdm=N121603";
    /**
     * 查询成绩的网址
     */
    public static final String SEARCH_SCORE_URL = "http://jwgl.fafu.edu.cn/(bx01nz55jvuxd055gohnru55)/xscjcx_dq.aspx?xh=" + Constants.LOGIN_BODY_NAME_USERNAME + "&xm=" + Constants.STUDENTNAME + "&gnmkdm=N121605";

    // 请求头
    public static final String HEADER_NAME_HOST = "Host";
    public static final String HEADER_VALUE_HOST = "jwgl.fafu.edu.cn";
    public static final String HEADER_NAME_REFERER ="Referer";
    public static final String HEADER_VALUE_REFERER ="http://jwgl.fafu.edu.cn/(bx01nz55jvuxd055gohnru55)/";
    public static final String HEADER_NAME_AGENT ="User-Agent";
    public static final String HEADER_VALUE_AGENT ="Mozilla/5.0 (Windows NT 10.0; WOW64; rv:51.0) Gecko/20100101 Firefox/51.0";
    // 登录时的请求参数
    public static final String LOGIN_BODY_NAME_VIEWSTATE = "__VIEWSTATE";
    public static final String LOGIN_BODY_VALUE_VIEWSTATE = "dDwyODE2NTM0OTg7Oz5xQU1YXNHacgTbKvSXBd9SngM+XA==";
    public static final String LOGIN_BODY_NAME_VIEWSTATEGENERATOR = "__VIEWSTATEGENERATOR";
    public static final String LOGIN_BODY_VALUE_VIEWSTATEGENERATOR = "92719903";
    public static final String LOGIN_BODY_NAME_BUTTON1 = "Button1";
    public static final String LOGIN_BODY_VALUE_BUTTON1 = "";
    public static final String LOGIN_BODY_NAME_HIDPDRS = "hidPdrs";
    public static final String LOGIN_BODY_VALUE_HIDPDRS = "";
    public static final String LOGIN_BODY_NAME_HIDSC = "hidsc";
    public static final String LOGIN_BODY_VALUE_HIDSC = "";
    public static final String LOGIN_BODY_NAME_LANGUAGE = "lbLanguage";
    public static final String LOGIN_BODY_VALUE_LANGUAGE = "";
    public static final String LOGIN_BODY_NAME_TYPE = "RadioButtonList1";
    public static final String LOGIN_BODY_VALUE_TYPE = "学生";
    public static final String LOGIN_BODY_NAME_PASSWORD = "TextBox2";
    public static final String LOGIN_BODY_NAME_SECRETCODE = "txtSecretCode";
    public static final String LOGIN_BODY_NAME_USERNAME = "txtUserName";
    // 查询课表时的请求参数
    public static final String SCHEDULE_BODY_NAME_EVENTARGUMENT = "__EVENTARGUMENT";
    public static final String SCHEDULE_BODY_VALUE_EVENTARGUMENT = "";
    public static final String SCHEDULE_BODY_NAME_EVENTTARGET = "__EVENTTARGET";
    public static final String SCHEDULE_BODY_VALUE_EVENTTARGET = "xqd";
    public static final String SCHEDULE_BODY_NAME_VIEWSTATE = "__VIEWSTATE";
    public static final String SCHEDULE_BODY_VALUE_VIEWSTATE ="dDwzOTI4ODU2MjU7dDw7bDxpPDE+Oz47bDx0PDtsPGk8MT47aTwyPjtpPDQ+O2k8Nz47aTw5PjtpPDExPjtpPDEzPjtpPDE1PjtpPDI0PjtpPDI2PjtpPDI4PjtpPDMwPjtpPDMyPjtpPDM0Pjs+O2w8dDxwPHA8bDxUZXh0Oz47bDwwMjAxMy0yMDE0Mjs+Pjs+Ozs+O3Q8dDxwPHA8bDxEYXRhVGV4dEZpZWxkO0RhdGFWYWx1ZUZpZWxkOz47bDx4bjt4bjs+Pjs+O3Q8aTw0PjtAPDIwMTYtMjAxNzsyMDE1LTIwMTY7MjAxNC0yMDE1OzIwMTMtMjAxNDs+O0A8MjAxNi0yMDE3OzIwMTUtMjAxNjsyMDE0LTIwMTU7MjAxMy0yMDE0Oz4+O2w8aTwwPjs+Pjs7Pjt0PHQ8OztsPGk8MT47Pj47Oz47dDxwPHA8bDxUZXh0Oz47bDzlrablj7fvvJozMTM1NzA2MDAyOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDzlp5PlkI3vvJrpg5HnjrDlj4s7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOWtpumZou+8mui1hOa6kOS4jueOr+Wig+WtpumZojs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w85LiT5Lia77ya56m66Ze05L+h5oGv5LiO5pWw5a2X5oqA5pyvOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDzooYzmlL/nj63vvJoxM+epuumXtOaVsOWtlzHnj607Pj47Pjs7Pjt0PDtsPGk8MT47PjtsPHQ8QDA8Ozs7Ozs7Ozs7Oz47Oz47Pj47dDxwPGw8VmlzaWJsZTs+O2w8bzxmPjs+PjtsPGk8MT47PjtsPHQ8QDA8Ozs7Ozs7Ozs7Oz47Oz47Pj47dDxAMDxwPHA8bDxQYWdlQ291bnQ7XyFJdGVtQ291bnQ7XyFEYXRhU291cmNlSXRlbUNvdW50O0RhdGFLZXlzOz47bDxpPDE+O2k8MD47aTwwPjtsPD47Pj47Pjs7Ozs7Ozs7Ozs+Ozs+O3Q8QDA8cDxwPGw8UGFnZUNvdW50O18hSXRlbUNvdW50O18hRGF0YVNvdXJjZUl0ZW1Db3VudDtEYXRhS2V5czs+O2w8aTwxPjtpPDQ+O2k8ND47bDw+Oz4+Oz47Ozs7Ozs7Ozs7PjtsPGk8MD47PjtsPHQ8O2w8aTwxPjtpPDI+O2k8Mz47aTw0Pjs+O2w8dDw7bDxpPDA+O2k8MT47aTwyPjtpPDM+O2k8ND47aTw1PjtpPDY+Oz47bDx0PHA8cDxsPFRleHQ7PjtsPOavleS4muiuvuiuoe+8iOiuuuaWh++8iTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w86Z+m57qiOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwzLjA7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDA1LTExOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4+Oz47Oz47Pj47dDw7bDxpPDA+O2k8MT47aTwyPjtpPDM+O2k8ND47aTw1PjtpPDY+Oz47bDx0PHA8cDxsPFRleHQ7PjtsPOavleS4muWunuS5oDs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w86Z+m57qiOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwyLjAwOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwwMS0wNDs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+Oz4+O3Q8O2w8aTwwPjtpPDE+O2k8Mj47aTwzPjtpPDQ+O2k8NT47aTw2Pjs+O2w8dDxwPHA8bDxUZXh0Oz47bDzlvaLlir/kuI7mlL/nrZbmlZnlrablrp7ot7U7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOW8oOmUpuiJszs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8MS4wMDs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8MDEtMjU7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjs+Pjt0PDtsPGk8MD47aTwxPjtpPDI+O2k8Mz47aTw0PjtpPDU+O2k8Nj47PjtsPHQ8cDxwPGw8VGV4dDs+O2w85LiT5Lia5Z+65pys5oqA6IO957u85ZCI6ICD5qC4Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDzpgrHpvpnpnJ47Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDEuMDs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8MDEtMTc7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjs+Pjs+Pjs+Pjt0PEAwPHA8cDxsPFBhZ2VDb3VudDtfIUl0ZW1Db3VudDtfIURhdGFTb3VyY2VJdGVtQ291bnQ7RGF0YUtleXM7PjtsPGk8MT47aTwwPjtpPDA+O2w8Pjs+Pjs+Ozs7Ozs7Ozs7Oz47Oz47dDxAMDxwPHA8bDxQYWdlQ291bnQ7XyFJdGVtQ291bnQ7XyFEYXRhU291cmNlSXRlbUNvdW50O0RhdGFLZXlzOz47bDxpPDE+O2k8ND47aTw0PjtsPD47Pj47Pjs7Ozs7Ozs7Ozs+O2w8aTwwPjs+O2w8dDw7bDxpPDE+O2k8Mj47aTwzPjtpPDQ+Oz47bDx0PDtsPGk8MD47aTwxPjtpPDI+O2k8Mz47aTw0Pjs+O2w8dDxwPHA8bDxUZXh0Oz47bDwyMDE2LTIwMTc7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDI7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOavleS4muiuvuiuoe+8iOiuuuaWh++8iTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w86Z+m57qiOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwzLjA7Pj47Pjs7Pjs+Pjt0PDtsPGk8MD47aTwxPjtpPDI+O2k8Mz47aTw0Pjs+O2w8dDxwPHA8bDxUZXh0Oz47bDwyMDE2LTIwMTc7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDI7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOavleS4muWunuS5oDs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w86Z+m57qiOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwyLjAwOz4+Oz47Oz47Pj47dDw7bDxpPDA+O2k8MT47aTwyPjtpPDM+O2k8ND47PjtsPHQ8cDxwPGw8VGV4dDs+O2w8MjAxNi0yMDE3Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwyOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDzlvaLlir/kuI7mlL/nrZbmlZnlrablrp7ot7U7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOW8oOmUpuiJszs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8MS4wMDs+Pjs+Ozs+Oz4+O3Q8O2w8aTwwPjtpPDE+O2k8Mj47aTwzPjtpPDQ+Oz47bDx0PHA8cDxsPFRleHQ7PjtsPDIwMTYtMjAxNzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Mjs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w85LiT5Lia5Z+65pys5oqA6IO957u85ZCI6ICD5qC4Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDzpgrHpvpnpnJ47Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDEuMDs+Pjs+Ozs+Oz4+Oz4+Oz4+Oz4+Oz4+Oz7Kh/fW3LSeDC4pRPf+/TnNe7Teqg==";
    public static final String SCHEDULE_BODY_NAME_VIEWSTATEGENERATOR = "__VIEWSTATEGENERATOR";
    public static final String SCHEDULE_BODY_VALUE_VIEWSTATEGENERATOR = "55530A43";
    public static final String SCHEDULE_BODY_NAME_SCHOOLYEAR = "xnd";
    public static final String SCHEDULE_BODY_NAME_TERM = "xqd";
    // 查询成绩时的请求参数
    public static final String SCORE_BODY_NAME_EVENTARGUMENT = "__EVENTARGUMENT";
    public static final String SCORE_BODY_VALUE_EVENTARGUMENT = "";
    public static final String SCORE_BODY_NAME_EVENTTARGET = "__EVENTTARGET";
    public static final String SCORE_BODY_VALUE_EVENTTARGET = "";
    public static final String SCORE_BODY_NAME_VIEWSTATE = "__VIEWSTATE";
    public static final String SCORE_BODY_VALUE_VIEWSTATE ="dDwxMDk5MDkzODA4O3Q8cDxsPHRqcXI7PjtsPDA7Pj47bDxpPDE+Oz47bDx0PDtsPGk8MT47aTw3PjtpPDk+Oz47bDx0PHQ8O3Q8aTwxOD47QDzlhajpg6g7MjAwMS0yMDAyOzIwMDItMjAwMzsyMDAzLTIwMDQ7MjAwNC0yMDA1OzIwMDUtMjAwNjsyMDA2LTIwMDc7MjAwNy0yMDA4OzIwMDgtMjAwOTsyMDA5LTIwMTA7MjAxMC0yMDExOzIwMTEtMjAxMjsyMDEyLTIwMTM7MjAxMy0yMDE0OzIwMTQtMjAxNTsyMDE1LTIwMTY7MjAxNi0yMDE3OzIwMTctMjAxODs+O0A85YWo6YOoOzIwMDEtMjAwMjsyMDAyLTIwMDM7MjAwMy0yMDA0OzIwMDQtMjAwNTsyMDA1LTIwMDY7MjAwNi0yMDA3OzIwMDctMjAwODsyMDA4LTIwMDk7MjAwOS0yMDEwOzIwMTAtMjAxMTsyMDExLTIwMTI7MjAxMi0yMDEzOzIwMTMtMjAxNDsyMDE0LTIwMTU7MjAxNS0yMDE2OzIwMTYtMjAxNzsyMDE3LTIwMTg7Pj47Pjs7Pjt0PDtsPGk8MD47aTwxPjtpPDI+Oz47bDx0PDtsPGk8MD47PjtsPHQ8cDxsPGlubmVyaHRtbDs+O2w8MjAxNi0yMDE35a2m5bm056ysMuWtpuacn+WtpuS5oOaIkOe7qTs+Pjs7Pjs+Pjt0PDtsPGk8MD47aTwxPjtpPDI+Oz47bDx0PHA8bDxpbm5lcmh0bWw7PjtsPOWtpuWPt++8mjMxMzU3MDYwMDI7Pj47Oz47dDxwPGw8aW5uZXJodG1sOz47bDzlp5PlkI3vvJrpg5HnjrDlj4s7Pj47Oz47dDxwPGw8aW5uZXJodG1sOz47bDzlrabpmaLvvJrotYTmupDkuI7njq/looPlrabpmaI7Pj47Oz47Pj47dDw7bDxpPDA+O2k8MT47PjtsPHQ8cDxsPGlubmVyaHRtbDs+O2w85LiT5Lia77ya56m66Ze05L+h5oGv5LiO5pWw5a2X5oqA5pyvOz4+Ozs+O3Q8cDxsPGlubmVyaHRtbDs+O2w86KGM5pS/54+t77yaMTPnqbrpl7TmlbDlrZcx54+tOz4+Ozs+Oz4+Oz4+O3Q8QDA8cDxwPGw8UGFnZUNvdW50O18hSXRlbUNvdW50O18hRGF0YVNvdXJjZUl0ZW1Db3VudDtEYXRhS2V5czs+O2w8aTwxPjtpPDA+O2k8MD47bDw+Oz4+Oz47QDA8Ozs7Ozs7Ozs7Ozs7Ozs7OztAMDxwPGw8VmlzaWJsZTs+O2w8bzxmPjs+Pjs7Ozs+Ozs7Ozs+Ozs7Ozs7Ozs7Pjs7Pjs+Pjs+Pjs+MOofz7TLvLN7B7ARL/LnsARQfBQ=";
    public static final String SCORE_BODY_NAME_VIEWSTATEGENERATOR = "__VIEWSTATEGENERATOR";
    public static final String SCORE_BODY_VALUE_VIEWSTATEGENERATOR = "EC2DE6FD";
    public static final String SCORE_BODY_NAME_SCHOOLYEAR = "ddlxn";
    public static final String SCORE_BODY_NAME_TERM = "ddlxq";
    public static final String SCORE_BODY_NAME_BTNCX = "btnCx";
    public static final String SCORE_BODY_VALUE_BTNCX = "+%B2%E9++%D1%AF+";
}
