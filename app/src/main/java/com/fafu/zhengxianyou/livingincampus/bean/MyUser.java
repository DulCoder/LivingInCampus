package com.fafu.zhengxianyou.livingincampus.bean;

import cn.bmob.v3.BmobUser;

/**
 * Created by zhengxianyou on 2017/2/3.
 * 用于账号注册，
 * 可以在这里添加用户的属性，年龄、昵称等
 */

public class MyUser extends BmobUser{

    private  String nickName;
    private String myIcon;

    public String getMyIcon() {
        return myIcon;
    }

    public void setMyIcon(String myIcon) {
        this.myIcon = myIcon;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
