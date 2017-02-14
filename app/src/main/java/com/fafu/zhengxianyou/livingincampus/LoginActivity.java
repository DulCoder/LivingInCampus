package com.fafu.zhengxianyou.livingincampus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fafu.zhengxianyou.livingincampus.fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }


    /**
     * 把Fragment放进宿主Activity；
     */
    private void init() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_ring_up_container,LoginFragment.newInstance())
                .commit();
    }
}
