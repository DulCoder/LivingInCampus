package com.fafu.zhengxianyou.livingincampus.fragment;

import android.view.View;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;

/**
 * Created by zhengxianyou on 2017/1/2.
 */

public class UserFragment extends BaseFragment{
    private View mView;
    /**
     *创建返回实例
     */
    public static UserFragment newInstance() {

        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    protected View initView() {
        mView = View.inflate(mContext, R.layout.fragment_user,null);
        return mView;
    }
}
