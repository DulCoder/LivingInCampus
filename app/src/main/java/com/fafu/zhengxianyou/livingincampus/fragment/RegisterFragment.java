package com.fafu.zhengxianyou.livingincampus.fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;
import com.fafu.zhengxianyou.livingincampus.bean.MyUser;
import com.fafu.zhengxianyou.livingincampus.config.Config;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by zhengxianyou on 2017/2/4.
 */
public class RegisterFragment extends BaseFragment implements View.OnClickListener{
    private View mView;

    private EditText et_login, et_password, et_repassword, et_email, et_nick;
    private Button btn_logup;
    public String email;
    private ImageView iv_icon;
    private static final String DIALOG_ICON = "DialogIcon";
    private static final int REQUEST_ICON = 0;             //设置请求码


    /**
     * 返回创建fragment实例
     */
    public static RegisterFragment newInstance() {
        RegisterFragment mFragment = new RegisterFragment();
        return mFragment;
    }

    @Override
    protected View initView() {

        mView = View.inflate(mContext,R.layout.fragment_register, null);
        Config.setMyIcon("icon1");
        findView();
        return mView;
    }


    /**
     * 初始化view
     */
    private void findView() {
        et_login = (EditText) mView.findViewById(R.id.et_login);
        et_email = (EditText) mView.findViewById(R.id.et_email);
        et_password = (EditText) mView.findViewById(R.id.et_password);
        et_repassword = (EditText) mView.findViewById(R.id.et_repassword);
        et_nick = (EditText) mView.findViewById(R.id.et_nick);
        iv_icon = (ImageView) mView.findViewById(R.id.iv_icon);
        iv_icon.setOnClickListener(this);

        btn_logup = (Button) mView.findViewById(R.id.btn_logup);
        btn_logup.setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_ICON) {
//            int value = (Integer) data.getSerializableExtra(IconDialogFragment.EXTRA_ICON);
            String icon = Config.getMyIcon();
            switch (icon) {

                case "icon1":
                    iv_icon.setImageResource(R.drawable.icon1);

                    break;

                case "icon2":
                    iv_icon.setImageResource(R.drawable.icon2);

                    break;

                case "icon3":
                    iv_icon.setImageResource(R.drawable.icon3);

                    break;

                case "icon4":
                    iv_icon.setImageResource(R.drawable.icon4);

                    break;

                case "icon5":
                    iv_icon.setImageResource(R.drawable.icon5);

                    break;

                case "icon6":
                    iv_icon.setImageResource(R.drawable.icon6);

                    break;

                case "icon7":
                    iv_icon.setImageResource(R.drawable.icon7);

                    break;

                case "icon8":
                    iv_icon.setImageResource(R.drawable.icon8);

                    break;

                case "icon9":
                    iv_icon.setImageResource(R.drawable.icon9);

                    break;

                default:

                    break;
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_logup:
                String login = et_login.getText().toString();
                String password = et_password.getText().toString();
                String repassword = et_repassword.getText().toString();
                String nickName = et_nick.getText().toString();
                Config.setNickName(nickName);
                String myIcon = Config.getMyIcon();

                if (!TextUtils.isEmpty(login) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(repassword) && !TextUtils.isEmpty(nickName)) {
                    if (password.equals(repassword)) {
                        register(login, password, nickName, myIcon);
                    } else {
                        toast("您输入的密码不一致");
                    }

                } else {

                    toast("输入框不能为空");
                }

                break;

            case R.id.iv_icon:
                FragmentManager manager = getFragmentManager();
                IconDialogFragment dialogFragment = IconDialogFragment.newInstance();
                dialogFragment.setTargetFragment(RegisterFragment.this, REQUEST_ICON);   //设置目标Fragment
                dialogFragment.show(manager, DIALOG_ICON);
                break;
        }
    }

    /**
     * 注册相关逻辑
     */
    private void register(String login, String password, String nickName, String myIcon) {
        MyUser user = new MyUser();
        email = et_email.getText().toString();
        user.setEmail(email);
        user.setNickName(nickName);
        user.setMyIcon(myIcon);

        user.setUsername(login);
        user.setPassword(password);

        try {

            user.signUp(new SaveListener<MyUser>() {
                @Override
                public void done(MyUser myUser, BmobException e) {
                    if (e == null) {
                        toast("注册成功");
                        goBack();
                    } else {

                        int error = e.getErrorCode();
                        toast("e" + error);
                    }
                }
            });

        } catch (Exception exception) {
            Log.e("ERROR", exception.getMessage());
        }
    }

    private void goBack() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_ring_up_container, LoginFragment.newInstance())
                .commit();
    }


    /**
     * 封装一个Toast,减少代码重复
     */
    private void toast(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();

    }
}
