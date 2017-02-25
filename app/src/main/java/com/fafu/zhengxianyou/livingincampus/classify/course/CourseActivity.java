package com.fafu.zhengxianyou.livingincampus.classify.course;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.app.MyApplication;
import com.fafu.zhengxianyou.livingincampus.bean.Course;
import com.fafu.zhengxianyou.livingincampus.config.Config;
import com.fafu.zhengxianyou.livingincampus.constant.Constants;
import com.fafu.zhengxianyou.livingincampus.sqlite.DatabaseAdapter;

import java.util.List;

import static com.fafu.zhengxianyou.livingincampus.app.MyApplication.editor;

public class CourseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = CourseActivity.class.getSimpleName();
    private static final int UI = 0x1;
    private int gridHeight, gridWidth;
    private RelativeLayout layout;
    private RelativeLayout tmpLayout;
    private DatabaseAdapter mDatabaseAdapter = Config.getDatabaseAdapter();
    private List<Course> mCourseList = Config.getCourseList();
    private int size = mCourseList.size();
    private boolean isAddCourse = MyApplication.sp.getBoolean("isAddCourse", false);


    /**
     * 通过调用这个方法启动ScheduleActivity
     */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, CourseActivity.class);
        context.startActivity(intent);
    }

    /**
     * 主线程更改UI
     */
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == UI) {
                putData();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        tmpLayout = (RelativeLayout) findViewById(R.id.monday);
        navigationView.setNavigationItemSelectedListener(this);

        mHandler.sendEmptyMessageDelayed(UI, 500);   //异步导入数据
    }


    /**
     * 写入课程表数据
     */
    private void putData() {
        Log.e(TAG, "putData");
        Course c;
        for (int i = 0; i < size; i++) {
            c = mCourseList.get(i);
            Log.e(TAG, "logininnin");
            if (!isAddCourse) {
                mDatabaseAdapter.rawAdd(c);

            }
            String during = c.getDuring();
            int start, end;
            int index = during.indexOf("节");
            if (during.contains(",")) {
                String str = during.substring(0, index);
                String[] s = str.split(",");
                start = Integer.parseInt(s[0]);
                end = Integer.parseInt(s[s.length - 1]);
            } else {
                end = start = Integer.parseInt(during.substring(0, index));
            }
            addView(c.getWeekNumber(), start, end, c.getSubjectName() + "\n" + c.getClassroom());
        }
        editor.putBoolean("isAddCourse", true);
        editor.commit();
    }

    /**
     * 创建TextView
     *
     * @param start
     * @param end
     * @param text
     * @return
     */
    private TextView createTv(int start, int end, String text) {
        TextView tv = new TextView(this);
        /*
         指定高度和宽度
         */
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(gridWidth, gridHeight * (end - start + 1));
        /*
        指定位置
         */
        tv.setY(gridHeight * (start - 1));
        tv.setLayoutParams(params);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(10);
        tv.setText(text);
        return tv;
    }

    /**
     * 单节课程内容
     *
     * @param i
     * @param start
     * @param end
     * @param text
     */
    private void addView(int i, int start, int end, String text) {
        TextView tv;
        switch (i) {
            case 1:
                layout = (RelativeLayout) findViewById(R.id.monday);
                break;
            case 2:
                layout = (RelativeLayout) findViewById(R.id.tuesday);
                break;
            case 3:
                layout = (RelativeLayout) findViewById(R.id.wednesday);
                break;
            case 4:
                layout = (RelativeLayout) findViewById(R.id.thursday);
                break;
            case 5:
                layout = (RelativeLayout) findViewById(R.id.friday);
                break;
            case 6:
                layout = (RelativeLayout) findViewById(R.id.saturday);
                break;
            case 7:
                layout = (RelativeLayout) findViewById(R.id.sunday);
                break;
        }
        tv = createTv(start, end, text);
        tv.setBackgroundColor(Color.argb(200, 255, i * 35, start * 23));
        layout.addView(tv);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        gridWidth = tmpLayout.getWidth();
        gridHeight = tmpLayout.getHeight() / 12;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.re_import:
                CourseLoginActivity.actionStart(this, Constants.SEARCH_SCHEDULE);
                this.finish();
                break;
            case R.id.nav_manage:

                break;
            case R.id.score_search:
                CourseLoginActivity.actionStart(this, Constants.SEARCH_SCORE);
                this.finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}