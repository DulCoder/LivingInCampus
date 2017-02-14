package com.fafu.zhengxianyou.livingincampus.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;

/**
 * Created by zhengxianyou on 2017/2/13.
 */

public class CommunityFragment extends BaseFragment implements View.OnClickListener {
    private View mView;
    private RecyclerView rv_community;
    private FloatingActionButton fab;
    private static final String TAG = CommunityFragment.class.getSimpleName();

    /**
     * 返回创建fragment实例
     */
    public static CommunityFragment newInstance() {
        CommunityFragment mFragment = new CommunityFragment();
        return mFragment;
    }


    @Override
    protected View initView() {
        mView = View.inflate(mContext, R.layout.fragment_community, null);

        rv_community = (RecyclerView) mView.findViewById(R.id.rv_community);
        rv_community.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        fab = (FloatingActionButton) mView.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                getFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                        .replace(R.id.community_container, AddCommunityFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
                break;
//            case R.id.
        }
    }
}
