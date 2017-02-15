package com.fafu.zhengxianyou.livingincampus.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.base.BaseFragment;
import com.fafu.zhengxianyou.livingincampus.bean.CommunityItem;
import com.fafu.zhengxianyou.livingincampus.bean.MyUser;
import com.fafu.zhengxianyou.livingincampus.config.Config;
import com.fafu.zhengxianyou.livingincampus.utils.Utils;

import java.text.DateFormat;
import java.util.Date;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by zhengxianyou on 2017/2/13.
 */

public class AddCommunityFragment extends BaseFragment implements View.OnClickListener {
    private View mView;
    private EditText etCommunity;
    private Button btn_publish;
    private String icon, nickname, datetime, content;

    /**
     * 返回创建fragment实例
     */
    public static AddCommunityFragment newInstance() {
        AddCommunityFragment mFragment = new AddCommunityFragment();
        return mFragment;
    }

    @Override
    protected View initView() {
        mView = View.inflate(mContext, R.layout.fragment_community_add, null);

        findViews();

        return mView;
    }

    /**
     * 初始化View
     */
    private void findViews() {
        etCommunity = (EditText) mView.findViewById(R.id.et_community);
        btn_publish = (Button) mView.findViewById(R.id.btn_publish);

        btn_publish.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == btn_publish) {
            publish();
        }
    }

    /**
     * 发布信息的相关逻辑
     */
    private void publish() {
        icon = Config.getMyIcon();
        nickname = Config.getNickName();
        if (icon != null && nickname != null) {  //判断是否登录
            content = etCommunity.getText().toString();
            if (TextUtils.isEmpty(content)) {
                Utils.toast(mContext, "输入不能为空");

            } else if (content.length() > 140) {
                Utils.toast(mContext, "内容字数不能大于140");

            } else {

                Date date = new Date();
                DateFormat format = DateFormat.getDateTimeInstance();
                datetime = format.format(date);            //获取当前时间
                MyUser user = BmobUser.getCurrentUser(MyUser.class);

                final CommunityItem communityItem = new CommunityItem();
                communityItem.setMyIcon(icon);
                communityItem.setNickName(nickname);
                communityItem.setDatetime(datetime);
                communityItem.setContent(content);
                communityItem.setAuthor(user);

                communityItem.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e != null){
                            Utils.toast(mContext,e.getErrorCode()+e.getMessage());
                        }else {
                            getFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.community_container, CommunityFragment.newInstance())
                                    .commit();
                        }
                    }
                });
            }

        } else {
            Utils.toast(mContext, "请登录");
        }
    }


}
