package com.fafu.zhengxianyou.livingincampus;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fafu.zhengxianyou.livingincampus.utils.Utils;

public class CourseActivity extends Activity implements View.OnClickListener {
    private EditText userName,passWord;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                login();
                break;
        }
    }

    /**
     * 登录相关逻辑
     */
    private void login() {
        String user = userName.getText().toString();
        String password = passWord.getText().toString();
        if (!TextUtils.isEmpty(user)&&!TextUtils.isEmpty(password)){

        }else {
            Utils.toast(this,"请把信息填写完整");
        }

    }
}
