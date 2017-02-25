package com.fafu.zhengxianyou.livingincampus.fragment.login;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by zhengxianyou on 2017/2/4.
 */
public class ForgetFragment extends BaseFragment implements View.OnClickListener {
    private View view;
    private EditText et_find;
    private Button btn_find;
    private String email;


    @Override
    protected View initView() {
        view = View.inflate(mContext,R.layout.fragment_forget, null);

        findView();
        return view;
    }

    /**
     * 初始化view
     */
    private void findView() {
        et_find = (EditText) view.findViewById(R.id.et_find);
        btn_find = (Button) view.findViewById(R.id.btn_find);
        btn_find.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_find:
                findPassword();
                break;
        }
    }

    /**
     * 找回密码相关逻辑
     */
    private void findPassword() {
        email = et_find.getText().toString();
        if (TextUtils.isEmpty(email) | !email.contains("@")) {  //判断邮箱格式是否正确
            toast("邮箱输入错误");
        } else {
            BmobUser.resetPasswordByEmail(email, new UpdateListener() {
                @Override
                public void done(BmobException e) {
                    toast("验证邮件已经发送至邮箱");
                }
            });
        }
    }

    private void toast(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }
}
