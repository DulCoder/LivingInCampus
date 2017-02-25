package com.fafu.zhengxianyou.livingincampus.classify.course;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.adapter.ScoreAdapter;
import com.fafu.zhengxianyou.livingincampus.bean.Score;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends AppCompatActivity {
    private ArrayList<Score> scoreList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_score);

        init();
        initAdapter();
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
//            this.finish();
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//
//    }

    /**
     * 通过调用这个方法启动ScoreActivity
     */
    public static void actionStart(Context context, List<Score> scoreList) {
        Intent intent = new Intent(context, ScoreActivity.class);
        intent.putParcelableArrayListExtra("scoreList", (ArrayList<Score>) scoreList);
        context.startActivity(intent);
    }

    public void init() {
        Intent intent = ScoreActivity.this.getIntent();
        scoreList = intent.getParcelableArrayListExtra("scoreList");

        listView = (ListView) ScoreActivity.this.findViewById(R.id.score_listview);
    }

    private void initAdapter() {
        ScoreAdapter adapter  = new ScoreAdapter(this, scoreList);
        listView.setAdapter(adapter);
    }
}
