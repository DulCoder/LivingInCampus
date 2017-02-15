package com.fafu.zhengxianyou.livingincampus.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fafu.zhengxianyou.livingincampus.LoginActivity;
import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;
import com.fafu.zhengxianyou.livingincampus.bean.MyUser;
import com.fafu.zhengxianyou.livingincampus.config.Config;

/**
 * Created by zhengxianyou on 2017/1/2.
 */

public class UserFragment extends BaseFragment implements View.OnClickListener {
    private View mView;
    private ImageView myIcon;
    private TextView myId;
    private Button loginReg,changeIcon,changeID,logout;
    private static final String TAG = UserFragment.class.getSimpleName();


    /**
     *创建返回实例
     */
    public static UserFragment newInstance() {

        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Config.getNickName()!=null){
            myId.setText(Config.getNickName());
            loginReg.setClickable(false);
            logout.setVisibility(View.VISIBLE);
            String icon = Config.getMyIcon();
            switch (icon) {
                case "icon1":
                    myIcon.setImageResource(R.drawable.icon1);

                    break;
                case "icon2":
                    myIcon.setImageResource(R.drawable.icon2);

                    break;
                case "icon3":
                    myIcon.setImageResource(R.drawable.icon3);

                    break;
                case "icon4":
                    myIcon.setImageResource(R.drawable.icon4);

                    break;
                case "icon5":
                    myIcon.setImageResource(R.drawable.icon5);

                    break;
                case "icon6":
                    myIcon.setImageResource(R.drawable.icon6);

                    break;
                case "icon7":
                    myIcon.setImageResource(R.drawable.icon7);

                    break;
                case "icon8":
                    myIcon.setImageResource(R.drawable.icon8);

                    break;
                case "icon9":
                    myIcon.setImageResource(R.drawable.icon9);

                    break;
                default:
                    break;
            }
        }
        Log.e(TAG,"onResume");
    }

    @Override
    protected View initView() {
        mView = View.inflate(mContext, R.layout.fragment_user,null);

        findViews();
        return mView;
    }

    private void findViews() {
        myIcon = (ImageView)mView.findViewById( R.id.myIcon );
        myId = (TextView)mView.findViewById( R.id.myId );
        loginReg = (Button) mView.findViewById( R.id.login_reg );
        changeIcon = (Button) mView.findViewById( R.id.changeIcon );
        changeID = (Button) mView.findViewById( R.id.changeID );
        logout = (Button) mView.findViewById( R.id.logout );

        loginReg.setOnClickListener(this);
        changeIcon.setOnClickListener(this);
        changeID.setOnClickListener(this);
        logout.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_reg:
                startActivity(new Intent(mContext, LoginActivity.class));
                getActivity().finish();
                break;
            case R.id.changeIcon:

                break;
             case R.id.changeID:

                break;
             case R.id.logout:      //退出登录
                 logOff();
                break;

        }
    }

    /**
     * 退出登录相关
     */
    private void logOff() {
        MyUser user = new MyUser();
        user.logOut();
        loginReg.setClickable(true);
        logout.setVisibility(View.GONE);
        myIcon.setImageResource(R.drawable.overcast);
        myId.setText("未登录");
        Config.setMyIcon(null);
        Config.setNickName(null);
    }
}
