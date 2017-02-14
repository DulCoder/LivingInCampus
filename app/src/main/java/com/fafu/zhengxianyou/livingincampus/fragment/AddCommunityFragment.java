package com.fafu.zhengxianyou.livingincampus.fragment;

import android.view.View;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;

/**
 * Created by zhengxianyou on 2017/2/13.
 */

public class AddCommunityFragment extends BaseFragment {
    private View mView;

    /**
     * 返回创建fragment实例
     */
    public static AddCommunityFragment newInstance() {
        AddCommunityFragment mFragment = new AddCommunityFragment();
        return mFragment;
    }

    @Override
    protected View initView() {
        mView = View.inflate(mContext, R.layout.community_item_rv,null);

//mView.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        getFragmentManager()
//                .beginTransaction()
//                .replace(R.id.community_container,CommunityFragment.newInstance())
//                .commit();
//    }
//});
        return mView;
    }
}
