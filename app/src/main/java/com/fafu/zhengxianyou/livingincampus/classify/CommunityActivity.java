package com.fafu.zhengxianyou.livingincampus.classify;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.fragment.CommunityFragment;

public class CommunityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        addFragment();
    }

    /**
     * 添加Fragment
     */
    private void addFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.community_container,CommunityFragment.newInstance(),null)
                .commit();
    }

}
