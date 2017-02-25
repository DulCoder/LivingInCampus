package com.fafu.zhengxianyou.livingincampus.sqlite;

import android.provider.BaseColumns;

/**
 * Created by zhengxianyou on 2017/2/24.
 */

public final class CourseMeteData {


    private CourseMeteData() {     //不给外界构造方法
    }


    public static class CourseTable implements BaseColumns {

        public static final String TABLE_NAME = "course";                                 //表名

        public static final String SUBJECT_NAME = "subjectName";                         //课程名称

        public static final String WEEK_NUMBER = "weekNumber";                           //周几

        public static final String DURING = "during";                                 //课程周期

        public static final String CLASSROOM = "classroom";                            //教室


    }
}
