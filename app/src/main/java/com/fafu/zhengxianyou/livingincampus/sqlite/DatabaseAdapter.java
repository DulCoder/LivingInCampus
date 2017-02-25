package com.fafu.zhengxianyou.livingincampus.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.fafu.zhengxianyou.livingincampus.bean.Course;

import java.util.ArrayList;

/**
 * Created by zhengxianyou on 2016/11/28.
 */

public class DatabaseAdapter {
    private DatabaseHelper dbHelper;

    public DatabaseAdapter(Context context) {
        dbHelper = new DatabaseHelper(context);
    }


    //增
    public void rawAdd(Course course){
        String sql = "insert or ignore into " + CourseMeteData.CourseTable.TABLE_NAME +
                "(subjectName,weekNumber,during,classroom) values (?,?,?,?)";
        Object[] args = {course.getSubjectName(),course.getWeekNumber(),course.getDuring(),course.getClassroom()};

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(sql, args);
        Log.e("TAGGG","rawAdd");
        db.close();
    }


    //删(清空表中数据)
    public void rawDelete() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "delete from " + CourseMeteData.CourseTable.TABLE_NAME;
        db.execSQL(sql);
        db.close();
        Log.e("TAGGGG","rawDelete");
    }

    //查所有
    public ArrayList<Course> queryAll() {
        Log.e("TAGGGG","SQL1");
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Log.e("TAGGGG","SQL2");
//        String[] columns ={ NoteMeteData.NoteTable._ID, NoteMeteData.NoteTable.TITLE, NoteMeteData.NoteTable.WEATHER, NoteMeteData.NoteTable.DATE, NoteMeteData.NoteTable.CONTENT};
        //是否去除重复记录，表名，要查询的列，查询条件，查询条件的值，分组条件，分组条件的值，排序，分页条件
        Cursor c = db.query(true, CourseMeteData.CourseTable.TABLE_NAME, null, null, null, null, null, null, null);

        ArrayList<Course> courses = new ArrayList<>();

        while (c.moveToNext()) {
            Course course = new Course();
            course.setSubjectName(c.getString(c.getColumnIndexOrThrow(CourseMeteData.CourseTable.SUBJECT_NAME)));
            course.setWeekNumber(c.getInt(c.getColumnIndexOrThrow(CourseMeteData.CourseTable.WEEK_NUMBER)));
            course.setDuring(c.getString(c.getColumnIndexOrThrow(CourseMeteData.CourseTable.DURING)));
            course.setClassroom(c.getString(c.getColumnIndexOrThrow(CourseMeteData.CourseTable.CLASSROOM)));
            courses.add(course);
        }
        c.close();
        db.close();
        return courses;
    }

}