package com.fafu.zhengxianyou.livingincampus.fragment.login;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.fafu.zhengxianyou.livingincampus.app.MyApplication;
import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;
import com.fafu.zhengxianyou.livingincampus.bean.MyUser;
import com.fafu.zhengxianyou.livingincampus.utils.Utils;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static com.fafu.zhengxianyou.livingincampus.app.MyApplication.editor;

/**
 * Created by zhengxianyou on 2017/2/3.
 */

public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private View v;

    private EditText et_login, et_password;
    private Button btn_logup, btn_login;
    private TextView tv_forget;
    private CheckBox cb_choice;

    /**
     * 返回创建fragment实例
     */
    public static LoginFragment newInstance() {
        LoginFragment mFragment = new LoginFragment();
        return mFragment;
    }


    @Override
    protected View initView() {
        v = View.inflate(mContext, R.layout.fragment_login, null);

        findView();
        getJudge();
        return v;
    }

    /**
     * 判断是否保存密码
     */
    private void getJudge() {
        boolean isChecked = MyApplication.sp.getBoolean("isChecked", false);
        if (isChecked) {
            String name = MyApplication.sp.getString("name", null);
            String password = MyApplication.sp.getString("password", null);

            et_login.setText(name);
            et_password.setText(password);
            cb_choice.setChecked(true);
        }

    }

    /**
     * 初始化view
     */
    private void findView() {

        et_login = (EditText) v.findViewById(R.id.et_login);
        et_password = (EditText) v.findViewById(R.id.et_password);

        btn_logup = (Button) v.findViewById(R.id.btn_logup);
        btn_logup.setOnClickListener(this);

        btn_login = (Button) v.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        tv_forget = (TextView) v.findViewById(R.id.tv_forget);
        tv_forget.setOnClickListener(this);

        cb_choice = (CheckBox) v.findViewById(R.id.cb_choice);
        cb_choice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cb_choice.setChecked(true);
                } else {

                }
            }
        });


    }

    /**
     * 点击事件
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_login:
                Utils.toast(getContext(), "Login");
                login();

                break;
            case R.id.btn_logup:
                //跳转到注册界面
                goRegister();

                break;
            case R.id.tv_forget:
                //跳转到找回密码界面
                goForget();

                break;

        }
    }

    /**
     * 跳转到找回密码界面
     */
    private void goForget() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_ring_up_container, new ForgetFragment())
                .addToBackStack(null)
                .commit();
    }

    /**
     * 跳转到注册界面
     */
    private void goRegister() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_ring_up_container, RegisterFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }


    /**
     * 登录相关逻辑
     */
    String name, password;

    private void login() {
        name = et_login.getText().toString();
        password = et_password.getText().toString();
        final MyUser user = new MyUser();

        user.setUsername(name);
        user.setPassword(password);
        user.login(new SaveListener<MyUser>() {
            @Override
            public void done(MyUser myUser, BmobException e) {
                try {
                    if (e == null) {
                        MyApplication.editor.putBoolean("isChecked", cb_choice.isChecked());
                        if (cb_choice.isChecked()) {
                            editor.putString("name", name);
                            editor.putString("password", password);
                        }
                        String icon = myUser.getMyIcon();
                        String nickName = myUser.getNickName();

                        editor.putString("icon", icon);
                        editor.putString("nickName", nickName);
                        editor.commit();

                        getActivity().finish();
                    } else {
                        Log.e("err1", e.getErrorCode() + "" + e.getMessage());
                    }

                } catch (Exception exception) {
                    Log.e("err", exception.getMessage() + "");
                    Utils.toast(mContext,"正在登录");
                }
            }
        });

    }


}
