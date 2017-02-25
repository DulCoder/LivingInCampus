package com.fafu.zhengxianyou.livingincampus.bean;


/**
 * Created by zhengxianyou on 2017/2/22.
 */

public class Course {
    private String subjectName;    //课程名称
    private int weekNumber;     //周几
    private String during;         //课程周期
    private String classroom;      //教室


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public String getDuring() {
        return during;
    }

    public void setDuring(String during) {
        this.during = during;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

}
