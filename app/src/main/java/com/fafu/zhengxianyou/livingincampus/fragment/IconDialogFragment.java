package com.fafu.zhengxianyou.livingincampus.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.config.Config;
import com.fafu.zhengxianyou.livingincampus.utils.Utils;

/**
 * Created by zhengxianyou on 2017/2/4.
 */

public class IconDialogFragment extends DialogFragment implements View.OnClickListener {
    private View mView;
    private Button icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9;

    public static final String EXTRA_ICON = "com.fafu.kongshu.zhengxianyou.pinke.icon";   //键/key
    private static final int VALUE = 1;

    /**
     * 返回创建fragment实例
     */
    public static IconDialogFragment newInstance() {
        IconDialogFragment iconDialogFragment = new IconDialogFragment();
        return iconDialogFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        mView = inflater.inflate(R.layout.dialogfragment_icon, null);
        initView();

        Config.setMyIcon("icon1");
        builder.setView(mView)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        sendResult(Activity.RESULT_OK,VALUE);   //传递数据
                    }
                }).setNegativeButton("取消", null);

        return builder.create();
    }

    /**
     * 初始化View及设置点击事件
     */
    private void initView() {
        icon1 = (Button) mView.findViewById(R.id.icon_1);
        icon2 = (Button) mView.findViewById(R.id.icon_2);
        icon3 = (Button) mView.findViewById(R.id.icon_3);
        icon4 = (Button) mView.findViewById(R.id.icon_4);
        icon5 = (Button) mView.findViewById(R.id.icon_5);
        icon6 = (Button) mView.findViewById(R.id.icon_6);
        icon7 = (Button) mView.findViewById(R.id.icon_7);
        icon8 = (Button) mView.findViewById(R.id.icon_8);
        icon9 = (Button) mView.findViewById(R.id.icon_9);

        icon1.setOnClickListener(this);
        icon2.setOnClickListener(this);
        icon3.setOnClickListener(this);
        icon4.setOnClickListener(this);
        icon5.setOnClickListener(this);
        icon6.setOnClickListener(this);
        icon7.setOnClickListener(this);
        icon8.setOnClickListener(this);
        icon9.setOnClickListener(this);
    }

    /**
     * 设置回调目标，传递数据
     * @param resultCode  :结果码
     * @param icon        :被传递的值
     */
    private void sendResult(int resultCode,int icon){
        if (getTargetFragment() == null){
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_ICON,icon);

        getTargetFragment()
                .onActivityResult(getTargetRequestCode(),resultCode,intent);
    }


    /**
     * 点击事件监听
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon_1:

               Config.setMyIcon("icon1");
                Utils.toast(getActivity(),"已选中icon1");
                break;
            case R.id.icon_2:
                Config.setMyIcon("icon2");
                Utils.toast(getActivity(),"已选中icon2");
                break;
            case R.id.icon_3:
                Config.setMyIcon("icon3");
                Utils.toast(getActivity(),"已选中icon3");
                break;
            case R.id.icon_4:
                Config.setMyIcon("icon4");
                Utils.toast(getActivity(),"已选中icon4");
                break;
            case R.id.icon_5:
                Config.setMyIcon("icon5");
                Utils.toast(getActivity(),"已选中icon5");
                break;
            case R.id.icon_6:
                Config.setMyIcon("icon6");
                Utils.toast(getActivity(),"已选中icon6");
                break;
            case R.id.icon_7:
                Config.setMyIcon("icon7");
                Utils.toast(getActivity(),"已选中icon7");
                break;
            case R.id.icon_8:
                Config.setMyIcon("icon8");
                Utils.toast(getActivity(),"已选中icon8");
                break;
            case R.id.icon_9:
                Config.setMyIcon("icon9");
                Utils.toast(getActivity(),"已选中icon9");
                break;
            default:
                break;
        }

    }
}
