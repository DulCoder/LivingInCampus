package com.fafu.zhengxianyou.livingincampus.bean;

/**
 * Created by zhengxianyou on 2017/1/7.
 */

public class ClassifyBean {
    private int imageId;
    private int name;

    public ClassifyBean(int imageId, int name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public int getName() {
        return name;
    }
}
