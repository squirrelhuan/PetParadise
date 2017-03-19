package com.huan.administrator.petparadise.bean;

/**
 * 宠物技能
 * Created by Administrator on 2017/3/18.
 */
public class PetSkill {
    private int Type;
    private String HeadImage;
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getHeadImage() {
        return HeadImage;
    }

    public void setHeadImage(String headImage) {
        HeadImage = headImage;
    }
}
