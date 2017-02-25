package com.fafu.zhengxianyou.livingincampus.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhengxianyou on 2017/2/21.
 */

public class Score implements Parcelable {
    private String subject; // 课程名称
    private String category;// 课程类别
    private String score;// 成绩
    private String finalScore;// 总评成绩
    private String credit;// 学分
    private String gradePoint;// 绩点

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(String finalScore) {
        this.finalScore = finalScore;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(String gradePoint) {
        this.gradePoint = gradePoint;
    }

    // 以下为实现Parcelable接口必须实现的两个方法
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel arg0, int arg1) {
        arg0.writeString(subject);
        arg0.writeString(category);
        arg0.writeString(score);
        arg0.writeString(finalScore);
        arg0.writeString(credit);
        arg0.writeString(gradePoint);
    }

    // 自定义类型中必须含有一个名称为CREATOR的静态成员，该成员对象要求实现Parcelable.Creator接口及其方法。
    public static final Parcelable.Creator<Score> CREATOR = new Creator<Score>() {

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }

        @Override
        public Score createFromParcel(Parcel source) {
            Score score = new Score();
            score.subject = source.readString();
            score.category = source.readString();
            score.score = source.readString();
            score.finalScore = source.readString();
            score.credit = source.readString();
            score.gradePoint = source.readString();
            return score;
        }
    };
}
