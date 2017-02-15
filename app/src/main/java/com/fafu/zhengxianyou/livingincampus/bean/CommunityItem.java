package com.fafu.zhengxianyou.livingincampus.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by zhengxianyou on 2017/2/14.
 */

public class CommunityItem extends BmobObject{
    private MyUser author;            //作者
    private String myIcon;            //头像
    private String nickName;          //昵称
    private String datetime;          //发布时间
    private String content;           //发布内容
    private String like;              //点赞数量


    public void setAuthor(MyUser author) {
        this.author = author;
    }

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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
